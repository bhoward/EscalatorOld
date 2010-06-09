package edu.depauw.csc.scala.graphics3d;

import javax.swing.JFrame
import javax.vecmath.Point3f
import javax.vecmath.Point2f
import javax.media.j3d.Texture2D
import javax.media.j3d.QuadArray
import javax.media.j3d.GeometryArray
import javax.media.j3d.ImageComponent2D
import javax.media.j3d.Appearance
import javax.media.j3d.Texture
import javax.media.j3d.BranchGroup
import com.sun.j3d.utils.universe.SimpleUniverse
import com.sun.j3d.utils.image.TextureLoader
import edu.depauw.csc.scala.graphics._

/**
  Successful experiment in texturing a plane
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 30, 2007
 */
object Graphics3DDriver2 extends JFrame {
  def main(args: Array[String]) {
    
    //Create the texture from the 2D canvas
    var canvas: Canvas = new Canvas
    val shape1: Oval = Oval(0, 0, 400, 1000, Color.BLUE)
    val shape2: Rectangle = Rectangle(600, 300, 250, 590, Color.WHITE)
    canvas.add(shape1, shape2)
    
    //Create the objects needed for 3D graphics
    val surface: javax.media.j3d.Canvas3D = new javax.media.j3d.Canvas3D(SimpleUniverse.getPreferredConfiguration)
    val simpleU: SimpleUniverse = new SimpleUniverse(surface)
    simpleU.getViewingPlatform.setNominalViewingTransform
    setSize(1024, 1024)
    add(surface)
    setVisible(true)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    
    //Prepare the texture
    var loader: TextureLoader = new TextureLoader(canvas.extractImage)
    var comp2D: ImageComponent2D = loader.getImage
    var texture: Texture2D = new Texture2D(Texture.BASE_LEVEL, Texture.RGBA, comp2D.getWidth, comp2D.getHeight)
    texture.setImage(0, comp2D)
    var app: Appearance = new Appearance
    app.setTexture(texture)
    
    //Create the plane
    var plane: QuadArray = new QuadArray(4, GeometryArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2)
    var geomCoor: Point3f = new Point3f
    geomCoor.set(0, 1, -10)
    plane.setCoordinate(0, geomCoor)
    geomCoor.set(0, 0, -10)
    plane.setCoordinate(1, geomCoor)
    geomCoor.set(1, 0, -10)
    plane.setCoordinate(2, geomCoor)
    geomCoor.set(1, 1, -10)
    plane.setCoordinate(3, geomCoor)
    
    var texCoor: Point2f = new Point2f
    texCoor.set(0, 1)
    plane.setTextureCoordinate(0, texCoor)
    texCoor.set(0, 0)
    plane.setTextureCoordinate(1, texCoor)
    texCoor.set(1, 0)
    plane.setTextureCoordinate(2, texCoor)
    texCoor.set(1, 1)
    plane.setTextureCoordinate(3, texCoor)
    
    var planeObj: javax.media.j3d.Shape3D = new javax.media.j3d.Shape3D(plane, app)
    var bg: BranchGroup = new BranchGroup
    bg.addChild(planeObj)
    
    simpleU.addBranchGraph(bg)
  }
}