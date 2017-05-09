name := """minimal-scala"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.5.13"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.17"
libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.6"
libraryDependencies += "org.scala-lang" % "scala-swing" % "2.11.0-M7"
libraryDependencies += "com.typesafe.play" % "play-ws_2.11" % "2.5.14"


fork in run := true