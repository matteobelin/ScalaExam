import sbt.Keys.libraryDependencies

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.8.4"

lazy val root = (project in file("."))
  .settings(
    name := "tondeuseAGazon",
    libraryDependencies += "org.scalameta" %% "munit" % "1.3.3" % Test
  )
