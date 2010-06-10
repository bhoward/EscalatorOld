import sbt._

class PrototypeProject(info: ProjectInfo) extends DefaultProject(info) {
  val specs = "org.scala-tools.testing" % "specs" % "1.6.2.1"
}
