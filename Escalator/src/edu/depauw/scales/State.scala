
package edu.depauw.scales

/*
 * State management
 * @author Christopher Monsanto (chris@monsan.to)
 */

class State[T](initial: T,  transitions: Seq[Transition[T]]) extends Reactable {
  val _value = new Value(initial)
  def value = _value.get

  for (transition <- transitions) {
    listen(transition.event, _value.set(this, transition.fn(_value.value)))
  }
}

class Transition[T](e: => Unit, val fn: T => T) {
  def event = e
}

/*
 * For some reason, infix operators HAVE to be methods...
 * Combined with an implicit def in Util.scala, we can
 * provide the infix syntax
 */
class TillHelper[T](initial: T) {
  def till(transitions: Transition[T]*):State[T] = 
    new State[T](initial, transitions)
}

class TransitionHelper(e: => Unit) {
  def -->[T](fn: T => T):Transition[T] = new Transition[T](e, fn)
}






