package edu.depauw.csc.scala.graphics;

import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.BasicStroke 
import java.awt.geom.Line2D
import java.awt.geom.Area
import java.awt.geom.AffineTransform

/**
  Companion object to the Line class which handles constructors.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 1, 2007
  */
object Line {
  def apply(aX1: Double, aY1: Double, aX2: Double, aY2: Double) = new Line(aX1, aY1, aX2, aY2)
  def apply(aX1: Double, aY1: Double, aX2: Double, aY2: Double, c: Color) = new Line(aX1, aY1, aX2, aY2, c)
}

/**
  Candidate circle primitive for the line component in SCALES.  The default constructor will
  make a black line
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version June 15, 2007
  @param aX1 The x-coordinate for the first point
  @param aY1 The y-coordinate for the first point
  @param aX2 The x-coordinate for the second point
  @param aY2 The y-coordinate for the second point
  */
class Line(aX1: Double, aY1: Double, aX2: Double, aY2: Double) extends Line2D.Double(aX1, aY1, aX2, aY2) with ShapeExt {
  
  private var extColor: Color = Color(java.awt.Color.BLACK)
  private var orient: AffineTransform = new AffineTransform
  private var width: float = 1
  
  /**
    Secondary constructor that allows the line to have a different initial color
    
    @param aX1 The x-coordinate for the first point
    @param aY1 The y-coordinate for the first point
    @param aX2 The x-coordinate for the second point
    @param aY2 The y-coordinate for the second point
    @param c The color to make the line
    */
  def this(aX1: Double, aY1: Double, aX2: Double, aY2: Double, c: Color) = {
    this(aX1, aY1, aX2, aY2)
    extColor = c
  }
  
  /**
    Third constructor constructor that allows the line to have a width
    
    @param aX1 The x-coordinate for the first point
    @param aY1 The y-coordinate for the first point
    @param aX2 The x-coordinate for the second point
    @param aY2 The y-coordinate for the second point
    @param w The width of the line
    */
  def this(aX1: Double, aY1: Double, aX2: Double, aY2: Double, w: float) = {
    this(aX1, aY1, aX2, aY2)
    width = w
  }
  
  /**
    Allows for translation along the x- and y-directions
    
    @param difx The magnitude and direction to move with respect to the x-axis
    @param dify The magnitude and direction to move with respect to the y-axis
    */
  def translate(difx: Double, dify: Double): Unit = {
    x1 += difx
    y1 += dify
    x2 += difx
    y2 += dify
  }
  
  /**
    Allows for expanding or reducing the line by a given ratio
    
    @param change The double result of dividing new size by old size
    */
  def scale(change: Double): Unit = {
    x1 *= change
    y1 *= change
    x2 *= change
    y2 *= change
  }
  
  /**
    Allows the changing the circle to a different color, fill and outline will be the same
    
    @param c The new color to use
    */
  def changeColor(c: Color): Unit = {
    extColor = c
  }
  
  /**
    changes the width of the line
    
    @param w The new width
    */
  def changeWidth(w: float): Unit = {
    width = w
  }
  
  /**
    @see changeColor
    */
  def changeColors(newIntColor: Color, newExtColor: Color): Unit = {
    extColor = newExtColor
  }
  
  /**
    @see changeColor
    */
  def changeExtColor(c: Color): Unit = {
    extColor = c
  }
  
  /**
    Paints the line
    
    @param g The graphics context
    */
  def paint(g: Graphics): Unit = {
    val g2: Graphics2D = g.asInstanceOf[Graphics2D]
    g2.setTransform(orient)
    g2.setColor(extColor.dumpColor)
    g2.setStroke(new BasicStroke(width))
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
    This method is not implemented because a line has no fill color
    @ignore
    */
  def changeIntColor(c: Color): Unit = {}
  
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
