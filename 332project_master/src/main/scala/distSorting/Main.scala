// import example.hello._
// import io.grpc.ManagedChannelBuilder

// object Master extends App {
//   // Worker 주소와 포트
//   val workerAddress = "2.2.2.101"
//   val workerPort = 50051

//   // gRPC 채널 생성
//   val channel = ManagedChannelBuilder
//     .forAddress(workerAddress, workerPort)
//     .usePlaintext()
//     .build()

//   // Worker 서비스 스텁 생성
//   val stub = HelloServiceGrpc.blockingStub(channel)

//   // 요청 메시지 생성
//   val request = HelloRequest(message = "Hello worker!")

//   // Worker에 메시지 전송
//   val response = stub.sendHello(request)

//   // 응답 확인 및 결과 출력
//   response.message match {
//     case "Hello master!" => println("Connection complete")
//     case _               => println("Connection failed")
//   }

//   // 채널 종료
//   channel.shutdown()
// }


package distSorting

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello, World!")
  }
}
