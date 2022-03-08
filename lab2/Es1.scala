package it.unibo.pps
package exercises

object Es1 extends App{
  val parityFunction: Int => String =
    (x: Int) =>
      if (x%2 == 0) "Even" else "Odd"

  def parityMethod(x: Int): String = x match
    case x if x%2 == 0 => "Even"
    case _ => "Odd"

  println(parityFunction(5))      // Odd
  println(parityMethod(5))        // Odd
  println(parityFunction(10))     // Even
  println(parityMethod(10))       // Even
}
