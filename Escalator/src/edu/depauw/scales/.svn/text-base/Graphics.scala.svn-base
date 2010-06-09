
package edu.depauw.scales

/*
 * @author Christopher Monsanto (chris@monsan.to)
 */

import javax.swing._
import java.awt._
import java.awt.{Color => JColor}
import java.awt.image._
import java.awt.geom._
import javax.imageio._
import java.io._

/*
 * Graphic
 */

abstract class Graphic extends Displayable with Reactable { me =>
  val _size = new Value((0, 0))
  def size = _size.get

  protected def onRedraw 
  def draw(g : Graphics2D)
  def deriveGraphic(newDefs : => (
    () => Unit,
    Value[(Int, Int)], 
    (Graphics2D, Graphics2D => Unit) => Unit)): MyType

  def makeComponent : JComponent = new JPanel with Reactable {
    setOpaque(false)

    listen({
      val (width, height) = me.size
      setPreferredSize(new Dimension(width, height))
      setSize(width, height)
    })
    listen(onRedraw, repaint())

    override def paintComponent(graphics : Graphics) {
      super.paintComponent(graphics)
      
      val g2d = graphics.asInstanceOf[Graphics2D]
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
        RenderingHints.VALUE_ANTIALIAS_ON)
      draw(g2d)
    }
  }

  /*
   *
   */

  def transform(t : => AffineTransform) = {
    deriveGraphic({
      def onRedraw() { t }

      val size = new Value((0, 0)) {
        override def set(sender: AnyRef, value: (Int, Int)) {
          val (width, height) = value

          val points = Array[Point2D](
            new Point2D.Float(0, 0),
            new Point2D.Float(width, 0),
            new Point2D.Float(0, height),
            new Point2D.Float(width, height))

          val newCoords = {
            val coords = new Array[Point2D](4)
            t.transform(points, 0, coords, 0, 4)
            coords
          }
  
          def max(p1 : Point2D, p2 : Point2D) = {
            val x = if (p1.getX() > p2.getX()) p1.getX() else p2.getX()
            val y = if (p1.getY() > p2.getY()) p1.getY() else p2.getY()
            new Point2D.Double(x, y)
          }

          def min(p1 : Point2D, p2 : Point2D) = {
            val x = if (p1.getX() < p2.getX()) p1.getX() else p2.getX()
            val y = if (p1.getY() < p2.getY()) p1.getY() else p2.getY()
            new Point2D.Double(x, y)
          }

          val maxCoord = newCoords.reduceLeft(
            (a, b) => new Point2D.Double(scala.math.max(a.getX(), a.getY()), 
              scala.math.max(b.getX(), b.getY())))
          val minCoord =  newCoords.reduceLeft(
            (a, b) => new Point2D.Double(scala.math.min(a.getX(), a.getY()), 
              scala.math.min(b.getX(), b.getY())))

          val newWidth = maxCoord.getX().toInt - minCoord.getX().toInt
          val newHeight = maxCoord.getY().toInt - minCoord.getY().toInt

          super.set(sender, (newWidth, newHeight))
        }
      }

      def newDraw(g: Graphics2D, draw: Graphics2D => Unit) {
        val orig = g.getTransform()
        g.transform(t)
        draw(g)
        g.setTransform(orig)
      }

      (onRedraw, size, newDraw(_, _))
    })
  }

  def rotate(theta: => Double, pos: => (Int, Int)):MyType = transform(
    AffineTransform.getRotateInstance(theta, pos._1.toInt, pos._2.toInt))
  def rotateDeg(degrees: => Double, pos: => (Int, Int)):MyType = 
    rotate(scala.math.Pi/180 * degrees, pos)
  def rotate(theta: => Double):MyType =
    rotate(theta, {
      val (width, height) = size
      (width/2, height/2)
    })
  def rotateDeg(degrees: => Double):MyType = 
    rotateDeg(degrees, {
      val (width, height) = size
      (width/2, height/2)
    })
  def shear(shx: => Double, shy: => Double) = transform(
    AffineTransform.getShearInstance(shx, shy))
  def scale(sx: => Double, sy: => Double) = transform(
    AffineTransform.getScaleInstance(sx, sy))
}

