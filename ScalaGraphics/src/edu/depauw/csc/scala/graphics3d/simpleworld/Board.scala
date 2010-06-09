package edu.depauw.csc.scala.graphics3d.simpleworld;

import com.sun.j3d.utils.geometry.Box
import com.sun.j3d.utils.geometry.Primitive
import com.sun.j3d.utils.image.TextureLoader
import edu.depauw.csc.scala.graphics.Color
import edu.depauw.csc.scala.graphics.Canvas
import javax.vecmath.Color3f
import javax.vecmath.Vector3d
import javax.vecmath.Point3f
import javax.vecmath.Point2f
import javax.media.j3d.BranchGroup
import javax.media.j3d.Appearance
import javax.media.j3d.ColoringAttributes
import javax.media.j3d.Transform3D
import javax.media.j3d.TransformGroup
import javax.media.j3d.ImageComponent2D
import javax.media.j3d.Texture2D
import javax.media.j3d.Texture
import javax.media.j3d.Shape3D
import javax.media.j3d.QuadArray
import javax.media.j3d.GeometryArray

/**
  Companion object that handles constructors as well as shape constants.  The
  default board is 32 x 32 cells in size.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 19, 2007
 */
object Board {
  def apply() = new Board(32, 32, Color.GREEN)
  def apply(x: Int, y: Int) = new Board(x, y, Color.GREEN)
  def apply(color: Color) = new Board(32, 32, color)
  def apply(x: Int, y: Int, color: Color) = new Board(x, y, color)
  def BLOCK: Int = 0
  def DISK: Int = 1
  def BALL: Int = 2
}

/**
  A class for representing an arbitrarily sized board.  The size of the board is determined by
  cells, each cell is 3.2 x 3.2 units.
  
  @author Cory Boatright, boatrightcd@hiram.edu
  @version July 19, 2007
 */
class Board(val x: Int, val y: Int, val color: Color) extends BranchGroup {
 
  //initialize the two-dimensional array
  private var arr: Array[Array[Cell]] = new Array[Array[Cell]](x)
  for(i <- Iterator.range(0, x)) {
      arr(i) = new Array[Cell](y)
      for(j <- Iterator.range(0, y)) {
        arr(i)(j) = new Cell
      }
  }
  
  //Create geometry
  //Create the plane
  private var plane: QuadArray = new QuadArray(4, GeometryArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2)
  private var geomCoor: Point3f = new Point3f
  geomCoor.set(0, 3.2f * y, -200)
  plane.setCoordinate(0, geomCoor)
  geomCoor.set(0, 0, -200)
  plane.setCoordinate(1, geomCoor)
  geomCoor.set(3.2f * x, 0, -200)
  plane.setCoordinate(2, geomCoor)
  geomCoor.set(3.2f * x, 3.2f * y, -200)
  plane.setCoordinate(3, geomCoor)
  
  private var texCoor: Point2f = new Point2f
  texCoor.set(0, 1)
  plane.setTextureCoordinate(0, texCoor)
  texCoor.set(0, 0)
  plane.setTextureCoordinate(1, texCoor)
  texCoor.set(1, 0)
  plane.setTextureCoordinate(2, texCoor)
  texCoor.set(1, 1)
  plane.setTextureCoordinate(3, texCoor)
  
  private var app: Appearance = new Appearance
  app.setColoringAttributes(new ColoringAttributes(new Color3f(color.dumpColor), ColoringAttributes.FASTEST))
  
  private var planeObj: Shape3D = new Shape3D(plane, app)
  planeObj.setCapability(Shape3D.ALLOW_APPEARANCE_WRITE)
  addChild(planeObj)
  WorldCanvas.addShape(this)
  
