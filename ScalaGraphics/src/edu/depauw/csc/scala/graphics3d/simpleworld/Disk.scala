package edu.depauw.csc.scala.graphics3d.simpleworld;

import java.lang.Math, Math._
import javax.vecmath.Vector3d
import edu.depauw.csc.scala.graphics.Color
import edu.depauw.csc.scala.graphics3d.Cylinder
import javax.media.j3d.BranchGroup

/**
  A class for creating a disk shape in the simple world.  Inherits from the cylinder
  class in the edu.depauw.csc.scala.graphics3d package, and in addition to implementing
  the methods specified by the ToyShape trait, sets the capability for the shape to be
  detached from the scene graph, allowing the shape to be deleted after creation.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 19, 2007
 */
class Disk(radius: Double, zDir: Double, xCoor: Double, yCoor: Double, zCoor: Double, c: Color) 
  extends Cylinder(radius, zDir, c, xCoor, yCoor, zCoor) with ToyShape {  
  
  private val h: Double = zDir
  setCapability(BranchGroup.ALLOW_DETACH)
  
  rotate(Math.PI / 2, 0, 0)
  
  def getHeight(): Double = h
  
  def getCenterOffset(): Double = h / 2
  
  def reposition(newX: Double, newY: Double, newZ: Double): Unit = {
    tran.set(new Vector3d(newX, newY, newZ))
    txtran.setTransform(tran)
  }
}
