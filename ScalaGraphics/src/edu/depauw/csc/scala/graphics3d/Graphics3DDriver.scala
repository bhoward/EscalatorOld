package edu.depauw.csc.scala.graphics3d;

import javax.swing.JFrame
import java.lang.Math, Math._
import java.lang.Thread
import java.util.Date
import edu.depauw.csc.scala.graphics.Color

object Graphics3DDriver extends JFrame {
  
  def main(args: Array[String]): Unit = {
    val surface = new Canvas3D()
    var shape: Shape3D = new Box(1.6, 1.6, 1.6, Color.BLUE, 1.6, 1.6, -195.2)
    var shape2: Shape3D = new Cylinder(1.6, 3.2, Color.RED, 1.6, 1.6, -198.4)
    shape2.rotate(Math.PI/2, 0, 0)
    var shape3: Shape3D = new Box(51.2, 51.2, 0.01, Color.GREEN, 51.2, 51.2, -200)
    setSize(1024, 1024)
    add(surface)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setVisible(true)
    surface.addShape(shape, shape2, shape3)
    var i: int = 2
    var toggle: boolean = false
    println("Proceeding")
    val d1: Date = new Date()
    while(i < 32) {
      if(toggle) {
        surface.addShape(new Box(1.6, 1.6, 1.6, Color.BLUE, (i * 3.2 + 1.6), 1.6, -198.4))
      }
      else {
        surface.addShape(new Box(1.6, 1.6, 1.6, Color.RED, (i * 3.2 + 1.6), 1.6, -198.4))
      }
      i += 1
      toggle = !toggle
      //Thread.sleep(100)
    }
    val d2: Date = new Date()
    println("Finished in " + (d2.getTime() - d1.getTime()) + " milliseconds")
  }
}