  /**
    Uses a 2D canvas to paint on the surface of the board
    
    @param source The canvas which will serve as the image to texture the board
   */
  def addTexture(source: Canvas): Unit = {
    var loader: TextureLoader = new TextureLoader(source.extractImage)
    var comp2D: ImageComponent2D = loader.getImage
    var texture: Texture2D = new Texture2D(Texture.BASE_LEVEL, Texture.RGBA, comp2D.getWidth, comp2D.getHeight)
    texture.setImage(0, comp2D)
    var app2: Appearance = new Appearance
    app2.setTexture(texture)
    planeObj.setAppearance(app2)
  }
  
  /**
    Moves a shape from the top of one stack to the top of another stack.
    
    @param origin A tuple of two Ints which are the origin coordinates of the shape in board terms
    @param dest A tuple of two Ints which are the destination coordinates of the shape in board terms
    @return true if the move is successful, false if the origin stack is empty 
   */
  def move(origin: (Int, Int), dest: (Int, Int)): Boolean = {
    var newX: Int = 0
    var newY: Int = 0
    var oldX: Int = 0
    var oldY: Int = 0
    
    //Extract the coordinates from the origin tuple
    origin match {
      case (anX, aY) => {
        oldX = anX
        oldY = aY
      }
    }
    
    //If the origin coordinates point to an empty stack, end with a false return, else go on
    if((oldX >= x || oldX < 0) || (oldY >= y || oldY < 0) || arr(oldX)(oldY).isEmpty) {
      false
    }
    else {
      //Extract the coordinates from the destination tuple
      dest match {
        case (anX, aY) => {
          newX = anX
          newY = aY
        }
      }
      if((newX >= x || newX < 0) || (newY >= y || newY < 0)) {
        false
      }
      else {
        var tempShape: ToyShape = arr(oldX)(oldY).top
        var xCoor = 1.6 + newX * 3.2
        var yCoor = 1.6 + newY * 3.2
        var zCoor = -200 + arr(newX)(newY).getHeight + tempShape.getCenterOffset
        arr(oldX)(oldY).removeTop
        tempShape.reposition(xCoor, yCoor, zCoor)
        arr(newX)(newY).add(tempShape)
        true
      }
    }
  }
  
  /**
    Creates a new shape at the specified location with the specified shape and size.
    
    @param anX The x-coordinate in terms of the board for this shape
    @param aY The y-coordinate in terms of the board for this shape
    @param size The ratio in the domain (0, 1] of the size of the shape vs. the size of the cell
    @param zSize The vertical size of the shape, ignored for balls
    @param kind Either Board.BLOCK, Board.DISK, or Board.BALL
    @return True if the creation is successful, false otherwise
   */
  def create(anX: Int, aY: Int, size: Double, zSize: Double, kind: Int): Boolean = {
    //make sure everything's a valid number
    if((anX >= x || anX < 0) || (aY >= y || aY < 0) || (size > 1 || size <= 0) || zSize <= 0) false 
    else if(kind > 2 || kind < 0) false
    else {
      //find dimensions and position of new shape
      if(kind == Board.BLOCK) {
        var xDim: Double = size * 1.6
        var yDim: Double = size * 1.6
        var zDim: Double = zSize / 2.0
        
        var xCoor: Double = 1.6 + 3.2 * anX
        var yCoor: Double = 1.6 + 3.2 * aY
        var zCoor: Double = -200 + arr(anX)(aY).getHeight + zSize
        
        var newShape: ToyShape = new Block(xDim, yDim, zDim, xCoor, yCoor, zCoor, Color.LIGHT_GRAY)
        arr(anX)(aY).add(newShape)
        WorldCanvas.addShape(newShape)
        true
      }
      else if(kind == Board.DISK) {
        var radius: Double = 1.6 * size
        var zDim: Double = zSize
          
        var xCoor: Double = 1.6 + 3.2 * anX
        var yCoor: Double = 1.6 + 3.2 * aY
        var zCoor: Double = -200 + arr(anX)(aY).getHeight + (zDim / 2)
        
        var newShape: ToyShape = new Disk(radius, zDim, xCoor, yCoor, zCoor, Color.LIGHT_GRAY)
        arr(anX)(aY).add(newShape)
        WorldCanvas.addShape(newShape)
        true
      }
      else if(kind == Board.BALL) {
        var radius: Double = 1.6 * size
        
        var xCoor: Double = 1.6 + 3.2 * anX
        var yCoor: Double = 1.6 + 3.2 * aY
        var zCoor: Double = -200 + arr(anX)(aY).getHeight + radius
        
        var newShape: ToyShape = new Ball(radius, xCoor, yCoor, zCoor, Color.LIGHT_GRAY)
        arr(anX)(aY).add(newShape)
        WorldCanvas.addShape(newShape)
        true
      }
      else false
    }
  }

