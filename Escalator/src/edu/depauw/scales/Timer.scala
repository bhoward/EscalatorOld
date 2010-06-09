
package edu.depauw.scales

/*
 * Timers.
 * @author Christopher Monsanto (chris@monsan.to)
 *
 */

import javax.swing.{Timer => JTimer}
import java.awt.event._

/*
 * A timer.
 */
class Timer(val incr: Int) {
me =>
  var _value = new Value(0)
  def value = _value.get

  val timer = new JTimer(incr, new ActionListener {
    def actionPerformed(e: ActionEvent) {
      _value.set(me, _value.value + 1)
    }
  })

  def start() { timer.start() }
  def stop() { timer.stop() }
  def reset() { 
    _value.set(me, 0)
  }
}

object Timer {
  def apply(incr: => Int) = new Timer(incr)
  def apply() = new Timer(100)
}
