package edu.depauw.csc.scala.graphics3d.simpleworld;

import javax.vecmath.Vector3d
import edu.depauw.csc.scala.graphics.Color
import edu.depauw.csc.scala.graphics3d.Box
import javax.media.j3d.BranchGroup

/**
  A class for creating a block shape in the simple world.  Inherits from the box
  class in the edu.depauw.csc.scala.graphics3d package, and in addition to implementing
  the methods specified by the ToyShape trait, sets the capability for the shape to be
  detached from the scene graph, allowing the shape to be deleted after creation.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 19, 2007
 */
class Block(xDir: Double, yDir: Double, zDir: Double, xCoor: Double, yCoor: Double, zCoor: Double, c: Color) 
  extends Box(xDir, yDir, zDir, c, xCoor, yCoor, zCoor) with ToyShape {
  
  private val height = zDir * 2
  setCapability(BranchGroup.ALLOW_DETACH)
  
  def getHeight(): Double = height
  
  def getCenterOffset(): Double = height / 2
  
  def reposition(newX: Double, newY: Double, newZ: Double): Unit = {
    tran.set(new Vector3d(newX, newY, newZ))
    txtran.setTransform(tran)
  }
}
