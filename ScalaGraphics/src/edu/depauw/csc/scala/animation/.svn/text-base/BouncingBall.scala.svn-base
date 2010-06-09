package edu.depauw.csc.scala.animation;

import javax.swing._
import edu.depauw.csc.scala.graphics._
import java.lang.Thread
import java.awt.BorderLayout, BorderLayout._
import java.util.Date
import java.lang.Math

object BouncingBall extends JFrame {
  
  def main(args: Array[String]): Unit = {
    var canvas: AnimatedCanvas = new AnimatedCanvas()
    setLayout(new BorderLayout())
    add(canvas)
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    
    setSize(640, 480)
    setVisible(true)
        
    var time: Double = 0
    val start: Date = new Date()
    
    var ball: Circle = Circle(10, 10, 10, Color.RED)
    canvas.add(ball)
    
    while(ball.x < 640) {
      val current: Date = new Date()
      time = (current.getTime() - start.getTime()) / 1000.0
      animate(time, ball)
      Thread.sleep(1)
      canvas.repaint()
    }
    
  }
  
  def animate(t: Double, c: Circle): Unit = {
    c.y = 420 * (Math.sin(t) * Math.sin(t))
    c.x = t * 20
  }
}
