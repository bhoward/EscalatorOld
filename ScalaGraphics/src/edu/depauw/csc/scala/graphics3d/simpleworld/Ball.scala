package edu.depauw.csc.scala.graphics3d.simpleworld;

import javax.vecmath.Vector3d
import edu.depauw.csc.scala.graphics3d.Sphere
import edu.depauw.csc.scala.graphics.Color
import javax.media.j3d.BranchGroup

/**
  A class for creating a ball shape in the simple world.  Inherits from the sphere
  class in the edu.depauw.csc.scala.graphics3d package, and in addition to implementing
  the methods specified by the ToyShape trait, sets the capability for the shape to be
  detached from the scene graph, allowing the shape to be deleted after creation.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 19, 2007
 */
class Ball(val radius: Double, xCoor: Double, yCoor: Double, zCoor: Double, c: Color) 
  extends Sphere(radius, c, xCoor, yCoor, zCoor) with ToyShape {  
  
  private val height: Double = radius * 2
  setCapability(BranchGroup.ALLOW_DETACH)
  
  def getHeight(): Double = height
  
  def getCenterOffset(): Double = radius
  
  def reposition(newX: Double, newY: Double, newZ: Double): Unit = {
    tran.set(new Vector3d(newX, newY, newZ))
    txtran.setTransform(tran)
  }
}
