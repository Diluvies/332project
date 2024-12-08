package distSorting.master

import scala.concurrent.{ExecutionContext, Future}
import scala.collection.mutable
import scala.concurrent.duration.Duration
import java.util.concurrent.locks.ReentrantReadWriteLock

import distSorting.network.{OperationResponse, OperationResponse, TaskResultReport}
import distSorting.network.ServerLifecycle

object MasterTaskHandler {
  private val lock = new ReentrantReadWriteLock()

  def bind(implicit ec: ExecutionContext): ServerServiceDefinition = {
    MasterTaskServiceGrpc.bindService(new MasterTaskServiceImpl, ec)
  }

  def executeStages(): Unit = {
    println("Waiting for worker registration...")
    awaitWorkers()

    val stages = List(
      new GenBlockStage,
      new LocalSortStage,
      new SampleKeyStage(() => generatePartitionFunction()),
      new PartitionAndShuffleStage,
      new MergeStage(() => isMergeComplete)
    )

    stages.foreach { stage =>
      if (stage.executeAndWaitForTermination() != StageExitStatus.SUCCESS) {
        println("Stage failed. Terminating.")
        return
      }
    }

    new TerminateStage().executeAndWaitForTermination()
    println("All stages executed successfully.")
  }

  private def awaitWorkers(): Unit = {
    Future {
      while (WorkerData.waitingWorkers > 0) Thread.sleep(3000)
      lock.writeLock().lock()
      try {
        println("All workers registered.")
      } finally {
        lock.writeLock().unlock()
      }
    }
    Await.result(Future.unit, Duration.Inf)
  }

  private def generatePartitionFunction(): Unit = {
    val workerCount = WorkerData.workerCount
    val sampledKeys = PartitionData.sampledKeys
    SortUtil.sort(sampledKeys)

    val pivots = sampledKeys.sliding(workerCount).map(_.lastOption.getOrElse(Array[Byte]())).toList
    val shuffleInfo = WorkerData.workerShuffleInfo

    PartitionData.partitionFunction = pivots.zip(shuffleInfo)
    println("Partition function generated.")
  }

  private def isMergeComplete: Boolean = {
    PartitionData.workerIds.forall { wid =>
      PartitionData.partitionList(wid).size <= 1
    }
  }
}
