import Dependencies._

ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"

name := "distSorting"

lazy val commonSettings = Seq(
  // Add library dependencies
  libraryDependencies ++= Seq(
    // Scala의 표준 라이브러리
    // "org.scala-lang" % "scala-library" % "2.13.12",
    // ScalaPB dependencies
    "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
    // io.grpc dependencies
    "io.grpc" % "grpc-netty" % scalapb.compiler.Version.grpcJavaVersion,
    // for testing
    "org.scalatest" %% "scalatest" % "3.2.17" % Test,
  ),
  // Add protobuf compilation
  Compile / PB.targets := Seq(
    scalapb.gen() -> (Compile / sourceManaged).value / "scalapb"
  )
)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.


// projects
lazy val distSorting = project
  .in(file("."))
  .settings(name := "distSorting")
  .settings(commonSettings)
  .aggregate(network, master, worker)

lazy val network = project
  .in(file("./network"))
  .settings(name := "network")
  .settings(commonSettings)
  .settings(
    mainClass in Compile := Some("distSorting.network.Main")
  )

lazy val master = project
  .in(file("./master"))
  .settings(name := "master")
  .settings(commonSettings)
  .settings(
    mainClass in Compile := Some("distSorting.master.Main")
  )
  .dependsOn(network)

lazy val worker = project
  .in(file("./worker"))
  .settings(name := "worker")
  .settings(commonSettings)
  .settings(
    mainClass in Compile := Some("distSorting.worker.Main")
  )
  .dependsOn(network)