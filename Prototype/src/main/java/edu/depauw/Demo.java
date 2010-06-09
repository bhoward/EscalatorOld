package edu.depauw;

/**
 * A simple example.
 *
 * @author Brian Howard
 * @version 2010-June-09
 */
public class Demo {
  public static void main(String[] args) {
    // Give a greeting
    System.out.println("Hello!");

    // Calculate a factorial (using Scala for no very good reason)
    System.out.println(Factorial.apply(100));
  }
}
