package edu.depauw.csc.scala.graphics3d;

import javax.media.j3d.Appearance
import javax.media.j3d.ColoringAttributes
import javax.media.j3d.TransformGroup
import javax.media.j3d.Transform3D
import javax.media.j3d.BranchGroup
import javax.media.j3d.Material
import javax.vecmath.Color3f
import javax.vecmath.Vector3d
import com.sun.j3d.utils.geometry.Primitive
import edu.depauw.csc.scala.graphics.Color

/**
  Companion object for the box class which handles constructors.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 1, 2007
 */
object Box {
  def apply(xl: Double, yl: Double, zl: Double) = new Box(xl, yl, zl)
  def apply(xl: Double, yl: Double, zl: Double, c: Color) = new Box(xl, yl, zl, c)
  def apply(xl: Double, yl: Double, zl: Double, c: Color, x: Double, y: Double, z: Double) = new Box(xl, yl, zl, c, x, y, z)
}

/**
  A box primitive for the 3D graphics package.
  
  @author Cory Boatright
  @version June 27, 2007
 */
class Box(protected val xl: Double, protected val yl: Double, protected val zl: Double) extends BranchGroup with Shape3D {
  
  protected var app: Appearance = new Appearance()
  app.setMaterial(new Material())
  app.setCapability(Appearance.ALLOW_MATERIAL_WRITE)
  private var shape: com.sun.j3d.utils.geometry.Box = new com.sun.j3d.utils.geometry.Box(xl.asInstanceOf[Float], yl.asInstanceOf[Float], 
      zl.asInstanceOf[Float], Primitive.GENERATE_NORMALS, app)
  protected var rot: Transform3D = new Transform3D()
  protected var tran: Transform3D = new Transform3D()
  protected var scal: Transform3D = new Transform3D()
  protected var txrot: TransformGroup = new TransformGroup(rot)
  txrot.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE)
  protected var txtran: TransformGroup = new TransformGroup(tran)
  txtran.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE)
  protected var txscale: TransformGroup = new TransformGroup(scal)
  txscale.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE)
  txrot.addChild(shape)
  txscale.addChild(txrot)
  txtran.addChild(txscale)
  addChild(txtran)

  /**
    Secondary constructor which takes an initial color
    
    @param xl The x-length of the box
    @param yl The y-length of the box
    @param zl The z-length of the box
    @param c The java.awt.Color the box should be set to
   */
  def this(xl: Double, yl: Double, zl: Double, c: Color) {
    this(xl, yl, zl)
    val newColor: Color3f = new Color3f(c.dumpColor)
    var mat: Material = new Material()
    mat.setDiffuseColor(newColor)
    mat.setShininess(85)
    app.setMaterial(mat)
  }

  /**
    Secondary constructor which takes a color but also takes a non-origin point of placement.
    
    @param xl The x-length of the box
    @param yl The y-length of the box
    @param zl The z-length of the box
    @param c The java.awt.Color the box should be set to
    @param x The x-coordinate in three-dimensional space
    @param y The y-coordinate in three-dimensional space
    @param z The z-coordinate in three-dimensional space
   */
  def this(xl: Double, yl: Double, zl: Double, c: Color, x: Double, y: Double, z: Double) {
    this(xl, yl, zl, c)
    val pos: Vector3d = new Vector3d(x, y, z)
    tran.set(pos)
    txtran.setTransform(tran)
  }

  /**
    Rotates the box along the x-, y-, and z-directions
    
    @param xm The radians of rotation in the x-direction in a counter-clockwise direction
    @param ym The radians of rotation in the y-direction in a counter-clockwise direction
    @param zm The radians of rotation in the z-direction in a counter-clockwise direction
   */
  def rotate(xm: Double, ym: Double, zm: Double): Unit = {
    var compZ: Transform3D = new Transform3D()
    var compY: Transform3D = new Transform3D()
    var compX: Transform3D = new Transform3D()
    compZ.rotZ(zm)
    compY.rotY(ym)
    compX.rotX(xm)
    rot = new Transform3D(compX)
    rot.mul(compY)
    rot.mul(compZ)
    txrot.setTransform(rot)
  }

  /**
    Scales the box by the given value
    
    @param ratio The amount by which to scale the shape, acquired by dividing the new size by the old size
   */
  def scale(ratio: Double): Unit = {
    scal.setScale(ratio)
    txscale.setTransform(scal)
  }

  /**
    Translates the box in three-dimensional space
    
    @param xm The x-amount to translate the box
    @param ym The y-amount to translate the box
    @param zm The z-amount to translate the box
   */
  def translate(xm: Double, ym: Double, zm: Double): Unit = {
    var vec2: Vector3d = new Vector3d(xm, ym, zm)
    var vec1: Vector3d = new Vector3d()
    tran.get(vec1)
    vec1.add(vec2)
    tran.set(vec1)
    txtran.setTransform(tran)
  }

  /**
    Changes the color of the box
    
    @param c The new color to use for the box
   */
  def changeColor(c: Color): Unit = {
      val newColor: Color3f = new Color3f(c.dumpColor)
      var mat: Material = new Material()
      mat.setDiffuseColor(newColor)
      mat.setShininess(85)
      app.setMaterial(mat)
  }
}
