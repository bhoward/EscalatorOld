package edu.depauw.escalatorx

import scala.xml.{Node, NodeSeq}

case class Block(kind: Kind, contents: List[Part]) {
  def toXML(strategy: XMLStrategy): Node = {
    val body = for (part <- contents) yield part.toXML(strategy)
    
    kind.toXML(strategy, body)
  }
}

object Block {  
  def fromXML(node: Node): Block = {
    val kind = node.label match {
      case "text" => TextKind
      case "code" => (node \ "@type").text match {
        case "file" => FileKind((node \ "@name").text)
        case "fragment" => FragmentKind((node \ "@name").text)
        case "script" => ScriptKind
        case other => error("Unknown code type: " + other)
      }
      case label => error("Unknown element: " + label)
    }
    
    val contents = for (n <- node.child) yield n match {
      case <include /> => IncludePart((n \\ "@name").text)
      case _ => PlainPart(n.text)
    }
    
    Block(kind, contents.toList)
  }
}
