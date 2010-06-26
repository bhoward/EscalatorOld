package edu.depauw

/**
 * Another really bad idea...
 */
object Fibo {
  def apply(n: Int): Int = if (n <= 1) n else Fibo(n-1) + Fibo(n-2)
}
