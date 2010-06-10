import sbt._

class PrototypeProject(info: ProjectInfo) extends DefaultProject(info) with AutoCompilerPlugins
{
  val specs = "org.scala-tools.testing" % "specs" % "1.6.2.1"
  val sxr = compilerPlugin("org.scala-tools.sxr" %% "sxr" % "0.2.4")
  override def compileOptions =
    CompileOption("-P:sxr:base-directory:" + mainScalaSourcePath.absolutePath) ::
    super.compileOptions.toList

}
