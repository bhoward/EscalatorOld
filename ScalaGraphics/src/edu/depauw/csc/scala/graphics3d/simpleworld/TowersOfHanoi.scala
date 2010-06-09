package edu.depauw.csc.scala.graphics3d.simpleworld;

import javax.swing.JFrame
import java.lang.Thread
import edu.depauw.csc.scala.graphics._

object TowersOfHanoi extends JFrame {
  val aBoard: Board = Board(3, 1)
  def main(args: Array[String]): Unit = {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    add(WorldCanvas)
    setSize(1024, 1024)
    setVisible(true)
    aBoard.create(0, 0, 1, 0.5, Board.DISK)
    aBoard.create(0, 0, 0.8, 0.5, Board.DISK, Color.RED)
    aBoard.create(0, 0, 0.6, 0.5, Board.DISK, Color.BLUE)
    aBoard.create(0, 0, 0.4, 0.5, Board.DISK, Color.WHITE)
    aBoard.create(0, 0, 0.2, 0.5, Board.DISK, Color.YELLOW)
    towers(5, 0, 2, 1)
  }
  
  def towers(height: Int, from: Int, to: Int, other: Int) {
    if(height > 0) {
      towers(height - 1, from, other, to)
      shift(from, to)
      towers(height - 1, other, to, from)
    }
  }
  
  def shift(from: Int, to: Int) {
    Thread.sleep(1000)
    aBoard.move((from, 0), (to, 0))
  }
}
