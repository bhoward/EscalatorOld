package edu.depauw.escalatorx

import scala.xml.{Node, Text}

trait Part {
  def toXML(strategy: XMLStrategy): Node
}

case class PlainPart(source: String) extends Part {
  def toXML(strategy: XMLStrategy) = Text(source)
}

case class IncludePart(name: String) extends Part {
  def toXML(strategy: XMLStrategy) = strategy.includePart(name)
}
