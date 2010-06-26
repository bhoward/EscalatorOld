package edu.depauw.util

class Hello(thing: String) {
  def greet = "Hello, " + thing
}

object Main {
  def main(args: Array[String]) {
    val hw = new Hello("World")
    println(hw.greet)
  }
}
