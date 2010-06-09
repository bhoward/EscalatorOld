package edu.depauw.csc.scala.graphics;

import javax.swing._

object Sierpinski extends JFrame {
  
  val surface: Canvas = Canvas()
  
  def main(args: Array[String]): Unit = {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setSize(1024, 1024)
    add(surface)
    setVisible(true)
    surface.add(sTri(250, 550, 500, 15))
  }
  
  /*
  def sTriangle(x: Int, y: Int, size: Int, limit: Int) {
    if (size <= limit) {
      fillTri(x, y, size)
    }
    else
    {
      sTriangle(x, y, size / 2, limit)
      sTriangle(x, y - (size / 2), size / 2, limit)
      sTriangle(x + (size / 2), y, size / 2, limit)
    }
  }
  
  def fillTri(x: Int, y: Int, size: Int): Unit = {
    var xpoints: Array[Int] = new Array[Int](3)
    var ypoints: Array[Int] = new Array[Int](3)
    ypoints(0) = y
    ypoints(1) = y
    ypoints(2) = (y - size)
    xpoints(0) = x
    xpoints(1) = (x + size)
    xpoints(2) = x
    surface.add(PolygonExt(xpoints, ypoints, 3, Color.BLUE, Color.BLACK))
  }
  */
  
  def sTri(x: Int, y: Int, size: Int, limit: Int): ShapeExt = {
    if (size <= limit) {
      fillTri(x, y, size)
    } else {
      val half = size / 2
      sTri(x, y, half, limit) +++
      sTri(x, y-half, half, limit) +++
      sTri(x+half, y, half, limit)
    }
}

  def fillTri(x: Int, y: Int, size: Int): ShapeExt = {
    PolygonExt(List((x, y), (x+size, y), (x, y-size)),
        Color.BLUE, Color.BLACK)
  }

}
