package edu.depauw.csc.scala.graphics3d;

import com.sun.j3d.utils.universe.SimpleUniverse
import com.sun.j3d.utils.universe.PlatformGeometry
import com.sun.j3d.utils.geometry.ColorCube
import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior
import javax.media.j3d.BranchGroup
import javax.media.j3d.DirectionalLight
import javax.media.j3d.BoundingSphere
import javax.media.j3d.BoundingLeaf
import javax.media.j3d.TransformGroup
import javax.vecmath.Vector3f
import javax.vecmath.Color3f
import javax.vecmath.Point3d
import java.awt.GraphicsConfiguration
import java.awt.Color, Color._

/**
  Companion object for the Canvas3D class that handles constructors.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 1, 2007
 */
object Canvas3D {
  def apply() = new Canvas3D()
  def apply(s: Shape3D) = new Canvas3D(s)
  def apply(someShapes: Shape3D*): Canvas3D = {
    var result: Canvas3D = new Canvas3D()
    for(shape <- someShapes) {
      result.addShape(shape)
    }
    return result
  }
}

/**
  A component for displaying 3-dimensional graphics in an application or applet.  This canvas class also handles
  the scene graph from its root (the universe) and also the view.  In order to better show the 3D quality of the
  shapes, a directional light source has been added.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version June 29, 2007
 */
class Canvas3D extends javax.media.j3d.Canvas3D(SimpleUniverse.getPreferredConfiguration()) {
  
  private var simpleU: SimpleUniverse = new SimpleUniverse(this)
  
  //Setup the omnipresent light source
  private var light: DirectionalLight = new DirectionalLight(new Color3f(Color.WHITE), new Vector3f(-0.25f, -0.25f, -0.5f))
  private var influence: BoundingSphere = new BoundingSphere()
  influence.setRadius(1000)
  light.setInfluencingBounds(influence)
  simpleU.getViewingPlatform().setNominalViewingTransform()
  var stuff = new BranchGroup()
  stuff.addChild(light)
  
  //Setup the view navigation
  var viewPoint: TransformGroup = null
  viewPoint = simpleU.getViewingPlatform().getViewPlatformTransform()
  var binding: BoundingLeaf = new BoundingLeaf(new BoundingSphere(new Point3d, 10.0))
  var plat: PlatformGeometry = new PlatformGeometry()
  plat.addChild(binding)
  simpleU.getViewingPlatform.setPlatformGeometry(plat)
  simpleU.getViewer.getView.setBackClipDistance(1024)
  var keyBehave: KeyNavigatorBehavior = new KeyNavigatorBehavior(viewPoint)
  keyBehave.setSchedulingBoundingLeaf(binding)
  stuff.addChild(keyBehave)
  simpleU.addBranchGraph(stuff)
  
  /**
    Secondary constructor which allows a shape to be added to the canvas at the time of construction.
    
    @param s The shape to insert into the new canvas
   */
  def this(s: Shape3D) {
    this()
    addShape(s)
  }
  
  /**
    Secondary constructor which can start the canvas with an arbitrary amount of shapes.
    
    @param someShapes The shapes to add to the canvas
   */
  def this(someShapes: Shape3D*) {
    this()
    for(shape <- someShapes) {
      addShape(shape)
    }
  }
  
  /**
    Adds one of the graphics3D primitives to the canvas
    
    @param addition One of the shape primitives
    */
  def addShape(addition: Shape3D): Unit = {
    addition.asInstanceOf[BranchGroup].compile()
    simpleU.addBranchGraph(addition.asInstanceOf[BranchGroup])  //Have to typecast because Shape3D doesn't ensure BranchGroup typing
    repaint
  }
  
  /**
    Adds an arbitrary amount of primitive shapes to the canvas
    
    @param addition The shapes to be added
    */
  def addShape(addition: Shape3D*): Unit = {
    for(val shape <- addition) {
      shape.asInstanceOf[BranchGroup].compile()
      simpleU.addBranchGraph(shape.asInstanceOf[BranchGroup])
    }
    repaint
  }
}
