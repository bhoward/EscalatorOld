package edu.depauw.escalatorx

import scala.swing._

import javax.swing.event._
import javax.swing.text.html.HTMLDocument

object Test {
  def main(args: Array[String]) {
    val a =
      <document title="bar baz">
        <text>
This is some text.
        </text>
          
        <code type="file" name="filename.scala"><include name="package spec" />
// Here is some code
object Foo {{
  def main(args: Array[String]) {{
    println("Hello World!")
    if (1 &lt; 2 &amp;&amp; 2 &lt; 3) println("Whew!")
  }}
}}
</code>
        
        <code type="fragment" name="package spec">package foo
</code>
      </document>
      
    val doc = Doc.fromXML(a)
    
    showHTML(doc)
  }
  
  def showHTML(doc: Doc) {
    val frame = new Frame
    val pane = new RenderEditPane(doc, null) // the null is just to get this to compile -- ignore

    frame.contents = new ScrollPane(pane)
    
    frame.title = "Escalator - " + doc.title
    frame.size = new java.awt.Dimension(600, 400)
    frame.visible = true
    
    // Just for testing:
//    doc.tangle(mgr, new java.io.File("/tmp"))
  }
}

// TODO where does the doc title come from, and how can it be changed?  Does it need a title?
// TODO uh, new, load/save, cut/copy/paste, and undo?
// TODO cut/copy/paste/undo/redo need to be at both intra- and inter-block levels
// TODO put edit frames in a tab panel; highlight rendered HTML corresponding to current tab
// TODO refactoring: split/merge block, extract/inline fragment, rename block/fragment
// TODO support autoindent & brace matching in the editor
// TODO add expression blocks
// TODO support markdown (or equiv) and a code formatter; what about Scala X-Ray?
// TODO hook up SBT, and the interpreter (for scripts and expressions)
// TODO embedded REPL?
// TODO select blocks: drag to rearrange, popup to cut/copy/paste?
// TODO import/export project; synchronize with edited source files (as in Literable)??
