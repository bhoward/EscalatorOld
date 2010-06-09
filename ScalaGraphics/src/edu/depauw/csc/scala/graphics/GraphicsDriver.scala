package edu.depauw.csc.scala.graphics;

import javax.swing.JFrame
import javax.swing.JPanel
import java.awt.Graphics
import java.lang.Math, Math._
import java.util.Date

/**
  @author Cory Boatright, boatrightcd@hiram.edu
  @version June 19, 2007
  */
object GraphicsDriver extends JFrame {
  
  def main(args : Array[String]) {
    val surface: Canvas = new Canvas
    val d1: Date = new Date()
    val shape: ShapeExt = createPicture(256, 256, 256, 9, Color.RED)
    val d2: Date = new Date()
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setSize(1024, 1024)
    setVisible(true)
    surface.add(shape)
    add(surface)
    //surface.extractImage
    println("Creating the squares took " + (d2.getTime() - d1.getTime()) + "milliseconds")
  }
  
  def createPicture(x: Double, y: Double, len: Double, num: Int, c: Color): ShapeExt = {
    if (num <= 1) {
      Square(x, y, len, c)
    }
    else {
      Square(x, y, len, c) +++
        createPicture(x - (len / 4), y - (len / 4), len / 2, num - 1, moreRed(c)) +++
        createPicture(x + ((3 * len) / 4), y - (len / 4), len / 2, num - 1, moreBlue(c)) +++
        createPicture(x - (len / 4), y + ((3 * len) / 4), len / 2, num - 1, moreGreen(c)) +++
        createPicture(x + ((3 * len) / 4), y + ((3 * len) / 4), len / 2, num - 1, moreGreen(moreRed(c)))
    }
  }
  
  def moreRed: Color => Color = {
    case RGB(r, g, b) => RGB(r * 5, g, b)
  }
  
  def moreGreen: Color => Color = {
    case RGB(r, g, b) => RGB(r, g * 5, b)
  }
  
  def moreBlue: Color => Color = {
    case RGB(r, g, b) => RGB(r, g, b * 5)
  }
}
