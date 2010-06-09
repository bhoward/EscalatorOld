package oldduck;

import java.io.File
import java.util.Scanner
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

object build
{
  type Pos = (Int, Int)
        
  abstract class Color
  case class RGB(r: Int, g: Int, b: Int) extends Color
  case class Transparency(a: Int) extends Color
        
  type Pixel = (RGB, Transparency)
        
  abstract class Dir 
  case object N extends Dir
  case object S extends Dir
  case object W extends Dir
  case object E extends Dir
        
  val WIDTH: Int = 600
  val HEIGHT: Int = 600
        
  class Bitmap {
    val data: Array[Array[Pixel]] = new Array[Array[Pixel]](WIDTH)
    for (x <- 0 until WIDTH) {
      data(x) = new Array[Pixel](HEIGHT)
      for (y <- 0 until HEIGHT) {
        data(x)(y) = (black, transparent)
      }
    }
    
    def apply(p: Pos): Pixel = data(p._1)(p._2)
    def update(p: Pos, pix: Pixel): Unit = data(p._1)(p._2) = pix
  }
        
  type Bucket = List[Color]

  val black: RGB = RGB(0,0,0)
  val red: RGB = RGB(255,0,0)
  val green: RGB = RGB(0,255,0)
  val yellow: RGB = RGB(255,255,0)
  val blue: RGB = RGB(0,0,255)
  val magneta: RGB = RGB(255,0,255)
  val cyan: RGB = RGB(0,255,255)
  val white: RGB = RGB(255,255,255)
      
  val transparent: Transparency = Transparency(0)
  val opaque: Transparency = Transparency(255)
        
  def transparentBitmap: Bitmap = new Bitmap
  
  // Globals
  var bucket: Bucket = List()
  var position: Pos = (0,0)
  var mark: Pos = (0,0)
  var dir: Dir = E
  var bitmaps: List[Bitmap] = List(transparentBitmap)
          
  def main(args : Array[String]) : Unit = {
    var in: Scanner = null
    
    if (args.length > 0) {
      in = new Scanner(new File(args(0)))
    } else {
      in = new Scanner(System.in)
    }
    
    build(in)
  }
  
  def build(in: Scanner): Unit = {
    while(in.hasNext()) {
      in.next() match {
        case "PIPIIIC" => addColor(black)
        case "PIPIIIP" => addColor(red)
        case "PIPIICC" => addColor(green)
        case "PIPIICF" => addColor(yellow)
        case "PIPIICP" => addColor(blue)
        case "PIPIIFC" => addColor(magneta)
        case "PIPIIFF" => addColor(cyan)
        case "PIPIIPC" => addColor(white)
        case "PIPIIPF" => addColor(transparent)
        case "PIPIIPP" => addColor(opaque)
        case "PIIPICP" => bucket = List()
        case "PIIIIIP" => position = move(position, dir)
        case "PCCCCCP" => dir = turnCounterClockwise(dir)
        case "PFFFFFP" => dir = turnClockwise(dir)
        case "PCCIFFP" => mark = position
        case "PFFICCP" => line(position, mark)
        case "PIIPIIP" => tryfill
        case "PCCPFFP" => addBitmap(transparentBitmap)
        case "PFFPCCP" => compose
        case "PFFICCF" => clip
        case _ => // do nothing
      }
    }
    in.close
    
    draw(bitmaps(0))
  }
  
  def draw(bm: Bitmap): Unit = {
    val bi: BufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
    for (x <- 0 until WIDTH) {
      for (y <- 0 until HEIGHT) {
        val (RGB(r, g, b), _) = bm((x, y))
        bi.setRGB(x, y, 255 * 256 * 65536 + r * 65536 + g * 256 + b)
//        println(x + " " + y + " " + r + " " + g + " " + b)
      }
    }
    ImageIO.write(bi, "png", new File("endo.png"))
    println("Created endo.png")
  }

  def addColor(c: Color): Unit = {
    bucket = c :: bucket
  }
        
  def currentPixel: Pixel = {
    var rtot: Int = 0
    var gtot: Int = 0
    var btot: Int = 0
    var atot: Int = 0
    var rgbCount: Int = 0
    var alphaCount: Int = 0
    
    for (c <- bucket) {
      c match {
        case RGB(r, g, b) => {
          rtot = rtot + r
          gtot = gtot + g
          btot = btot + b
          rgbCount = rgbCount + 1
        }
        case Transparency(a) => {
          atot = atot + a
          alphaCount = alphaCount + 1
        }
      }
    }
    
    val r: Int = if (rgbCount == 0) 0 else rtot / rgbCount
    val g: Int = if (rgbCount == 0) 0 else gtot / rgbCount
    val b: Int = if (rgbCount == 0) 0 else btot / rgbCount
    val a: Int = if (alphaCount == 0) 255 else atot / alphaCount

    return (RGB(r, g, b), Transparency(a))
  }

