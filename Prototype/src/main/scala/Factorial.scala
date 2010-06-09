package edu.depauw

/**
 * A non-OO object to compute factorial.
 */
object Factorial {
  def apply(n: Int): BigInt = if (n == 0) 1 else Factorial(n - 1) * n
}
