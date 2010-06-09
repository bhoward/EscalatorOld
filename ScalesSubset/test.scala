package foo;

// This is an example
object test {
        def main(args: Array[String]) {
                println(fact(10))
        }

        def fact: Int => Int = {
                case 0 => 1
                case n => n * fact /* this is a comment */ (n - 1)
        }
}
