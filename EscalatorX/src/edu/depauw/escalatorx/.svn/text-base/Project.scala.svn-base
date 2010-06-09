package edu.depauw.escalatorx

import java.io.File

import scala.xml.XML

// This represents an open Escalator document, as well as keeping track of the
// generated source directory and corresponding classloader.
// "Project" isn't a great name, but it will do...
class Project(filename: Option[String]) {
  val doc = filename match {
    case Some(name) => Doc.fromXML(XML.loadFile(name))
    
    case None => new Doc("Unnamed", Nil)
  }
  
  val file = filename match {
    case Some(name) => new File(name).getAbsoluteFile
    
    case None => new File(System.getProperty("user.dir"), Project.UNNAMED)
  }
  
  def directory = file.getParentFile
  
  val frame = new EscalatorFrame(this)
  frame.visible = true
  
  def queryExit(): Boolean = frame.queryExit()
}

object Project {
  def fromFile(filename: String) = new Project(Some(filename))
  
  def makeEmpty = new Project(None)
  
  val UNNAMED = "Unnamed"
}