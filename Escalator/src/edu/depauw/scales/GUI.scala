
package edu.depauw.scales

/*
 * Reactive GUI library
 * @author Christopher Monsanto (chris@monsan.to)
 *
 * Wherever possible - use Java components and not Scala ones.
 * Better documented, and more "barebones."
 * 
 */

import javax.swing._
import java.awt.Adjustable
import java.awt.Component
import java.awt.event._
import javax.swing.event._


trait GUIEvents {
  val _mousePos = new Value((0,0))
  def mousePos = _mousePos.get

  val _leftClick = new Reactor
  def leftClick { _leftClick.register() }

  protected def instrument(component: Component) {
    component.addMouseMotionListener(new MouseMotionAdapter {
      override def mouseMoved(e: MouseEvent) {
        _mousePos.set(component, (e.getX(), e.getY()))
      }
    })

    component.addMouseListener(new MouseListener {
      override def mouseClicked(e: MouseEvent) {
        _leftClick.signal(component)
      }

      override def mouseEntered(e: MouseEvent) {}
      override def mouseReleased(e: MouseEvent) {}
      override def mousePressed(e: MouseEvent) {}
      override def mouseExited(e: MouseEvent) {}
    }) 
  }
}

/*
 * Labels
 */
class Label(label: => String) extends Displayable {
  type MyType = Label
  def derive(newMakeComponent: (=> JComponent) => JComponent) = 
    new Label(label) {
      override def makeComponent = newMakeComponent(super.makeComponent)
    }
  def makeComponent:JComponent = new JLabel with Reactable {
    listen(setText(label))
  }
}

object Label {
  def apply(label: => String): Label = new Label(label)
}


/*
 * A scrollbar (reactive)
 */
class Scrollbar(v: Int, val min: Int, val max: Int) extends Displayable {
  val _value = new Value(v)
  def value = _value.get

  type MyType = Scrollbar
  def derive(newMakeComponent: (=> JComponent) => JComponent) = 
    new Scrollbar(v, min, max) {
      override def makeComponent = newMakeComponent(super.makeComponent)
    }

  def makeComponent:JComponent = 
    new JScrollBar(Adjustable.HORIZONTAL, _value.value, 5, min, max) 
    with Reactable {
scrollbar =>
      listenButMe(setValue(value))
      
      addAdjustmentListener(new AdjustmentListener {
        def adjustmentValueChanged(e: AdjustmentEvent) {
          _value.set(scrollbar, getValue())
        }
      })
    }
}

object Scrollbar {
  def apply(value: => Int, min: => Int, max: => Int):Scrollbar = 
    new Scrollbar(value, min, max)
  def apply(min: => Int, max: => Int):Scrollbar = Scrollbar(min, min, max)
  def apply(max: =>Int):Scrollbar = Scrollbar(0, 0, max)
}


/*
 * Button
 */

class Button(text: => String) extends Displayable {

  val _click = new Reactor
  def click { _click.register() }

  type MyType = Button
  def derive(newMakeComponent: (=> JComponent) => JComponent) = 
    new Button(text) {
      override def makeComponent = newMakeComponent(super.makeComponent)
    }

  def makeComponent:JComponent = new JButton with Reactable {
button =>
    listen(setText(text))
    addActionListener(new ActionListener {
      def actionPerformed(e: ActionEvent) {
        _click.signal(button)
      }
    })
  }
}

object Button {
  def apply(text: => String): Button = new Button(text)
}


/*
 *
 */

class Field extends Displayable {
  val _value = new Value("")

  type MyType = Field
  def derive(newMakeComponent: (=> JComponent) => JComponent) = new Field {
    override def makeComponent = newMakeComponent(super.makeComponent)
  }
  def value = _value.get

  def makeComponent:JComponent = new JTextField with Reactable {
    // for some reason, setText() calls removeUpdate and insertUpdate.
    // leading to infinite recursion (setText calls insertUpdate, which
    // calls _value.set which calls setText which calls insertUpdate...)
    var settingText = false

    def propagate() {
      if (!settingText)
        _value.set(this, getText())
    }

    listenButMe({
      settingText = true
      setText(value)
      settingText = false
    })

    getDocument().addDocumentListener(new DocumentListener {
      def changedUpdate(e: DocumentEvent) {}
      def removeUpdate(e: DocumentEvent) { propagate() }
      def insertUpdate(e: DocumentEvent) { propagate() }
    })
  }
}

object Field {
  def apply(): Field = new Field
}

