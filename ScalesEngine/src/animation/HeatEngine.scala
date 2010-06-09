package animation

import edu.depauw.csc.scala.graphics._
import java.awt.Color
import java.util.Date
import java.lang.Thread
import java.awt.BorderLayout, BorderLayout._
import java.lang.Math
import javax.swing._



//Heat Engine demo from Vital
object HeatEngine extends JFrame
{
    def main(args: Array[String]) = 
    {
      var canvas: AnimatedCanvas = new AnimatedCanvas()
      setLayout(new BorderLayout())
      add(canvas)
    
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    
      setSize(640, 480)
      setVisible(true)
      
      
      val newAnim: Animation = new Animation(canvas);
      newAnim.animate(30.0, 10.0, engine, 0, .1)
      
    }
    
    def engine(theta: Double): MediaType =
      {
        val offset = 50.0
        val crankLength = 40.0
        val conRodLength = 100.0
        val pistonRodLength = 150.0;
        val width = 5.0;
        val cylinderRadius = 30.0;
        val cylinderThickness = 10.0;
        val pistonWidth = 20.0;
        val pistonGap = 25.0;
        
        
        val x1 = crankLength * Math.cos(theta) + offset;   
        val y1 = crankLength * Math.sin(theta) + offset;
        val x2 = x1 + Math.sqrt((Math.pow(conRodLength,2)) - (Math.pow(y1,2)));
        val x3 = x2 + pistonRodLength;
        val x4 = conRodLength + pistonRodLength - pistonWidth
        
        val crank: Line = new Line(offset,offset,x1,y1,5)
        crank.changeColor(new edu.depauw.csc.scala.graphics.Color(Color.GRAY))
        val conRod: Line = new Line(x1,y1,x2,offset+(cylinderRadius/2),5)
        conRod.changeColor(new edu.depauw.csc.scala.graphics.Color(Color.RED))
        val pistonRod: Line = new Line(x2,offset + (cylinderRadius/2),x3,offset+(cylinderRadius/2),5)
        pistonRod.changeColor(new edu.depauw.csc.scala.graphics.Color(Color.GRAY))
        
        val piston: Rectangle = new Rectangle(x3,offset,pistonWidth,cylinderRadius)
        
        piston.changeExtColor(new edu.depauw.csc.scala.graphics.Color(Color.BLACK))
        piston.changeIntColor(new edu.depauw.csc.scala.graphics.Color(Color.GRAY))
        
        val u1 = crankLength + pistonWidth + pistonGap;
        val innerCylinder: Rectangle = new Rectangle(x4,offset,u1 + pistonWidth*2,cylinderRadius)
        innerCylinder.changeColor(new edu.depauw.csc.scala.graphics.Color(Color.YELLOW))
        
        val outerCylinder: Rectangle = new Rectangle(x4-cylinderThickness,offset-cylinderThickness,u1 + cylinderThickness*2 + pistonWidth*2,cylinderRadius + cylinderThickness*2)
        outerCylinder.changeColor(new edu.depauw.csc.scala.graphics.Color(Color.BLACK))
        
        val x5 = x3 + pistonWidth
        
        val greenComp: int = Math.round(100.0 * (1.0 - ((x1-offset) / crankLength))).toInt;
        val gasColor: Color = new Color(255, greenComp, 50)
        val gas: Rectangle = new Rectangle(x5,offset,((x4 + u1) - x5)+pistonWidth*2, cylinderRadius)
        gas.changeColor(new edu.depauw.csc.scala.graphics.Color(gasColor))
        
        //create Composite shape, cast as mediatype, return it 
        
        /*
        val x1 = crankLength * Math.cos(theta);   
        val y1 = crankLength * Math.sin(theta);
        val x2 = x1 + Math.sqrt(Math.pow(conRodLength,2) - Math.pow(y1,2));
        val x3 = x2 + pistonRodLength;
        val x4 = conRodLength + pistonRodLength;

        val crank: Line = new Line(0.0, 0.0, x1, y1)
        val conRod: Line = new Line(x1, y1, x2, 0.0)
        val pistonRod: Line = new Line(x2, 0.0, x3, 0.0)
        val piston: Rectangle = new Rectangle(x3, 0.0,  pistonWidth, cylinderRadius)
        piston.changeExtColor(new edu.depauw.csc.scala.graphics.Color(Color.BLACK))
        piston.changeIntColor(new edu.depauw.csc.scala.graphics.Color(Color.GRAY))
        val u1 = crankLength + pistonWidth + pistonGap;
        val innerCylinder: Rectangle = new Rectangle(x4, 0.0, u1, cylinderRadius)
        innerCylinder.changeColor(new edu.depauw.csc.scala.graphics.Color(Color.YELLOW))
        val outerCylinder: Rectangle = new Rectangle(x4, 0.0, (u1 + cylinderThickness), (cylinderRadius + cylinderThickness))
        outerCylinder.changeColor(new edu.depauw.csc.scala.graphics.Color(Color.BLACK))
        val x5 = (x3 + x4 + u1) / 2.0;
        val greenComp: int = Math.round(100.0 * (1.0 - ((x1-50.0) / crankLength))).toInt;
        val gasColor: Color = new Color(255, greenComp, 50)
        val gas = new Rectangle(x5, 0.0, ((x4 + u1) - x5), cylinderRadius)
        gas.changeColor(new edu.depauw.csc.scala.graphics.Color(gasColor))
        */
        
        val engine: Composite = new Composite()
        engine.add(crank)
        engine.add(conRod)
        engine.add(pistonRod)
        engine.add(piston)
        engine.add(gas)
        val engine2: Composite = engine.over(innerCylinder)
        val engine3: Composite = engine2.over(outerCylinder)
        
        //return new MediaType(crank)
        return new MediaType(engine.over(innerCylinder).over(outerCylinder))
      }
}


/*
 engine  theta =
  let { crankLength = 40.0;  conRodLength = 100.0;   pistonRodLength = 150.0; width = 5.0;
        cylinderRadius = 30.0; cylinderThickness = 10.0; pistonWidth = 20.0; pistonGap = 15.0;
        x1 = crankLength * cos theta;   y1 = crankLength * sin theta;
        x2 = x1 + sqrt ((conRodLength ^ 2) - (y1 ^ 2));
        x3 = x2 + pistonRodLength;
        x4 = conRodLength + pistonRodLength;
        link = \x1 y1 x2 y2 -> bar x1 y1 x2 y2 width gray black red white;
        crank = link 0.0 0.0 x1 y1;
        conRod = link x1 y1 x2 0.0;
        pistonRod = link x2 0.0 x3 0.0;
        piston = rect x3 0.0  pistonWidth cylinderRadius gray black;
        u1 = crankLength + pistonWidth + pistonGap;
        innerCylinder = rect x4 0.0 u1 cylinderRadius yellow yellow;
        outerCylinder = rect x4 0.0 (u1 + cylinderThickness) (cylinderRadius + cylinderThickness) black black;
        x5 = (x3 + x4 + u1) / 2.0;
        greenComp = round (100.0 * (1.0 - (x1 / crankLength)));
        gasColor = RGB 255 greenComp 50;
        gas = rect x5 0.0 ((x4 + u1) - x5) cylinderRadius gasColor gasColor
  } in super [outerCylinder, innerCylinder, pistonRod, conRod, crank, gas, piston]
 
 
 
 
 */