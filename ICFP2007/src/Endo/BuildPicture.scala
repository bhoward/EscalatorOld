package Endo;

import java.io.File
import java.util.Scanner
//import color perhaps?

class BuildPicture //extends Dir
{
  	//define RGB
  	//define component: make sure it is an Integer
  	//actually, i need to define
  	
        type Pos = (Int, Int)
        type RGB = (Int, Int, Int)
        type Transparancy = Int
  
        
        val black: RGB = new RGB(0,0,0)
        val red: RGB = new RGB(255,0,0)
        val green: RGB = new RGB(0,255,0)
        val yellow: RGB = new RGB(255,255,0)
        val blue: RGB = new RGB(0,0,255)
        val magneta: RGB = new RGB(255,0,255)
        val cyan: RGB = new RGB(0,255,255)
        val white: RGB = new RGB(255,255,255)
        
        val transparent: Transparancy = 0
        val opaque: Transparancy = 255
        
        var bucket: List[Color] = List()
        var posistion: Pos = (0,0)
        var mark: Pos = (0,0)
        var dir: Dir = E
        
        
        
        var bitmaps: List[Bitmap] = transparentBitmap :: List()
        
          
  	var someFile: File = new File("endo.rna")
  	var scanner: Scanner = new Scanner(someFile)
        
  	def build(): Unit =
        {
 
         	while(scanner.hasNext())
                {
                   	var r = scanner.next()
                   	
         	        if(r == "PIPIIC")
         	          addColor(black)
                        else if(r == "PIPIIIC")
                          addColor(black)
                        else if(r == "PIPIIIP")
                          addColor(red)
                        else if(r == "PIPIICC")
                          addColor(green)
                        else if(r == "PIPIICF")
                          addColor(yellow)
                        else if(r == "PIPIICP")
                          addColor(blue)
                        else if(r == "PIPIIFC")
                          addColor(magneta)
                        else if(r == "PIPIIFF")
                          addColor(cyan)
                        else if(r == "PIPIIPC")
                          addColor(white)
                        else if(r == "PIPIIPF")
                          addColor(transparent)
                        else if(r == "PIPIIPF")
                          addColor(opaque)
                          
                        else if(r == "PIIPICP")
                          bucket = List()
                        else if(r == "PIIIIIP")
                          position = move(position, dir)
                        else if(r == "PCCCCCP")
                          dir = turnCounterClockwise(dir)
                        else if(r == "PFFFFFP")
                          dir = turnClockwise(dir)
                          
                        else if(r == "PCCIFFP")
                          mark = position
                        else if(r == "PFFICCP")
                          line(position, mark)
                        else if(r == "PIIPIIP")
                          tryfill()
                          
                        else if(r == "PCCPFFP")
                          addBitmap(transparentBitmap)
                        else if(r == "PFFPCCP")
                          compose()
                        else if(r == "PFFICCF")
                          clip()
                }
                //draw bitmaps[0]
        }
	
        def addColor(c: Color)
        {
          	bitmaps = bitmaps :: c
        }
        
        def currentPixel: Pixel =
        {
          // loop through bucket to get all rds, blues, and green
          	while
                    
                  var red: Int = 0
                  rgb match {
                    case (r, g, b) => red = r
                  }
         	def rc = average(
                     
        }
        
        def average(values: List[Int], default: Int): Int =
        {
          	if (values == List())
                    return default
                else
                    return (values.reduceLeft((x: Int,y: Int) => x+y) / values.length)
        }
        
        def move(tuple: Pos, d: Dir): Pos =
        {
          tuple match {
            case (x, y)
          }
        }
        
        
        
}        




abstract class Dir 
case object N extends Dir
case object S extends Dir
case object W extends Dir
case object E extends Dir