  /**
    Creates a new shape at the specified location with the specified shape, size, and color.
    
    @param anX The x-coordinate in terms of the board for this shape
    @param aY The y-coordinate in terms of the board for this shape
    @param size The ratio in the domain (0, 1] of the size of the shape vs. the size of the cell
    @param zSize The vertical size of the shape, ignored for balls
    @param kind Either Board.BLOCK, Board.DISK, or Board.BALL
    @param col The color of the shape to be created
    @return True if the creation is successful, false otherwise
   */
  def create(anX: Int, aY: Int, size: Double, zSize: Double, kind: Int, col: Color): Boolean = {
    //make sure everything's a valid number
    if((anX >= x || anX < 0) || (aY >= y || aY < 0) || (size > 1 || size <= 0) || zSize <= 0) false 
    else if(kind > 2 || kind < 0) false
    else {
      //find dimensions and position of new shape
      if(kind == Board.BLOCK) {
        var xDim: Double = size * 1.6
        var yDim: Double = size * 1.6
        var zDim: Double = zSize / 2.0
        
        var xCoor: Double = 1.6 + 3.2 * anX
        var yCoor: Double = 1.6 + 3.2 * aY
        var zCoor: Double = -200 + arr(anX)(aY).getHeight + zDim
        
        var newShape: ToyShape = new Block(xDim, yDim, zDim, xCoor, yCoor, zCoor, col)
        arr(anX)(aY).add(newShape)
        WorldCanvas.addShape(newShape)
        true
      }
      else if(kind == Board.DISK) {
        var radius: Double = 1.6 * size
        var zDim: Double = zSize
          
        var xCoor: Double = 1.6 + 3.2 * anX
        var yCoor: Double = 1.6 + 3.2 * aY
        var zCoor: Double = -200 + arr(anX)(aY).getHeight + (zDim / 2)
        
        var newShape: ToyShape = new Disk(radius, zDim, xCoor, yCoor, zCoor, col)
        arr(anX)(aY).add(newShape)
        WorldCanvas.addShape(newShape)
        true
      }
      else if(kind == Board.BALL) {
        var radius: Double = 1.6 * size
        
        var xCoor: Double = 1.6 + 3.2 * anX
        var yCoor: Double = 1.6 + 3.2 * aY
        var zCoor: Double = -200 + arr(anX)(aY).getHeight + radius
        
        var newShape: ToyShape = new Ball(radius, xCoor, yCoor, zCoor, col)
        arr(anX)(aY).add(newShape)
        WorldCanvas.addShape(newShape)
        true
      }
      else false
    }
  }

  /**
    Removes the shape entirely from the world.
    
    @param anX The x-coordinate in board terms of the stack to remove the top shape from
    @param aY The y-coordinate in board terms of the stack to remove the top shape from
    @return true if the delete was successful, false if the stack was empty
   */
  def delete(anX: Int, aY: Int): Boolean = {
    if(arr(anX)(aY).isEmpty) {
      false
    }
    else {
      var shape: ToyShape = arr(anX)(aY).top
      arr(anX)(aY).removeTop
      (shape.asInstanceOf[BranchGroup]).detach        //Forced into casting the shape as a BranchGroup here
      true
    }
  }
}