package edu.depauw.csc.scala.graphics;

import java.awt.Polygon
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.Area
import java.awt.geom.AffineTransform

/**
  Companion object for the PolygonExt class that handles constructors.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 1, 2007
  */
object PolygonExt {
  def apply(xs: Array[Int], ys: Array[Int]) = new PolygonExt(xs, ys, xs.length)
  def apply(xs: Array[Int], ys: Array[Int], c: Color) = new PolygonExt(xs, ys, xs.length, c)
  def apply(xs: Array[Int], ys: Array[Int], c1: Color, c2: Color) = new PolygonExt(xs, ys, xs.length, c1, c2)
  def apply(ps: List[(Int, Int)]) = {
    val (xs, ys) = List.unzip(ps)
    new PolygonExt(xs.toArray, ys.toArray, xs.length)
  }
  def apply(ps: List[(Int, Int)], c1: Color) = {
    val (xs, ys) = List.unzip(ps)
    new PolygonExt(xs.toArray, ys.toArray, xs.length, c1)
  }
  def apply(ps: List[(Int, Int)], c1: Color, c2: Color) = {
    val (xs, ys) = List.unzip(ps)
    new PolygonExt(xs.toArray, ys.toArray, xs.length, c1, c2)
  }
}

/**
  Candidate polygon primitive for the graphics component in SCALES.  The default constructor will
  make a black polygon
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version June 15, 2007
  @param xs The x-coordinates of the points of the polygon
  @param ys The y-coordinates of the points of the polygon
  @param n The total number of points in the polygon
  */
class PolygonExt(xs: Array[Int], ys: Array[Int], n: Int) extends Polygon(xs, ys, n) with ShapeExt {
  
  private var intColor: Color = Color(java.awt.Color.BLACK)
  private var extColor: Color = Color(java.awt.Color.BLACK)
  private var orient: AffineTransform = new AffineTransform
  
  /**
    Secondary constructor which allows the setting of an initial color
    
    @param xs The x-coordinates of the points of the polygon
    @param ys The y-coordinates of the points of the polygon
    @param n The total number of points in the polygon
    @param c The initial color of the polygon
    */
  def this(xs: Array[Int], ys: Array[Int], n: Int, c: Color) = {
    this(xs, ys, n)
    intColor = c
    extColor = c
  }
  
  /**
    Secondary constructor which allows the setting of an initial color
    
    @param xs The x-coordinates of the points of the polygon
    @param ys The y-coordinates of the points of the polygon
    @param n The total number of points in the polygon
    @param c1 The initial fill color of the polygon
    @param c2 The initial outline color of the polygon
    */
  def this(xs: Array[Int], ys: Array[Int], n: Int, c1: Color, c2: Color) = {
    this(xs, ys, n)
    intColor = c1
    extColor = c2
  }
  
  /**
    Allows for translation along the x- and y-directions
    
    @param difx The magnitude and direction to move with respect to the x-axis
    @param dify The magnitude and direction to move with respect to the y-axis
    */
  def translate(difx: Double, dify: Double): Unit = {
    var i: Int = 0
    while(i < xpoints.length) {
      xpoints(i) += difx.asInstanceOf[Int]
      ypoints(i) += dify.asInstanceOf[Int]
      i += 1
    }
  }
  
  /**
    Allows for expanding or reducing the polygon by a given ratio
    
    @param change The double result of dividing new size by old size
    */
  def scale(change: Double): Unit = {
    var i: Int = 0
    while(i < xpoints.length) {
      xpoints(i) *= change.asInstanceOf[Int]
      ypoints(i) *= change.asInstanceOf[Int]
      i += 1
    }
  }
  
  /**
    Allows the changing of the polygon to use a different outline and fill color
    
    @param newIntColor The new color to use for the fill
    @param newExtColor The new color to use for the outline
    */
  def changeColors(newIntColor: Color, newExtColor: Color): Unit = {
    intColor = newIntColor
    extColor = newExtColor
  }
  
  /**
    Allows for the changing of the polygon's fill color only
    
    @param c The new color to use for the fill
    */
  def changeIntColor(c: Color): Unit = {
    intColor = c
  }
  
  /**
    Allows for the changing of the polygon's outline color only
    
    @param c The new color to use for the outline
    */
  def changeExtColor(c: Color): Unit = {
    extColor = c
  }
  
  /**
    Allows the changing the polygon to a different color, fill and outline will be the same
    
    @param c The new color to use
    */
  def changeColor(c: Color): Unit = {
    intColor = c
    extColor = c
  }
  
  /**
    Paints the polygon
    
    @param g The graphics context
    */
  def paint(g: Graphics): Unit = {
    val g2: Graphics2D = g.asInstanceOf[Graphics2D]    //typecasting is terrible in scala
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
