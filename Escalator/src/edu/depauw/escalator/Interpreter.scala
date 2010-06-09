
/* Until Scala supports JSR223... */
// Based off of http://code.google.com/p/rooscaloo/source/browse/trunk/rooscaloo/src/org/darevay/rooscaloo/Interpreter.scala.

package edu.depauw.escalator

import java.io.{StringWriter, PrintWriter}

//import javax.script.ScriptException;

import scala.tools.nsc.InterpreterResults._
import scala.tools.nsc.{Interpreter => ScalaInterpreter, Settings}
import scala.tools.nsc.util.{BatchSourceFile}

class ResultHolder(var value : Any)

// Define our own ScriptException class, since it doesn't exist in Java 1.5
class ScriptException(message: String) extends Exception(message)

class IncompleteException extends Exception

class Interpreter {
   // http://lampsvn.epfl.ch/trac/scala/ticket/874
   // http://lampsvn.epfl.ch/svn-repos/scala/scala/trunk/src/compiler/scala/tools/nsc/Interpreter.scala

  private val writer = new java.io.StringWriter()
  private val interpreter = new ScalaInterpreter(new Settings(), new PrintWriter(writer));

  private val holder = new ResultHolder(null)
  
  bind("$result__", holder.getClass.getName, holder);
  exec("import scala.reflect.Manifest")
  exec("def $getType[T](x: => T)(implicit m:Manifest[T]) = m.toString")
  
  // Update the interpreter's class path to include the current working directory.
  def updateClassPath(path: String) {
    if (!interpreter.settings.classpath.value.contains(path))
      interpreter.settings.classpath.value += System.getProperty("path.separator") + path
  }
  
  /**
   * Execute a string of Scala code and ignore its result.
   *
   * @param code the code to execute 
   * @return the response printed by the interpreter
   * @throws ScriptException if the code fails to parse
   */
  def exec(code: String) : String = {
    writer.getBuffer.setLength(0)

    val ir = interpreter.interpret(code)

    ir match {
      case Success => writer toString
      case Error =>
        throw new ScriptException(writer toString)
      case Incomplete => throw new IncompleteException
    }
  }

  /**
   * Evaluate the given string of Scala code and return the result. The code
   * must evaluate to a value.
   *
   * @param code the code to evaluate
   * @return the result
   * @throws ScriptException if the code fails to parse
   */
  def eval(code: String, asType:String) : Any = {
    writer.getBuffer.setLength(0)

    val ir = interpreter.interpret( "$result__.value = (" + code + "):" + asType)

    ir match {
      case Success => holder.value
      case Error =>
        throw new ScriptException(writer toString)
      case Incomplete => throw new IncompleteException
    }
  }

  def evalWithType(code: String, asType:String) : (Any, String) = {
    writer.getBuffer.setLength(0)

    val ir = interpreter.interpret("def $last__ = " + code)

    ir match {
      case Success =>
        writer.getBuffer.setLength(0)
//        interpreter.interpret("$result__.value = ($last__, $getType($last__)) : (" + asType + ", String)") match {
        interpreter.interpret("$result__.value = {val $first__ = $last__ : " + asType + "; val $second__ = $getType($last__); ($first__, $second__)}") match {
          case Success => holder.value.asInstanceOf[(Any, String)]
          case _ => throw new ScriptException(writer toString)
        }
      case Incomplete => throw new IncompleteException
      case Error =>
        throw new ScriptException(writer toString)
    }
  }


  def eval(code: String): Any = eval(code, "Any")
  def evalWithType(code: String):(Any, String) = evalWithType(code, "Any")

  def bind(name: String, t: String, value:Any) {
    interpreter.bind(name, t, value)
  }

  // Parse some code.
  import interpreter.compiler.{Tree, TermTree,
                               ValOrDefDef, ValDef, DefDef, Assign,
                               ClassDef, ModuleDef, Ident, Select, TypeDef,
                               Import, MemberDef, DocDef, Apply, If}
  import interpreter.compiler.CompilationUnit

  // Would like to make this public, but type system disallows it.
  private def parse(code: String): List[Tree] = {
    val unit = new CompilationUnit(
      new BatchSourceFile("<console>", code.toCharArray()))
    val scanner = new interpreter.compiler.syntaxAnalyzer.UnitParser(unit);
    scanner.templateStatSeq(false)._2 // I don't know what this does.
  }

  def collectIdentifiers(line: String):Set[String] = {
    val trees = parse(line)
    trees.map(collectIdentifiers1).foldLeft(Set():Set[String])(_++_)
  }

  // Collect identifiers from a single tree.
  // TODO: does this need to be expanded (e.g., BackQuotedIdent, Match, ...)?
  protected def collectIdentifiers1(tree: Tree):Set[String] = {
    tree match {
      case Ident(name) => Set(name.toString)
      case Apply(fun, args) => 
        collectIdentifiers1(fun) ++ 
        args.foldLeft(Set():Set[String])(_ ++ collectIdentifiers1(_))
      case If(cond, thenp, elsep) => 
        collectIdentifiers1(cond) ++ collectIdentifiers1(thenp) ++ 
        collectIdentifiers1(elsep)
      case Select(qualifier, selector) =>
        collectIdentifiers1(qualifier)
      case ValDef(_, _, _, rhs) => collectIdentifiers1(rhs)
      case DefDef(_, _, _, _, _, rhs) => collectIdentifiers1(rhs)
      case _ => Set()
    }
  }

  def isDecl(line: String): Boolean = {
    val l = parse(line)
    l(0) match {
      case _:ValDef => true
      case _:DefDef => true
      case _:Import => true
      case _ => false
    }

  }

  def getDeclName(line: String): String = {
    val l = parse(line)
    l(0) match {
      case ValDef(_, name, _, _) => name.toString
      case DefDef(_, name, _, _, _, _) => name.toString
      case _ => ""
    }
  }
}
