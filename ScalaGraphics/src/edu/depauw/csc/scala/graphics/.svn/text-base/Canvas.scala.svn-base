package edu.depauw.csc.scala.graphics;

import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import javax.swing.JComponent

/**
  Companion object to the Canvas class which handles constructors.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 1, 2007
  */
object Canvas {
  def apply() = new Canvas
  def apply(someShapes: ShapeExt*): Canvas = new Canvas(someShapes: _*)
}

/**
  Work in progress for making a new Canvas designed specifically for the extended shape classes.
    
  @author Cory Boatright
  @version June 19, 2007
 */
class Canvas extends JComponent with Surface {
  private var contents: List[ShapeExt] = List()
  
  val WIDTH = 1024
  val HEIGHT = 1024
  setSize(WIDTH, HEIGHT)
  
  private var bi: BufferedImage = null
  
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
    bi = null
    if (isVisible) repaint()
  }
  
  /**
    Resets the BufferedImage
   */
  def reset(): Unit = {
    bi = null
  }
  
  /**
    Paints all the shapes on the canvas
    
    @param g The graphics context
    */
  override def paintComponent(g: Graphics): Unit = {
    if (bi == null) {
      // Create the buffered image if it didn't already exist
      bi = createImage(WIDTH, HEIGHT).asInstanceOf[BufferedImage]
      renderImage
    }
    
    // Ordinary painting behavior just copies the buffered image
    super.paintComponent(g) // make sure the background gets painted
    g.drawImage(bi, 0, 0, null)
  }
  
  /**
    Renders the shapes into the buffered image
    */
  private def renderImage {
    val g: Graphics2D = bi.createGraphics
    contents.foreach(x => x.paint(g))
  }
  
  /**
    Convenience method for use with 3D graphics
    
    @return a buffered image of the contents of this canvas for use with 3D
   */
  def extractImage(): BufferedImage = {
    if (bi == null) {
      bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB)
      if(bi == null)
        println("Still null")
      else
        println("Not null anymore")
      renderImage
    }
    bi
  }
}