  def move(p: Pos, d: Dir): Pos = {
    val (x, y) = p
    d match {
      case N => return (x                      , (y + HEIGHT - 1) % HEIGHT)
      case E => return ((x + 1) % WIDTH        , y                        )
      case S => return (x                      , (y + 1) % HEIGHT         )
      case W => return ((x + WIDTH - 1) % WIDTH, y                        )
    }
  }
  
  def turnCounterClockwise(d: Dir): Dir = {
    d match {
      case N => W
      case E => N
      case S => E
      case W => S
    }
  }
  
  def turnClockwise(d: Dir): Dir = {
    d match {
      case N => E
      case E => S
      case S => W
      case W => N
    }
  }
  
  def getPixel(p: Pos): Pixel = bitmaps(0)(p)
  
  def setPixel(p: Pos): Unit = bitmaps(0)(p) = currentPixel
  
  def line(p0: Pos, p1: Pos): Unit = {
    val (x0, y0) = p0
    val (x1, y1) = p1
    val deltax: Int = x1 - x0
    val deltay: Int = y1 - y0
    val d: Int = max(abs(deltax), abs(deltay))
    val c: Int = if (deltax * deltay <= 0) 1 else 0
        
    var x: Int = x0 * d + (d - c) / 2
    var y: Int = y0 * d + (d - c) / 2
        
    for (i <- 0 until d) {
      setPixel((x / d, y / d))
      x = x + deltax
      y = y + deltay
    }
        
    setPixel(x1, y1)
  }
  
  def tryfill: Unit = {
    val newpix: Pixel = currentPixel
    val old: Pixel = getPixel(position)
    if (newpix != old) fill(position, old)
  }
  
  /* This version of fill overflows the stack
  def fill(p: Pos, initial: Pixel): Unit = {
    if (getPixel(p) == initial) {
      setPixel(p)
      val (x, y) = p
      if (x > 0)          fill((x - 1, y), initial)
      if (x < WIDTH - 1)  fill((x + 1, y), initial)
      if (y > 0)          fill((x, y - 1), initial)
      if (y < HEIGHT - 1) fill((x, y + 1), initial)
    }
  }
  */
  
  def fill(p: Pos, initial: Pixel): Unit = {
    var edge: List[Pos] = List(p) // list of current "edge" positions
    setPixel(p)
    
    while (!edge.isEmpty) {
      var newEdge: List[Pos] = List()
      for ((x, y) <- edge) {
        if (x > 0 && getPixel((x - 1, y)) == initial) {
          newEdge = (x - 1, y) :: newEdge
          setPixel((x - 1, y))
        }
        if (x < WIDTH - 1 && getPixel((x + 1, y)) == initial) {
          newEdge = (x + 1, y) :: newEdge
          setPixel((x + 1, y))
        }
        if (y > 0 && getPixel((x, y - 1)) == initial) {
          newEdge = (x, y - 1) :: newEdge
          setPixel((x, y - 1))
        }
        if (y < HEIGHT - 1 && getPixel((x, y + 1)) == initial) {
          newEdge = (x, y + 1) :: newEdge
          setPixel((x, y + 1))
        }
      }
      edge = newEdge
    }
  }
  
  def addBitmap(b: Bitmap): Unit = {
    if (bitmaps.length < 10) bitmaps = b :: bitmaps
  }
  
  def compose: Unit = {
    if (bitmaps.length >= 2) {
      val bm0: Bitmap = bitmaps.head
      bitmaps = bitmaps.tail
      val bm1: Bitmap = bitmaps.head
      
      for (x <- 0 until WIDTH) {
        for (y <- 0 until HEIGHT) {
          val (RGB(r0, g0, b0), Transparency(a0)) = bm0((x, y))
          val (RGB(r1, g1, b1), Transparency(a1)) = bm1((x, y))
          bm1((x, y)) =
            (RGB(r0 + r1 * (255 - a0) / 255,
              g0 + g1 * (255 - a0) / 255,
              b0 + b1 * (255 - a0) / 255),
              Transparency(a0 + a1 * (255 - a0) / 255))
        }
      }
    }
  }
  
  def clip: Unit = {
    if (bitmaps.length >= 2) {
      val bm0: Bitmap = bitmaps.head
      bitmaps = bitmaps.tail
      val bm1: Bitmap = bitmaps.head
      
      for (x <- 0 until WIDTH) {
        for (y <- 0 until HEIGHT) {
          val (RGB(r0, g0, b0), Transparency(a0)) = bm0((x, y))
          val (RGB(r1, g1, b1), Transparency(a1)) = bm1((x, y))
          bm1((x, y)) =
            (RGB(r1 * a0 / 255, g1 * a0 / 255, b1 * a0 / 255),
              Transparency(a1 * a0 / 255))
        }
      }
    }
  }
  
  def max(a: Int, b: Int) = if (a > b) a else b
  
  def abs(a: Int) = if (a < 0) -a else a
}        