/*
 * Shapes
 */

class Shape(rShape: => java.awt.Shape, 
            rOutlinedShape: => java.awt.Shape, 
            rFillPaint: => Paint, 
            rOutlinePaint: => Paint) extends Graphic {
  var shape: java.awt.Shape = null
  var outlinedShape: java.awt.Shape = null
  var fillPaint: Paint = null
  var outlinePaint: Paint = null

  listen({shape = rShape})
  listen({
    outlinedShape = rOutlinedShape
    val bounds = rOutlinedShape.getBounds2D()
    _size.set(this, 
      (bounds.getWidth().toInt + bounds.getX().toInt,
      bounds.getHeight().toInt + bounds.getY().toInt))
  })
  listen({fillPaint = rFillPaint})
  listen({outlinePaint = rOutlinePaint})

  def onRedraw { rShape; rOutlinedShape; rFillPaint; rOutlinePaint }

  def draw(g: Graphics2D) {
    g.setPaint(fillPaint)
    g.fill(shape)
    g.setPaint(outlinePaint)
    g.fill(outlinedShape)
  }

  def fill(fillPaint: => Paint, opacity: => Double):Shape = 
    new Shape(rShape, rOutlinedShape, fillPaint, rOutlinePaint)
  def fill(fillPaint: => Paint):Shape = fill(fillPaint, 1)

  def outline(outlinePaint: => Paint, size: => Int, opacity: => Double):Shape = 
    new Shape(rShape, 
              (new BasicStroke(size.toFloat)).createStrokedShape(rShape),
              rFillPaint, outlinePaint)
  def outline(outlinePaint: => Paint):Shape = outline(outlinePaint, 1, 1)
  def outline(outlinePaint: => Paint, size: => Int):Shape = 
    outline(outlinePaint, size, 1)

  /*
   *
   */

  def this(shape: => java.awt.Shape) = 
    this(shape, (new BasicStroke(1f)).createStrokedShape(shape), 
         Color.white, Color.black)

  type MyType = Shape

  def derive(newMakeComponent: (=> JComponent) => JComponent) = 
    new Shape(rShape, rOutlinedShape, rFillPaint, rOutlinePaint) {
      override def makeComponent = newMakeComponent(super.makeComponent)
    }

  def deriveGraphic(newDefs: => (() => Unit,
                                 Value[(Int, Int)], 
                                 (Graphics2D, Graphics2D => Unit) => Unit)) = {
    val (newRedraw, newSize, newDraw) = newDefs
    new Shape(rShape, rOutlinedShape, rFillPaint, rOutlinePaint) {
      override def onRedraw { super.onRedraw ; newRedraw } 
      override val _size = newSize
      override def draw(g: Graphics2D) {
        newDraw(g, super.draw(_))
      }
    }
  }
}

object Circle {
  def apply(diameter: => Double) = 
    Ellipse(diameter, diameter)
}

object Ellipse {
  def apply(xDiam: => Double, yDiam : => Double) =
    new Shape(new Ellipse2D.Double(0, 0, xDiam, yDiam)) 
}

object Rectangle {
  def apply(width: => Double, height: => Double) =
    new Shape(new Rectangle2D.Double(0, 0, width, height))
}

object RoundRectangle {
  def apply(width: => Double, height: => Double, 
            arcw: => Double, arch: => Double) = {
    new Shape(new RoundRectangle2D.Double(0,0,width,height,arcw,arch))
  }
}

object Square {
  def apply(width: => Double) = Rectangle(width, width)
}

object Line {
  def fromCoords(p1: => (Int,Int), p2: => (Int,Int)) = 
    new Shape(new Line2D.Double(p1._1, p1._2, p2._1, p2._2))
}

object Canvas {
  def apply(width: => Double, height: => Double)(path: Turtle => Turtle) =
    new Shape(path(new Turtle(width, height)).shape)
}

/*
 * Turtle graphics
 * 
 * Turtle starts at center (0,0) of a rectangle width x height, heading to the right
 * (positive x); angles are in degrees, increasing counter-clockwise.
 */
