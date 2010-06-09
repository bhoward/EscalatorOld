package edu.depauw.csc.scala.graphics;

import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.Ellipse2D
import java.awt.geom.Area
import java.awt.geom.AffineTransform

/**
  Companion object with a selection of factory methods.
  
  @author Brian Howard, bhoward@depauw.edu
  @version June 29, 2007
  */
object Circle {
  def apply(x: Double, y: Double, diam: Double) = new Circle(x, y, diam)
  def apply(x: Double, y: Double, diam: Double, c: Color) = new Circle(x, y, diam, c)
  def apply(x: Double, y: Double, diam: Double, cFill: Color, cOutline: Color) = new Circle(x, y, diam, cFill, cOutline)
}

/**
  Candidate circle primitive for the graphics component in SCALES.  The default constructor will
  make a black circle
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version June 15, 2007
  @param anX The x-coordinate of the top-left corner of the bounding box of the circle
  @param aY The y-coordinate of the top-left corner of the bounding box of the circle
  @param aD The diameter of the circle
  */
class Circle(anX: Double, aY: Double, aD: Double) extends Ellipse2D.Double(anX, aY, aD, aD) with ShapeExt {
  
  private var intColor: Color = Color(java.awt.Color.BLACK)
  private var extColor: Color = Color(java.awt.Color.BLACK)
  private var orient: AffineTransform = new AffineTransform
  
  /**
    This constructor allows for setting a different color for the circle at construction
    
    @param anX The x-coordinate of the top-left corner of the bounding box of the circle
    @param aY The y-coordinate of the top-left corner of the bounding box of the circle
    @param aD The diameter of the circle
    @param c The color to make the circle
    */
  def this(anX: Double, aY: Double, aD: Double, c: Color) = {
    this(anX, aY, aD)
    intColor = c
    extColor = c
  }
  
  /**
    This constructor allows for setting different fill and outline colors for the circle at construction
    
    @param anX The x-coordinate of the top-left corner of the bounding box of the circle
    @param aY The y-coordinate of the top-left corner of the bounding box of the circle
    @param aD The diameter of the circle
    @param c1 The color to make the fill of the circle
    @param c2 The color to make the outline of the circle
    */
  def this(anX: Double, aY: Double, aD: Double, c1: Color, c2: Color) = {
    this(anX, aY, aD)
    intColor = c1
    extColor = c2
  }
  
  /**
    Allows for translation along the x- and y-directions
    
    @param difx The magnitude and direction to move with respect to the x-axis
    @param dify The magnitude and direction to move with respect to the y-axis
    */
  def translate(difx: Double, dify: Double): Unit = {
    x += difx
    y += dify
  }
  
  /**
    Allows for expanding or reducing the circle by a given ratio
    
    @param change The double result of dividing new size by old size
    */
  def scale(change: Double): Unit = {
    x *= change
    y *= change
    width *= change
    height *= change
  }
  
  /**
    Allows the changing the circle to a different color, fill and outline will be the same
    
    @param c The new color to use
    */
  def changeColor(c: Color): Unit = {
    intColor = c
    extColor = c
  }
  
  /**
    Allows the changing of the circle to use a different outline and fill color
    
    @param newIntColor The new color to use for the fill
    @param newExtColor The new color to use for the outline
    */
  def changeColors(newIntColor: Color, newExtColor: Color): Unit = {
    intColor = newIntColor
    extColor = newExtColor
  }
  
  /**
    Allows for the changing of the circle's outline color only
    
    @param c The new color to use for the outline
    */
  def changeExtColor(c: Color): Unit = {
    extColor = c
  }
  
  /**
    Allows for the changing of the circle's fill color only
    
    @param c The new color to use for the fill
    */
  def changeIntColor(c: Color): Unit = {
    intColor = c
  }
  
  /**
    Paints the circle
    
    @param g The graphics context
    */
  def paint(g: Graphics): Unit = {
    val g2: Graphics2D = g.asInstanceOf[Graphics2D]
    g2.setTransform(orient)
    g2.setColor(intColor.dumpColor)
    g2.fill(this)
    g2.setColor(extColor.dumpColor)
    g2.draw(this)
  }
  
  /**
    Creates a java.awt.geom.Area object for this shape
    
    @return The area object constructed from this shape
    */
  def getArea: Area = {
      if (orient.isIdentity) {        //If the affine transformation doesn't rotate the object, don't bother with it
        new Area(this)
      }
      else {
        var base: Area = new Area(this)
        base.createTransformedArea(orient)  //the area will not be rotated by default
      }
    }
  
  /**
    Rotates the shape by a radian amount.
    
    @param rad The amount of rotation to do
    */
  def rotate(rad: Double): Unit = {
    orient.rotate(rad)
  }
  
  /**
    Rotates the shape when it's in a composite shape
    
    @param rad The amount of rotation to do
    @param anchorX The x-coordinate of the center of the composite
    @param anchorY The y-coordinate of the center of the composite
    */
  def rotate(rad: Double, anchorX: Double, anchorY: Double): Unit = {
    orient.rotate(rad, anchorX, anchorY)
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
