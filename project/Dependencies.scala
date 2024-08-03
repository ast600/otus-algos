import sbt.*

object Dependencies {
  lazy val zioTest: Seq[ModuleID] = Seq(
    "dev.zio" %% "zio-test"          % "2.1.6" % Test,
    "dev.zio" %% "zio-test-sbt"      % "2.1.6" % Test,
    "dev.zio" %% "zio-test-magnolia" % "2.1.6" % Test
    )
}
