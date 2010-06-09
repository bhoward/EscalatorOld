package edu.depauw.csc.scala.graphics3d.simpleworld;

import edu.depauw.csc.scala.graphics3d.Shape3D

/**
  Trait which extends the Shape3D trait.  Adds methods for getting the object's
  height, its actual center of mass, and repositioning of the shape.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 19, 2007
 */
trait ToyShape extends Shape3D {
  
  /**
    Returns the overall height of this shape
    
    @return a value with double precision representing the height of the shape
   */
  def getHeight(): Double
  
  /**
    Moves the shape via a translation
    
    @param newX The new x-coordinate for the shape
    @param newY The new y-coordinate for the shape
    @param newZ The new z-coordinate for the shape
   */
  def reposition(newX: Double, newY: Double, newZ: Double): Unit
  
  /**
    Returns the offset of the center of the object from its bottom
    
    @return the z-value for the center of mass of this shape
   */
  def getCenterOffset(): Double
}