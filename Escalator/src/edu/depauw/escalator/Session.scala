
package edu.depauw.escalator

import java.awt._
import javax.swing._
import java.awt.event._

import edu.depauw.scales._

trait Evalable {
  var identifiers:Set[String] = Set()

  def eval(line:String)
  def eval()


  def delete
}

abstract class Result(var line:String) extends TransparentPanel with Evalable with RecursiveSetFont {
  var displayable:Displayable = null

  def setDisplay(o:JComponent) {
    try {
      remove(0) // First element may not exist yet.
    } catch {
      case _ => ()
    }
    add(o, 0)
    repaint() // Fixes "overlapping" bug reported by Dr. Howard
  }

  def getObject: JComponent

  def eval(newLine: String)

  def eval() {
    try {
      setDisplay(getObject)
    } catch {
      case e: IncompleteException => throw e
      case e:Throwable => 
        setDisplay(new ErrorArea(if (e.getMessage != null) e.getMessage else e.toString))
    }
  }
    
  def delete {
    if (displayable != null) {
      //displayable.delete
    }
  }

  eval(line)
}

class Session {
  var interpreter = new Interpreter

  interpreter.exec("import edu.depauw.escalator.Implicits._\n" +
                   "import edu.depauw.scales._\n" +
                   "import edu.depauw.scales.Predef._\n")

  protected var evalables: Set[Evalable] = Set()

  def evalDeps(ids: Set[String]) {
    for (evalable <- evalables) {
      if (!evalable.identifiers.intersect(ids).isEmpty)
        evalable.eval()
    }
  }

  def evalDepsBut(ids: Set[String], but:Evalable) {
    for (evalable <- evalables) {
      if (evalable != but && !evalable.identifiers.intersect(ids).isEmpty)
        evalable.eval()
    }
  }

  def addEvalable(e: Evalable) {
    evalables = evalables + e
  }

  def removeEvalable(e: Evalable) {
    evalables = evalables - e
    e.delete
  }
  
  class Expr(s:String) extends Result(s) {
    override def eval(newLine: String) {
      line = newLine
      identifiers = interpreter.collectIdentifiers(line)
      eval()
    }

    def getObject: JComponent = {
      val (d, t) = interpreter.evalWithType(line, "edu.depauw.scales.Displayable")
      displayable = d.asInstanceOf[edu.depauw.scales.Displayable]
      val component = displayable.toComponent
      component.setToolTipText(t)
      component
    }    
  }

  class Statement(l: String) extends Result(l) {
    var identifier:String = ""
    
    override def eval(newLine: String) {
      line = newLine
      identifier = interpreter.getDeclName(line)
      identifiers = interpreter.collectIdentifiers(line)
      eval()
    }
    
    def getObject: JComponent = {
      val response = interpreter.exec(line)
      /* The following will display the value as for an Expr, but it fails on "def f(x) =" and "val (a,b) =":
      val (d, t) = interpreter.evalWithType(identifier, "edu.depauw.scales.Displayable")
      displayable = d.asInstanceOf[Displayable]
      val component = displayable.toComponent
      component.setToolTipText(t)
      component
      */
      displayable = Implicits.stringToDisplayable(response)
      displayable.toComponent
    }

    override def eval() {
      super.eval()
      evalDeps(Set(identifier))
    }

    override def delete {
      super.delete
      if (identifier != "") interpreter.bind(identifier, "Any", null)
    }
  }
  
  
  def reset() {
    interpreter = new Interpreter()
    interpreter.exec("import edu.depauw.escalator.Implicits._\n" +
                     "import edu.depauw.scales._\n" +
                     "import edu.depauw.scales.Predef._\n")

    evalables = Set()
  }
}
