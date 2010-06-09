package edu.depauw.csc.scala.graphics3d.simpleworld;

import com.sun.j3d.utils.universe.SimpleUniverse
import com.sun.j3d.utils.universe.PlatformGeometry
import com.sun.j3d.utils.geometry.ColorCube
import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior
import javax.media.j3d.Background
import javax.media.j3d.BranchGroup
import javax.media.j3d.DirectionalLight
import javax.media.j3d.BoundingSphere
import javax.media.j3d.BoundingLeaf
import javax.media.j3d.TransformGroup
import javax.media.j3d.Transform3D
import javax.vecmath.Vector3f
import javax.vecmath.Color3f
import javax.vecmath.Point3d
import java.awt.GraphicsConfiguration
import java.awt.Color, Color._
import java.lang.Math, Math._

/**
 The simple world only needs one instance of a canvas, and the default view needed to be
 slightly changed, so most of the code in this object is identical to the code in the
 Canvas3D class found in the edu.depauw.csc.scala.graphics3d package.
      
 @author Cory Boatright, boatrightcd@hiram.edu
 @version July 23, 2007
*/
object WorldCanvas extends javax.media.j3d.Canvas3D(SimpleUniverse.getPreferredConfiguration()) {
    
  private var simpleU: SimpleUniverse = new SimpleUniverse(this)
    
  //Setup the omnipresent light source
  private var light: DirectionalLight = new DirectionalLight(new Color3f(Color.WHITE), new Vector3f(-0.25f, 0.45f, -0.5f))
  private var influence: BoundingSphere = new BoundingSphere()
  influence.setRadius(1000)
  light.setInfluencingBounds(influence)
  simpleU.getViewingPlatform().setNominalViewingTransform()
  private var stuff = new BranchGroup()
  stuff.addChild(light)
  
  //Set the background color to white
  private var back: Background = new Background(new Color3f(Color.DARK_GRAY))
  back.setApplicationBounds(influence)
  stuff.addChild(back)
  
  //Setup the view navigation
  private var viewPoint: TransformGroup = null
  viewPoint = simpleU.getViewingPlatform().getViewPlatformTransform()
  private var binding: BoundingLeaf = new BoundingLeaf(new BoundingSphere(new Point3d, 10.0))
  private var plat: PlatformGeometry = new PlatformGeometry()
  plat.addChild(binding)
  simpleU.getViewingPlatform.setPlatformGeometry(plat)
  simpleU.getViewer.getView.setBackClipDistance(1024)
  private var keyBehave: KeyNavigatorBehavior = new KeyNavigatorBehavior(viewPoint)
  keyBehave.setSchedulingBoundingLeaf(binding)
  stuff.addChild(keyBehave)
  simpleU.addBranchGraph(stuff)
  
  /**
   Adds one of the graphics3D primitives to the canvas
   
   @param addition One of the shape primitives
  */
  def addShape(addition: ToyShape): Unit = {
    addition.asInstanceOf[BranchGroup].compile()
    simpleU.addBranchGraph(addition.asInstanceOf[BranchGroup])  //Have to typecast because Shape3D doesn't ensure BranchGroup typing
    repaint
  }
    
  /**
    Adds an arbitrary amount of primitive shapes to the canvas
    
    @param addition The shapes to be added
  */
  def addShape(addition: ToyShape*): Unit = {
    for(val shape <- addition) {
      shape.asInstanceOf[BranchGroup].compile()
      simpleU.addBranchGraph(shape.asInstanceOf[BranchGroup])
    }
    repaint
  }
  
  /**
    Adds a board to the canvas.  Necessary because the board is not a ToyShape.
    
    @param addition The board to be added
   */
  def addShape(addition: Board): Unit = {
    addition.compile()
    simpleU.addBranchGraph(addition)  //Have to typecast because Shape3D doesn't ensure BranchGroup typing
    repaint
  }
}
