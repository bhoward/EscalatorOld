
package edu.depauw.scales

/*
 * Util
 * @author Christopher Monsanto (chris@monsan.to)
 */

import javax.swing._

object runScript {
  def apply(f: => Unit) {
    SwingUtilities.invokeLater(new Runnable {
      def run() {
        f
      }
    })
  }
}

object Predef {
  implicit def anyToTillHelper[T](x: T): TillHelper[T] =
    new TillHelper[T](x)
  implicit def eventToTransitionHelper(e: => Unit): TransitionHelper =
    new TransitionHelper(e)
}


