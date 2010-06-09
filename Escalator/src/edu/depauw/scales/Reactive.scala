
package edu.depauw.scales

/*
 * Reactive library core
 * @author Christopher Monsanto (chris@monsan.to)
 */

import scala.collection.mutable.{Stack, Set => MutableSet}

/*
 * At the moment, we need a global stack. This, of course, means nothing
 * is going to work with threads. For now, that's okay.
 */
object ReactableStack {
  protected val callbackStack: Stack[AnyRef => Unit] = new Stack

  callbackStack.push(_ => ())

  def push(initial: => Unit, 
           callback: AnyRef => Unit) {
    callbackStack.push(callback)
    initial
    callbackStack.pop()
  }

  def push(body: AnyRef => Unit) {
    lazy val cbRef = cb(_)

    def cb(sender: AnyRef) {
      callbackStack.push(cbRef)
      body(sender)
      callbackStack.pop()
    }

    cbRef(null)
  }

  /*
   * Obtain the current reactable on the stack.
   */
  def top = callbackStack.top
}


/*
 * Reactables are objects that support mutation.
 */
trait Reactable {
  def listen(initial: => Unit, callback: => Unit) {
    ReactableStack.push(initial, _ => callback)
  }

  def listen(body: => Unit) {
    ReactableStack.push(_ => body)
  }

  def listenButMe(initial: => Unit, callback: => Unit) {
    ReactableStack.push(initial, sender => if (sender != this) callback)
  }

  def listenButMe(body: => Unit) {
    ReactableStack.push(sender => if (sender != this) body)
  }
}


/*
 * Reactors send notices that force reactables to mutate.
 */
class Reactor {
  var callbacks: MutableSet[AnyRef => Unit] = MutableSet()


  /*
   * Reactive values "register" themselves on access.
   */
  def register() {
    callbacks += ReactableStack.top
  }

  /*
   * Signals every reactable that it should react.
   */
  def signal(sender: AnyRef) {
    for (callback <- callbacks)
      callback(sender)
  }
}

/*
 * A value that can change.
 */
class Value[T](var value: T) extends Reactor {
  def set(sender: AnyRef, v: T) {
    value = v
    signal(sender)
  }

  def get: T = {
    register()
    value
  }
}

object changed {
  def apply(f: => Any) {
    // When f fires, so does changed(f)...
    f
  }
}
