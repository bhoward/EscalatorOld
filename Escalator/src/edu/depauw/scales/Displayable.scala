
package edu.depauw.scales

/*
 * Displayables support layout.
 * @author Christopher Monsanto (chris@monsan.to)
 */

import javax.swing._
import java.awt._
import java.awt.event._

abstract class Displayable extends GUIEvents { 
  /*
   * We need to "clone"/subclass objects, yet retain their type signature.
   * This is a complicated and verbose way of doing it,
   * but the only one I know of. See Section 20.9 of Odersky. 
   */
  type MyType
  def derive(newMakeComponent: (=> JComponent) => JComponent): MyType 

  protected def makeComponent: JComponent

  /*
   * The rest of this probably shouldn't be overridden.
   */

  def toComponent: JComponent = {
    val component = makeComponent
    instrument(component)
    component
  }

  def ^(bottom: => Displayable): AboveHelper = 
    new AboveHelper(this, bottom)
  def |(right: => Displayable): AdjacentHelper = 
    new AdjacentHelper(this, right)
  def +(above: => Displayable): UponHelper = 
    new UponHelper(this, above)

  def at(x: => Int, y: => Int): MyType = derive(oldMakeComponent =>
    new TransparentPanel with Reactable {
      setLayout(null)
      
      val theComponent = oldMakeComponent
      add(theComponent)

      listen({
        val size = theComponent.getPreferredSize()
        theComponent.setBounds(x, y, size.width, size.height)
        val width = x + size.width
        val height = y + size.height
        setPreferredSize(new Dimension(width, height))
        setSize(width, height)
      })
    }
  )
}

class AboveHelper(top: => Displayable, bottom: => Displayable) 
extends Displayable {
  type MyType = AboveHelper
  
  def derive(newMakeComponent: (=> JComponent) => JComponent) = 
    new AboveHelper(top, bottom) {
      override def makeComponent = newMakeComponent(super.makeComponent)
    }

  def makeComponent:JComponent = new TransparentPanel with Reactable {
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS))
    
    listen({
      try {
        remove(0)
      } catch {
        case _ => ()
      }
      add(top.toComponent, 0)
    })

    listen({
      try {
        remove(1)
      } catch {
        case _ => ()
      }
      add(bottom.toComponent, 1)
    })
  }
}

class AdjacentHelper(left: => Displayable, right: => Displayable) 
extends Displayable {
  type MyType = AdjacentHelper
  
  def derive(newMakeComponent: (=> JComponent) => JComponent) = 
    new AdjacentHelper(left, right) {
      override def makeComponent = newMakeComponent(super.makeComponent)
    }

  def makeComponent:JComponent = new TransparentPanel with Reactable {
    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS))
    
    listen({
      try {
        remove(0)
      } catch {
        case _ => ()
      }
      add(left.toComponent, 0)
    })

    listen({
      try {
        remove(1)
      } catch {
        case _ => ()
      }
      add(right.toComponent, 1)
    })
  }
}

class UponHelper(below: => Displayable, above: => Displayable) 
extends Displayable {
  type MyType = UponHelper
  
  def derive(newMakeComponent: (=> JComponent) => JComponent) = 
    new UponHelper(below, above) {
      override def makeComponent = newMakeComponent(super.makeComponent)
    }

  def makeComponent:JComponent = new TransparentPanel with Reactable {
    setLayout(null)

    var a, b: JComponent = null
    var awidth, aheight, bwidth, bheight: Int = 0

    def addDisplayable(idx: Int, d: => Displayable) = {
      try {
        remove(idx)
      } catch {
        case _ => ()
      }
      val component = d.toComponent
      add(component, idx)
      val size = component.getPreferredSize()
      component.setBounds(0, 0, size.width, size.height)
      (component, size.width, size.height)
    }

    def setTheSize {
      val width = scala.math.max(awidth, bwidth)
      val height = scala.math.max(aheight, bheight)
      setPreferredSize(new Dimension(width, height))
      setSize(width, height)
    }

    listen({
      val t = addDisplayable(0, above)
      a = t._1; awidth = t._2; aheight = t._3
      if (b != null) {
        setTheSize
      }
    })

    listen({
      val t = addDisplayable(1, below)
      b = t._1; bwidth = t._2; bheight = t._3
      setTheSize
    })
  }
}

class TransparentPanel extends JPanel {
  setOpaque(false)
}
