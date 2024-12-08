import Dependencies._

ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "DistSorting_Master",
    libraryDependencies += munit % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.

// Add scalapb library compile option
Compile / PB.targets := Seq(
  scalapb.gen() -> (Compile / sourceManaged).value / "scalapb"
)

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
)