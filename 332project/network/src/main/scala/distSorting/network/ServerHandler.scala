package distSorting.network

import io.grpc.{Server, ServerBuilder, ServerServiceDefinition}

trait ServerLifecycle {
  val context: ServerHandler
  def start(): Unit = context.start()
  def stop(): Unit = context.stop()
}

class ServerHandler(service: ServerServiceDefinition, name: String, port: Int) {
  private var server: Server = _

  def start(): Unit = {
    server = ServerBuilder.forPort(port).addService(service).build().start()
    println(s"Server [$name] started, listening on port $port")
    sys.addShutdownHook {
      println(s"Shutting down server [$name]...")
      stop()
    }
  }

  def stop(): Unit = {
    if (server != null) {
      server.shutdown()
      println(s"Server [$name] stopped")
    }
  }

  def awaitTermination(): Unit = {
    if (server != null) server.awaitTermination()
  }
}
