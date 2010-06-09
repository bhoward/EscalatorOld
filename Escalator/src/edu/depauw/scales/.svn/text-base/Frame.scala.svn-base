
package edu.depauw.scales

/*
 * Frame
 * @author Christopher Monsanto (chris@monsan.to)
 */

import javax.swing._

/*
 * Frame
 */
class Frame(title: => String, content: => Displayable) extends JFrame 
with Reactable with GUIEvents {
  val cp = getContentPane()

  instrument(this)

  listen(setTitle(title))
  listen({
    try {
      cp.remove(0)
    } catch {
      case _ => ()
    }
    cp.add(content.toComponent)
    validate()
  })

  pack()
  setVisible(true)
  repaint() // Weird pack repaint bug...
}

/*
 * Generally the starting point of the application.
 */
object Frame {
  def apply(title: => String, content: => Displayable): Frame = 
    new Frame(title, content)
  def apply(content: => Displayable): Frame = Frame("Your application!", content)
}
