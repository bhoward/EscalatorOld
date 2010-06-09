package edu.depauw.csc.scala.animation;

import edu.depauw.csc.scala.graphics._
import javax.swing.JFrame
import java.awt.BorderLayout, BorderLayout._
import java.util.Date
import java.lang.Thread

object SampleAnimation extends JFrame {
  
  def main(args: Array[String]): Unit = {

    var canvas: AnimatedCanvas = new AnimatedCanvas()
    setLayout(new BorderLayout())
    add(canvas)
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    
    setSize(640, 480)
    setVisible(true)
    
    var shape: Square = new Square(30, 30, 30)
    canvas.add(shape)
    var time: Double = 0
    val start: Date = new Date()
    
    while(time < 10.0d) {
      val current: Date = new Date()
      time = (current.getTime() - start.getTime()) / 1000.0
      animate(time, shape)
      Thread.sleep(30)
      canvas.repaint()
      //var dif: Double = (after.getTime() - before.getTime()) / 1000        //converts the difference in milliseconds to a double
      //println(dif)
    }
    
    println("Done")
  }
  
  def animate(t: Double, s: Square): Unit = {
    s.x = t * 40.0
  }
  //implicit def lift(picture: ShapeExt): Double => ShapeExt = {
  //  
  //}
}
