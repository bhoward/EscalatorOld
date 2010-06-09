package animation

//import something with pictures
//import something with MediaType
import java.util.Date
import edu.depauw.csc.scala.graphics._
import java.util.Timer
import java.util.TimerTask
import scala.actors.Actor

class Animation(canvas: AnimatedCanvas) 
{
 
  //fps: Frames Per Second, duration: Seconds, v0 is initial value passed to fn, and inc is how much v0 
  //	at each frame
  //Animate passes Time (ms) as
    
  var renderFrame: Boolean = false
  def animate(fps: Double, duration: Double, fn: Double => MediaType, v0: Double, inc: Double)
  {
    val t0 = new Date().getTime()
    val period: Double = 1000/fps
    var frame = 1
    var vcur = v0
    val timer : Timer = new Timer(true)
    var nextFrame: NextFrame = new NextFrame()
    val zero: Long = 0
    timer.scheduleAtFixedRate(nextFrame, zero , period.toLong)
    //Use Timer class from java to sleep properly
    while(frame < fps*duration)
    {
      
      //time passes at period 
      if(renderFrame)
      {
        canvas.reset
        println("frame: " + frame)
        var tcur = new Date().getTime() - t0
	    frame = frame + 1
	    canvas.add(fn(vcur).media)
	    vcur = vcur + inc
        renderFrame = false
        canvas.repaint()
      }
    }
  }
  class NextFrame extends TimerTask 
  {
    def run 
    {
	  renderFrame = true
    }
  }
}