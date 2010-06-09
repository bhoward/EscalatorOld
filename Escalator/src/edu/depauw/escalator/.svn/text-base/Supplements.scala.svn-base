
package edu.depauw.escalator

import javax.swing._
import java.awt.{Dimension, Font}
import java.awt.event._

import edu.depauw.scales
import edu.depauw.scales._

// IMPORTANT!
// Scala cannot handle call by name on functions with view bounds. To get around
// this, we need a new identity for conversions without call by name. Each 
// implicit conversion needs to have both a call by name -> Displayable and a 
// non-call-by-name -> CallByNameContainer.
// Sorry. Thankfully the user will never have to interact with this nonsense.
class CallByNameContainer(val toDisplayable: Displayable)

object Implicits {
  implicit def stringToDisplayable(s: => String):Displayable = new Label(s)
  implicit def stringToCBNC(s: String) = new CallByNameContainer(stringToDisplayable(s))

  implicit def nothingToDisplayable(n: => Nothing): Displayable = new Label("Nothing")
  
  implicit def anyToDisplayable(a: => Any):Displayable =
    new Label(a.toString)
  implicit def anyToCBNC(s: Any) = new CallByNameContainer(anyToDisplayable(s))

  // Without this, Scala compiler becomes confused when trying to display a 
  // Displayable. It will try to apply the identity function and 
  // anyToDisplayable, and throw an exception because that is ambiguous.
  implicit def displayableToDisplayable(x: Displayable) = x
  implicit def displayableToCallByNameContainer(x: Displayable) = new CallByNameContainer(x)

  
  implicit def iterableToDisplayable[T <% CallByNameContainer](xs: => scala.Iterable[T]): Displayable = new IterableDisplayable(xs)

  implicit def iterableToCBNC[T](xs: scala.Iterable[T]) = new CallByNameContainer(iterableToDisplayable(xs)) 

  implicit def timerToDisplayable(t: => scales.Timer): Displayable = 
    new TimerDisplayable(t)
}

class IterableDisplayable[T <% CallByNameContainer](xs: => scala.Iterable[T]) 
extends Displayable {
  type MyType = IterableDisplayable[T]

  def derive(newMakeComponent: (=> JComponent) => JComponent) = 
    new IterableDisplayable(xs) {
      override def makeComponent = newMakeComponent(super.makeComponent)
    }

  def makeComponent:JComponent = new TransparentPanel with Reactable with RecursiveSetFont {
    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS))
    
    listen({
      removeAll()
      for (x <- xs) {
        val xPanel = new TransparentPanel with Reactable with RecursiveSetFont {
          setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black))

          listen({
            removeAll()
            add(x.toDisplayable.toComponent)
          })
        } 
 
        add(xPanel)
        add(Box.createRigidArea(new Dimension(5,5)))
      }
    })
  }
} 

class TimerDisplayable(t: => scales.Timer) extends Displayable with Reactable {
  type MyType = TimerDisplayable
  def derive(newMakeComponent: (=> JComponent) => JComponent) = 
    new TimerDisplayable(t) {
      override def makeComponent = newMakeComponent(super.makeComponent)
    }

  def makeComponent:JComponent = new TransparentPanel with Reactable {
    var timer:scales.Timer = null
    listen({
      timer = t
    })
      
    add(new JButton("play") { 
      addActionListener(new ActionListener {
        def actionPerformed(e: ActionEvent) {
          timer.start()
        }
      })
    }, 0)

    add(new JButton("stop") { 
      addActionListener(new ActionListener {
        def actionPerformed(e: ActionEvent) {
          timer.stop()
        }
      })
    }, 1)
    
    add(new JButton("reset") { 
      addActionListener(new ActionListener {
        def actionPerformed(e: ActionEvent) {
          timer.reset()
        }
      })
    }, 2)
  }
}

class ErrorArea(msg:String) extends JTextArea(msg) {
  setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.red))
  setEditable(false)
  setColumns(80)
  setFont(Escalator.font)
  setLineWrap(true)
}

trait RecursiveSetFont extends java.awt.Container {
  override def setFont(font : Font) {
    for (c <- getComponents) {
      c.setFont(font)
    }
  }
}