class Turtle(val width : Double, val height : Double) {
  // Warning: this GeneralPath is mutable, so Turtles are also mutable (hence not copyable)
  val shape : GeneralPath = new GeneralPath(new Rectangle2D.Double(0, 0, width, height))
  
  private var heading : Double = 0
  private var pen : Boolean = true
  
  def forward(distance : Double) : Turtle = {
    val current = shape.getCurrentPoint
    val newX = current.getX + distance * scala.math.cos(heading)
    val newY = current.getY - distance * scala.math.sin(heading)
    
    if (pen)
      shape.lineTo(newX.toFloat, newY.toFloat)
    else
      shape.moveTo(newX.toFloat, newY.toFloat)
    
    this
  }
  
  def left(angle : Double) : Turtle = {
    heading += angle * scala.math.Pi / 180
    
    this
  }
  
  def right(angle : Double) : Turtle = left(-angle)
  
  def penUp : Turtle = {
    pen = false
    
    this
  }
  
  def penDown : Turtle = {
    pen = true
    
    this
  }
  
  def moveTo(x : Double, y : Double) : Turtle = {
    val newX = x + width / 2
    val newY = -y + height / 2
    
    if (pen)
      shape.lineTo(newX.toFloat, newY.toFloat)
    else
      shape.moveTo(newX.toFloat, newY.toFloat)
    
    this
  }
  
  def turnTo(angle : Double) : Turtle = {
    heading = angle * scala.math.Pi / 180
    
    this
  }
  
  // TODO push (current point and heading) and pop for L-Systems?
  
  shape.moveTo(width.toFloat / 2, height.toFloat / 2)
}

// import path._ for "point free" turtle paths
object path {
  type Path = Turtle => Turtle
  
  def forward(distance : Double) : Path = { turtle => turtle forward distance }

  def left(angle : Double) : Path = { turtle => turtle left angle }

  def right(angle : Double) : Path = { turtle => turtle right angle }

  def penUp : Path = { turtle => turtle penUp }
  
  def penDown : Path = { turtle => turtle penDown }
  
  def moveTo(x : Double, y : Double) : Path = { turtle => turtle moveTo (x, y) }
  
  def turnTo(angle : Double) : Path = { turtle => turtle turnTo angle }
}

/*
 * Images
 */

class Image(rImage: => BufferedImage) extends Graphic {
  var image: BufferedImage = null

  listen({
    image = rImage
    _size.set(this, (image.getWidth(null), image.getHeight(null)))
  })

  def onRedraw { rImage }

  def draw(g: Graphics2D) {
    g.drawImage(image, 0, 0, null)
  }

  /*
   *
   */

  type MyType = Image

  def derive(newMakeComponent: (=> JComponent) => JComponent) = 
    new Image(rImage) {
      override def makeComponent = newMakeComponent(super.makeComponent)
    }

  def deriveGraphic(newDefs: => (
() => Unit,
Value[(Int, Int)], 
(Graphics2D, Graphics2D => Unit) => Unit)) = {
      val (newRedraw, newSize, newDraw) = newDefs
      new Image(rImage) {
        override def onRedraw { super.onRedraw ; newRedraw } 
        override val _size = newSize
        override def draw(g: Graphics2D) {
          newDraw(g, super.draw(_))
        }
      }
    }
}

object Image {
  def apply(fileName: String) = new Image(ImageIO.read(new File(fileName)))
}

/*
 * Utility
 */

object Color {
  val red = JColor.red
  val green = JColor.green
  val blue = JColor.blue
  val cyan = JColor.cyan
  val darkGray = JColor.darkGray
  val lightGray = JColor.lightGray
  val black = JColor.black
  val white = JColor.white
  val magenta = JColor.magenta
  val orange = JColor.orange
  val pink = JColor.pink
  val yellow = JColor.yellow

  def apply(r: Int, g: Int, b: Int) = new JColor(r, g, b)
  def apply(r: Int, g: Int, b: Int, a: Int) = new JColor(r, g, b, a)
  
  def gradient(t1:(Int,Int), c1:JColor, t2:(Int,Int), c2:JColor) =
    new GradientPaint(t1._1, t1._2, c1, t2._1, t2._2, c2)
}


