package edu.depauw.csc.scala.graphics;

import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.Rectangle2D
import java.awt.geom.Area
import java.awt.geom.AffineTransform

object Rectangle {
  def apply(anX: Double, aY: Double, aW: Double, aH: Double) = new Rectangle(anX, aY, aW, aH)
  def apply(anX: Double, aY: Double, aW: Double, aH: Double, c: Color) = new Rectangle(anX, aY, aW, aH, c)
  def apply(anX: Double, aY: Double, aW: Double, aH: Double, c1: Color, c2: Color) = new Rectangle(anX, aY, aW, aH, c1, c2)
}

/**
  Candidate rectangle primitive for the graphics component in SCALES.  The default constructor will
  make a black rectangle
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version June 15, 2007
  @param anX The x-coordinate of the top-left corner of the rectangle
  @param aY The y-coordinate of the top-left corner of the bounding box of the circle
  @param aW The width of the rectangle
  @param aH The height of the rectangle
  */
class Rectangle(anX: Double, aY: Double, aW: Double, aH: Double) extends Rectangle2D.Double(anX, aY, aW, aH) with ShapeExt {
  
  private var intColor: Color = Color(java.awt.Color.BLACK)
  private var extColor: Color = Color(java.awt.Color.BLACK)
  private var orient: AffineTransform = new AffineTransform
  
  /**
    Secondary constructor which allows for a different initial color
  
    @param anX The x-coordinate of the top-left corner of the rectangle
    @param aY The y-coordinate of the top-left corner of the bounding box of the circle
    @param aW The width of the rectangle
    @param aH The height of the rectangle
    @param c The initial color of the rectangle
    */
  def this(anX: Double, aY: Double, aW: Double, aH: Double, c: Color) = {
    this(anX, aY, aW, aH)
    intColor = c
    extColor = c
  }
  
  /**
    Secondary constructor that allows for a different initial fill and outline color
  
    @param anX The x-coordinate of the top-left corner of the rectangle
    @param aY The y-coordinate of the top-left corner of the bounding box of the circle
    @param aW The width of the rectangle
    @param aH The height of the rectangle
    @param c1 The fill color to use
    @param c2 The outline color to use
    */
  def this(anX: Double, aY: Double, aW: Double, aH: Double, c1: Color, c2: Color) = {
    this(anX, aY, aW, aH)
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
    Allows for expanding or reducing the rectangle by a given ratio
    
    @param change The double result of dividing new size by old size
    */
  def scale(change: Double): Unit = {
    x *= change
    y *= change
    width *= change
    height *= change
  }
  
  /**
    Allows the changing the rectangle to a different color, fill and outline will be the same
    
    @param c The new color to use
    */
  def changeColor(c: Color): Unit = {
    intColor = c
    extColor = c
  }
  
  /**
    Allows the changing of the rectangle to use a different outline and fill color
    
    @param newIntColor The new color to use for the fill
    @param newExtColor The new color to use for the outline
    */
  def changeColors(newIntColor: Color, newExtColor: Color): Unit = {
    intColor = newIntColor
    extColor = newExtColor
  }
  
  /**
    Allows for the changing of the rectangle's outline color only
    
    @param c The new color to use for the outline
    */
  def changeExtColor(c: Color): Unit = {
    extColor = c
  }
  
  /**
    Allows for the changing of the rectangle's fill color only
    
    @param c The new color to use for the fill
    */
  def changeIntColor(c: Color): Unit = {
    intColor = c
  }
  
  /**
    Paints the rectangle
    
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