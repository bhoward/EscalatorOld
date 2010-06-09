package edu.depauw.csc.scala.graphics3d.simpleworld;

import edu.depauw.csc.scala.graphics._
import javax.swing.JFrame
import java.lang.Thread

object WorldDriver extends JFrame {
  def main(args: Array[String]) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    val shape: ShapeExt = createPicture(256, 256, 256, 9, Color.RED)
    var canvas: Canvas = Canvas(shape)
    add(WorldCanvas)
    setSize(1024, 1024)
    setVisible(true)
    val aBoard: Board = Board(8, 8)
    aBoard.addTexture(canvas)
    println(aBoard.create(0, 0, 1, 3.2, Board.BALL, Color.RED))
    println(aBoard.create(1, 0, 0.5, 3.2, Board.BLOCK, Color.BLUE))
    println(aBoard.create(7, 7, 1, 3.2, Board.DISK, Color.LIGHT_GRAY))
    println(aBoard.create(7, 7, 0.75, 1, Board.BALL, Color.DARK_GRAY))
    println(aBoard.create(7, 7, 0.3, 3, Board.BLOCK, Color.GREEN))
    println(aBoard.create(30, 30, 0.5, 1, Board.BALL))
    println(aBoard.create(0, 0, 4, 4, Board.BALL))
    println(aBoard.create(3, 3, 0.4, 2.2, Board.DISK, Color.CYAN))
    println(aBoard.create(3, 0, 1, 3.2, Board.BLOCK, Color.YELLOW))
    println(aBoard.create(3, 0, 1, 1, Board.BALL, Color.BLUE))
    println(aBoard.move((3, 0), (7, 7)))
    println(aBoard.move((3, 3), (0, 0)))
    println(aBoard.delete(1, 0))
    println("Finished")
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