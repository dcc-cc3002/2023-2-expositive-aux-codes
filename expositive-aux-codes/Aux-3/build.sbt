ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "testeo intenso"
  )

libraryDependencies += "org.scalameta" %% "munit" % "1.0.0-M7" % Test

