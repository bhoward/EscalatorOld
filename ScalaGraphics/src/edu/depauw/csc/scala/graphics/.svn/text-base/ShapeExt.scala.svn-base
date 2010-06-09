package edu.depauw.csc.scala.graphics;

import java.awt.geom.Area
import java.awt.Graphics
import java.awt.Shape

/**
  Traits shared by all the candidate scala shape primitives
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version June 14, 2007
  */
trait ShapeExt {
  def getArea(): Area
  def paint(g: Graphics): Unit
  def changeColor(c: Color): Unit
  def changeExtColor(c: Color): Unit
  def changeIntColor(c: Color): Unit
  def changeColors(newIntColor: Color, newExtColor: Color): Unit
  def scale(change: Double): Unit
  def translate(difx: Double, dify: Double): Unit
  def rotate(rad: Double): Unit
  def rotate(rad: Double, anchorX: Double, anchorY: Double): Unit
  def over(s: ShapeExt): Composite
  def +++(s: ShapeExt): Composite = over(s)
}
