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
  Companion object for the cone class which handles constructors.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 1, 2007
 */
object Cone {
  def apply(rad: Double, height: Double) = new Cone(rad, height)
  def apply(rad: Double, height: Double, c: Color) = new Cone(rad, height, c)
  def apply(rad: Double, height: Double, c: Color, x: Double, y: Double, z: Double) = new Cone(rad, height, c, x, y, z)
}

/**
  A cone primitive for the 3D graphics package.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version June 26, 2007
 */
class Cone(protected val rad: Double, protected val height: Double) extends BranchGroup with Shape3D {
  
  //Selfishly decided to keep the Cone name, so needed to use full path of the j3d cone class
  protected var app: Appearance = new Appearance()
  app.setCapability(Appearance.ALLOW_MATERIAL_WRITE)
  app.setMaterial(new Material())
  private var shape: com.sun.j3d.utils.geometry.Cone = new com.sun.j3d.utils.geometry.Cone(rad.asInstanceOf[Float], 
      height.asInstanceOf[Float], Primitive.GENERATE_NORMALS, 60, 4, app)
  //The transform groups behave in a manner not necessarily intuitive, altering them will require recreating the tree
  protected var rot: Transform3D = new Transform3D()
  protected var tran: Transform3D = new Transform3D()
  protected var scal: Transform3D = new Transform3D()
  protected var txrot: TransformGroup = new TransformGroup(rot)
  txrot.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE)
  protected var txtran: TransformGroup = new TransformGroup(tran)
  txtran.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE)
  protected var txscale: TransformGroup = new TransformGroup(scal)
  txscale.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE)
  shape.setAppearance(app)
  txrot.addChild(shape)
  txscale.addChild(txrot)
  txtran.addChild(txscale)
  addChild(txtran)
  
  /**
    Secondary constructor which takes an initial color
    
    @param rad The radius of the base of the cone
    @param height The height of the cone
    @param c The java.awt.Color the cone should be set to
   */
  def this(rad: Double, height: Double, c: Color) {
    this(rad, height)
    val newColor: Color3f = new Color3f(c.dumpColor)
    var mat: Material = new Material()
    mat.setDiffuseColor(newColor)
    mat.setShininess(85)
    app.setMaterial(mat)
  }
  
  /**
    Secondary constructor which takes a color but also takes a non-origin point of placement.
    
    @param rad The radius of the base of the cone
    @param height The height of the cone
    @param c The java.awt.Color the cone should be set to
    @param x The x-coordinate in three-dimensional space
    @param y The y-coordinate in three-dimensional space
    @param z The z-coordinate in three-dimensional space
   */
  def this(rad: Double, height: Double, c: Color, x: Double, y: Double, z: Double) {
    this(rad, height, c)
    val pos: Vector3d = new Vector3d(x, y, z)
    tran.set(pos)
    txtran.setTransform(tran)
  }
  
  /**
    Rotates the cone along the x-, y-, and z-directions
    
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
    Scales the cone by the given value
    
    @param ratio The amount by which to scale the shape, acquired by dividing the new size by the old size
   */
  def scale(ratio: Double): Unit = {
    scal.setScale(ratio)
    txscale = new TransformGroup(scal)
  }
  
  /**
    Translates the cone in three-dimensional space
    
    @param xm The x-amount to translate the cone
    @param ym The y-amount to translate the cone
    @param zm The z-amount to translate the cone
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
    Changes the color of the cone
    
    @param c The new color to use for the cone
   */
  def changeColor(c: Color): Unit = {
      val newColor: Color3f = new Color3f(c.dumpColor)
      var mat: Material = new Material()
      mat.setDiffuseColor(newColor)
      mat.setShininess(85)
      app.setMaterial(mat)
  }
}
