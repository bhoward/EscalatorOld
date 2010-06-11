package edu.depauw

//<Factorial>
/**
 * A non-OO object to compute factorial.  It's not good FP either...
 */
object Factorial {
  def apply(n: Int): BigInt = if (n <= 1) 1 else Factorial(n - 1) * n
}
//</Factorial>
