import Dependencies.*

ThisBuild / scalaVersion     := "3.3.3"
ThisBuild / version          := "1.0.0"
ThisBuild / organization     := "ru.otus"
ThisBuild / organizationName := "otus"

lazy val root = (project in file("."))
  .settings(
    name := "otus-algos",
    libraryDependencies ++= zioTest
  )