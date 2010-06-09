package edu.depauw.csc.scala.graphics;

import java.lang.Math, Math._

/**
  Companion object for the Color class that handles constructors, and also
  provides the same color constants as java.awt.Color
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 5, 2007
 */
object Color {
  def apply(color: java.awt.Color) = new Color(color)
  def BLACK: Color = new Color(java.awt.Color.BLACK)
  def WHITE: Color = new Color(java.awt.Color.WHITE)
  def RED: Color = new Color(java.awt.Color.RED)
  def PINK: Color = new Color(java.awt.Color.PINK)
  def ORANGE: Color = new Color(java.awt.Color.ORANGE)
  def YELLOW: Color = new Color(java.awt.Color.YELLOW)
  def MAGENTA: Color = new Color(java.awt.Color.MAGENTA)
  def GREEN: Color = new Color(java.awt.Color.GREEN)
  def CYAN: Color = new Color(java.awt.Color.CYAN)
  def BLUE: Color = new Color(java.awt.Color.BLUE)
  def GRAY: Color = new Color(java.awt.Color.GRAY)
  def LIGHT_GRAY: Color = new Color(java.awt.Color.LIGHT_GRAY)
  def DARK_GRAY: Color = new Color(java.awt.Color.DARK_GRAY)
}

/**
  Helper object for the color class which handles creation and extraction of colors using RGB values.
  Values for r, g, and b can be greater than 255 but will "wrap around" to maintain a valid value.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 9, 2007
 */
object RGB {
  def apply(r: Int, g: Int, b: Int): Color = new Color(new java.awt.Color(r % 256, g % 256, b % 256))
  def unapply(c: Color): Option[(Int, Int, Int)] = {
    val color: java.awt.Color = c.dumpColor
    Some((color.getRed, color.getGreen, color.getBlue))
  }
}

/**
  Helper object for the color class which handles creation and extraction of colors using RGB values with
  an alpha component.  Values for r, g, b, and a can be greater than 255 but "wrap around."
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 9, 2007
 */
object RGBA {
  def apply(r: Int, g: Int, b: Int, a: Int): Color = new Color(new java.awt.Color(r % 256, g % 256, b % 256, a % 256))
  def unapply(c: Color): Option[(Int, Int, Int, Int)] = {
    val color: java.awt.Color = c.dumpColor
    Some((color.getRed, color.getGreen, color.getBlue, color.getAlpha))
  }
}

/**
  Helper object for the color class which handles creation and extraction of colors using HSB values.
  Values will be subtracted from their floor to get a number between 0.0 and 1.0
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 9, 2007
 */
object HSB {
  def apply(h: Double, s: Double, b: Double): Color = {
    new Color(java.awt.Color.getHSBColor(h.asInstanceOf[Float], s.asInstanceOf[Float], b.asInstanceOf[Float]))
  }
  def unapply(c: Color): Option[(Double, Double, Double)] = {
    val color: java.awt.Color = c.dumpColor
    val arr: Array[Float] = java.awt.Color.RGBtoHSB(color.getRed, color.getGreen, color.getBlue, null)
    Some((arr(0), arr(1), arr(2)))
  }
}

/**
  Helper object for the color class which handles creation and extraction of colors using HSB values
  with an alpha component.  Values will be subtracted from their floor to get a number between 0.0 and 1.0
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 9, 2007
 */
object HSBA {
  def apply(h: Double, s: Double, b: Double, a: Double): Color = {
    val inter: java.awt.Color = java.awt.Color.getHSBColor(h.asInstanceOf[Float], s.asInstanceOf[Float], b.asInstanceOf[Float])
    new Color(new java.awt.Color(inter.getRed, inter.getGreen, inter.getBlue, ((a - Math.floor(a)) * 255).asInstanceOf[Int]))
  }
  def unapply(c: Color): Option[(Double, Double, Double, Double)] = {
    val color: java.awt.Color = c.dumpColor
    val arr: Array[Float] = java.awt.Color.RGBtoHSB(color.getRed, color.getGreen, color.getBlue, null)
    Some((arr(0), arr(1), arr(2), (color.getAlpha()).asInstanceOf[Double] / 255.0))
  }
}

/**
  Scala wrapper for java.awt.Color, supports both RGB and HSB coloring
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 5, 2007
 */
class Color(var c: java.awt.Color) {
  
  /**
    Unwraps the java.awt.Color
    
    @return A java.awt.Color object
   */
  def dumpColor(): java.awt.Color = c
}