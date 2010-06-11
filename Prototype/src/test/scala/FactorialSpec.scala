package edu.depauw

import org.specs._
import org.scalacheck._

class FactorialTest extends Specification with ScalaCheck {
  "Factorial(0) is 1" in {
    Factorial(0) must_== 1
  }

  "Factorial(7) is 5040" in {
    Factorial(7) must_== 5040
  }

  "Factorial(-1) is defined" in {
    Factorial(-1) must_== Factorial(-1)
  }

  "Factorial(n) = Factorial(n-1) * n" in {
    val smallInteger = Gen.choose(1, 100)

    Prop.forAll(smallInteger) { n: Int =>
      Factorial(n) == Factorial(n-1) * n
    } must pass
  }
}
