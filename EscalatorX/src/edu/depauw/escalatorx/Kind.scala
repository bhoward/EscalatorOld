package edu.depauw.escalatorx

import scala.xml.{Node, NodeSeq}

trait Kind {
  def toXML(strategy: XMLStrategy, body: List[Node]): Node
}

case object TextKind extends Kind {
  def toXML(strategy: XMLStrategy, body: List[Node]): Node =
    strategy.textKind(body)
}

case class FileKind(name: String) extends Kind {
  def toXML(strategy: XMLStrategy, body: List[Node]): Node =
    strategy.fileKind(name, body)
}

case class FragmentKind(name: String) extends Kind {
  def toXML(strategy: XMLStrategy, body: List[Node]): Node =
    strategy.fragmentKind(name, body)
}

case object ScriptKind extends Kind {
  def toXML(strategy: XMLStrategy, body: List[Node]): Node =
    strategy.scriptKind(body)
}
