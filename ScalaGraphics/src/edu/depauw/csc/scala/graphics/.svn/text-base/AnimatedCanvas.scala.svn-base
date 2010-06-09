package edu.depauw.csc.scala.graphics;

import java.awt.Graphics
import javax.swing.JComponent

object AnimatedCanvas {
  def apply() = new Canvas
  def apply(someShapes: ShapeExt*): Canvas = new Canvas(someShapes: _*)
}

class AnimatedCanvas extends JComponent with Surface {
  private var contents: List[ShapeExt] = List()

  /**
    Secondary constructor which starts with a number of shapes already on the drawing surface
    
    @param someShapes An arbitrary amount of shapes to start the canvas with
    */
  def this(someShapes: ShapeExt*) = {
    this()
    add(someShapes: _*)
  }  

  /**
    Adds multiple shapes to the canvas
    
    @param someShapes An arbitrary amount of shapes to add to the canvas
    */
  def add(someShapes: ShapeExt*): Unit = {
    for(val shape <- someShapes) {
      contents = shape :: contents
    }
    if (isVisible) repaint()
  }
  
  override def paintComponent(g: Graphics): Unit = {
    contents.foreach(x => x.paint(g))
  }
  
  def reset = {
    contents = List()
  }
}
