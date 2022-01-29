ThisBuild./(version) := "1.0.0"
ThisBuild/scalaVersion := "2.13.6"
ThisBuild / organization := "org.scala.fans"


val scalaTest = "org.scalatest" %% "scalatest" % "3.2.7"
val gigahorse = "com.eed3si9n" %% "gigahorse-okhttp" % "0.5.0"
val playJson  = "com.typesafe.play" %% "play-json" % "2.9.2"


lazy val hello: Project = (project in file("."))
  .aggregate(helloCore) // broadcasting commands
  .dependsOn(helloCore)
  .enablePlugins(JavaAppPackaging)
  .settings(
      name := "Hello",
      libraryDependencies += scalaTest % Test,
  )
lazy val helloCore: Project = project
  .in(file("core"))
  .settings(
      name := "Hello Core",
      libraryDependencies ++= Seq(
          gigahorse,
          playJson,
          scalaTest % Test
      )
  )