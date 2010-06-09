/**
  NOTE:  A lot of code has been commented out, this is code written with the aim of encapsulating
  a composite into a BufferedImage.
 */
package edu.depauw.csc.scala.graphics;

import java.awt.geom.Area
import java.awt.Graphics
import java.awt.Graphics2D
//import java.awt.image.BufferedImage
//import java.awt.geom.AffineTransform

/**
  Companion object for the composite class which handles constructors.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 1, 2007
  */
object Composite {
  def apply() = new Composite()
  def apply(someShapes: ShapeExt*): Composite = new Composite(someShapes: _*)
}

/**
  Candidate composite shape class for the graphics component in SCALES.  The default constructor takes no
  arguments, and the class as a whole is also a shape, so composites can be added together.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version June 15, 2007
  */
class Composite extends AnyRef with ShapeExt {
  
  private var shapes: List[ShapeExt] = List()
  //private var bi: BufferedImage = null
  //private var orient: AffineTransform = new AffineTransform()
  //private var hasChanged: boolean = true
  
  /**
    Secondary constructor that takes an varied amount of shapes and creates a composite with them
    
    @param someShapes An arbitrary number of shapes
    */
  def this(someShapes: ShapeExt*) = {
    this()
    add(someShapes: _*)
  }
  
  /**
    Adds shapes to the composite
    
    @param someShapes An arbitrary number of shapes
    */
  def add(someShapes: ShapeExt*): Unit = {
    for(val shape <- someShapes) {
      shapes = shape :: shapes
    }
    //hasChanged = true
  }
  
  /**
    Allows for translation along the x- and y-directions
    
    @param difx The magnitude and direction to move with respect to the x-axis
    @param dify The magnitude and direction to move with respect to the y-axis
    */
  def translate(difx: Double, dify: Double): Unit = {
    shapes.foreach(x => x.translate(difx, dify))
    //hasChanged = true
  }
  
  /**
    Allows for expanding or reducing the composite by a given ratio
    
    @param change The double result of dividing new size by old size
    */
  def scale(change: Double): Unit = {
    shapes.foreach(x => x.scale(change))
    //hasChanged = true
  }
  
  /**
    Allows for the changing of the composite's shapes' fill color only, lines will
    be unaffected as they have no fill color
    
    @param c The new color to use for the fill
    */
  def changeIntColor(c: Color): Unit = {
    shapes.foreach(x => x.changeIntColor(c))
    //hasChanged = true
  }
  
  /**
    Allows for the changing of the composite's shapes' outline color only
    
    @param c The new color to use for the outline
    */
  def changeExtColor(c: Color): Unit = {
    shapes.foreach(x => x.changeExtColor(c))
    //hasChanged = true
  }
  
  /**
    Allows the changing the composite's shapes to a different color, fill and outline will be the same
    
    @param c The new color to use
    */
  def changeColor(c: Color): Unit = {
    shapes.foreach(x => x.changeColor(c))
    //hasChanged = true
  }
  
  /**
    Allows the changing of the composite's shapes to use a different outline and fill color
    
    @param newIntColor The new color to use for the fill
    @param newExtColor The new color to use for the outline
    */
  def changeColors(newIntColor: Color, newExtColor: Color): Unit = {
    shapes.foreach(x => x.changeColors(newIntColor, newExtColor))
    //hasChanged = true
  }
  
  /**
    Paints the composite
    
    @param g The graphics context
    */
  def paint(g: Graphics): Unit = {
    /**
    if(hasChanged) {
      renderImage
    }
    var g2: Graphics2D = g.asInstanceOf[Graphics2D]
    g2.setTransform(orient)
    g2.drawImage(bi, 0, 0, null)
    hasChanged = false
    */
    shapes.foreach(x => x.paint(g))
  }
  
  /**
  def renderImage(): Unit = {
    bi = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB)
    val g: Graphics2D = bi.createGraphics
    shapes.foreach(x => x.paint(g))
  }
  */
  
  /**
    Creates a java.awt.geom.Area object for this shape
    
    @return The area object constructed from this shape
    */
  def getArea: Area = {
    var area: Area = new Area
    shapes match {
      case List() => area.add(new Area)
      case x::xs => 
        area.add(x.getArea)
        area.add(getArea(xs))
      }
    return area
  }
  
  /**
    Helper function for the public getArea function
    
    @return The area object constructed from this shape
    */
  private def getArea(lis: List[ShapeExt]): Area = {
    var area: Area = new Area
    lis match {
      case List() => area.add(new Area)
      case x::xs =>
        area.add(x.getArea)
        area.add(getArea(xs))
    }
    return area
  }
  
  /**
    This method will need to find the center of the composite image, and rotate with respect to it.  The rotation will occur
    in radians.
    
    @param rad The amount of rotation in radians
    */
  def rotate(rad: Double): Unit = {
    //Can get the approximate center of the composite with a few function calls
    val region: Area = this.getArea
    val centerX: Double = region.getBounds2D.getCenterX
    val centerY: Double = region.getBounds2D.getCenterY
    //Use the center to rotate the component shapes
    shapes.foreach(x => x.rotate(rad, centerX, centerY))
  }
  
  /**
    This method will need to rotate appropriately when it is rotated as a part of a composite
    
    @param rad The amount of rotation in radians
    @param anchorX The x-coordinate of the center the rotation needs to occur with respect to
    @param anchorY The y-coordinate of the center the rotation needs to occur with respect to
    */
  def rotate(rad: Double, anchorX: Double, anchorY: Double): Unit = {
    //orient.rotate(rad, anchorX, anchorY)
  }
  
  /**
    Creates a composite layering one shape under this one.
    
    @param s The shape which will be under this one.
    @return A composite of this shape as well as the argument shape
    */
  def over(s: ShapeExt): Composite = {
    new Composite(this, s)
  }
}
