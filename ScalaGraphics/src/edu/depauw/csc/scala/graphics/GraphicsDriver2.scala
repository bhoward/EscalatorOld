package edu.depauw.csc.scala.graphics;

import javax.imageio.ImageIO, ImageIO._
import java.io.File

object GraphicsDriver2 {
  def main(args: Array[String]) {
    var saveFile: File = new File("trial.png")
    var canvas: Canvas = new Canvas
    val shape1: Oval = Oval(0, 0, 400, 1000, Color.BLUE)
    val shape2: Rectangle = Rectangle(600, 300, 250, 590, Color.WHITE)
    canvas.add(shape1, shape2)
    println(ImageIO.write(canvas.extractImage, "png", saveFile))
  }
}
