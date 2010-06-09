package edu.depauw.csc.scala.graphics;

import java.awt.Graphics

trait Surface {
  def add(someShapes: ShapeExt*): Unit
  def paintComponent(g: Graphics): Unit
}
