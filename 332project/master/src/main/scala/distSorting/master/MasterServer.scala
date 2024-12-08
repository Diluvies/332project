package distSorting.master

import distSorting.network.{ServerHandler, ServerLifecycle}
import io.grpc.ServerServiceDefinition
import scala.concurrent.ExecutionContext
import distSorting.master.MasterTaskHandler

object MasterServer extends ServerLifecycle {
  private val port = 50051 // 50050 ~ 50100

  val context = new ServerHandler(
    MasterTaskHandler.bind(ExecutionContext.global),
    "MasterServer",
    port
  )
}
