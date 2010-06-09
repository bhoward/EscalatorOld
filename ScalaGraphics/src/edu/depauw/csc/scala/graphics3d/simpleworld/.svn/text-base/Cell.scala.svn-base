package edu.depauw.csc.scala.graphics3d.simpleworld;

/**
  Data structure used to hold information about all the shapes in this
  section of the board
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 19, 2007
 */
class Cell {
  private var lis: List[ToyShape] = List()
  private var height: Double = 0

  /**
    Adds a shape to this cell's stack
    
    @param newShape The ToyShape to add to this cell's stack
   */
  def add(newShape: ToyShape): Unit = {
    height = (newShape.getHeight) + height
    lis = newShape :: lis
  }
  
  /**
    @return the total height of the cell's contents
   */
  def getHeight(): Double = {
    height
  }
  
  /**
    @return the top shape on the cell's stack
   */
  def top(): ToyShape = {
    lis.head
  }
  
  /**
    Removes the current top shape from the stack, does not remove the shape from the scene graph
   */
  def removeTop(): Unit = {
    height = height - (lis.head.getHeight)
    lis = lis.tail
  }
  
  /**
    @return true if the cell is empty
   */
  def isEmpty(): Boolean = {
    if(lis == List()) {
      true
    }
    else false
  }
}
