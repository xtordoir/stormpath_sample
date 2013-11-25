import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "stormpath_sample"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,
    "com.stormpath.sdk" % "stormpath-sdk-api" % "0.8.0",
    "com.stormpath.sdk" % "stormpath-sdk-httpclient" % "0.8.0"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
