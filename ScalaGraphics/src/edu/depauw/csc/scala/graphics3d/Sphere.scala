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
  Companion object for the sphere class which handles constructors
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 1, 2007
 */
object Sphere {
  def apply(rad: Double) = new Sphere(rad)
  def apply(rad: Double, c: Color) = new Sphere(rad, c)
  def apply(rad: Double, c: Color, x: Double, y: Double, z: Double) = new Sphere(rad, c, x, y, z)
}

/**
  Due to how the Java3D system works, it will be easier and more efficient in the long run to actually represent
  the 3D primitives as BranchGroups and rather than inherit the existing shapes, contain them as instance fields.
  This is a sphere shape, and by default will be placed at the origin.
  
  @author Cory Boatright
  @version June 25, 2007
  */
class Sphere(protected val rad: Double) extends BranchGroup with Shape3D {
  
  //Because the same class name is used, need to give the full name of the sphere instance field  
  protected var app: Appearance = new Appearance()
  private var shape: com.sun.j3d.utils.geometry.Sphere = new com.sun.j3d.utils.geometry.Sphere(rad.asInstanceOf[Float], 
      Primitive.GENERATE_NORMALS, 60, app)
  app.setCapability(Appearance.ALLOW_MATERIAL_WRITE)
  app.setMaterial(new Material())
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
    Secondary constructor which also takes a color to set the sphere to be.  The shape will be placed at the origin.
      
    @param rad The radius of the sphere as a floating point number
    @param c The java.awt.Color the sphere should be set to
    */
  def this(rad: Double, c: Color) {
    this(rad)
    val newColor: Color3f = new Color3f(c.dumpColor)
    var mat: Material = new Material()
    mat.setDiffuseColor(newColor)
    mat.setShininess(85)
    app.setMaterial(mat)
  }
  
  /**
    Secondary constructor which takes a color but also takes a non-origin point of placement.
    
    @param rad The radius of the sphere as a floating point number
    @param c The java.awt.Color the sphere should be set to
    @param x The x-coordinate in three-dimensional space as a floating point number
    @param y The y-coordinate in three-dimensional space as a floating point number
    @param z The z-coordinate in three-dimensional space as a floating point number
    */
  def this(rad: Double, c: Color, x: Double, y: Double, z: Double) {
    this(rad, c)
    val pos: Vector3d = new Vector3d(x, y, z)
    tran.set(pos)
    txtran.setTransform(tran)
  }
  
  /**
    Rotates the sphere along the x-, y-, and z-directions
    
    @param xm The magnitude of rotation in the x-direction
    @param ym The magnitude of rotation in the y-direction
    @param zm The magnitude of rotation in the z-direction
    */
  def rotate(xm: Double, ym: Double, zm: Double): Unit = {
    //Nothing here because a sphere looks the same when it's rotated in any direction
  }
  
  /**
    Scales the sphere by the given value
    
    @param ratio The amount by which to scale the shape, acquired by dividing the new size by the old size
    */
  def scale(ratio: Double): Unit = {
    scal.setScale(ratio)
    txscale.setTransform(scal)
  }
  
  /**
    Translates the sphere in three-dimensional space
    
    @param xm The x-amount to translate the sphere
    @param ym The y-amount to translate the sphere
    @param zm The z-amount to translate the sphere
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
    Changes the color of the sphere
    
    @param c The new color to use for the sphere
    */
  def changeColor(c: Color): Unit = {
      val newColor: Color3f = new Color3f(c.dumpColor)
      var mat: Material = new Material()
      mat.setDiffuseColor(newColor)
      mat.setShininess(85)
      app.setMaterial(mat)
  }
}
