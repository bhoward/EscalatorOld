package edu.depauw

import org.specs._

class FactorialTest extends Specification {
  "Factorial(0) is 1" in {
    Factorial(0) must_== 1
  }
  "Factorial(7) is 5040" in {
    Factorial(7) must_== 5040
  }

  "Factorial(-1) is defined" in {
    Factorial(-1) must_== Factorial(-1)
  }
}
