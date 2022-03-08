package it.unibo.pps
package exercises

object Es3 extends App{
  def negGeneric[X](pred: X => Boolean): X => Boolean =
    (x: X) => !pred(x)

  // Predicates
  val emptyString: String => Boolean = _ == ""
  val emptyInt: Int => Boolean = _ == 0

  // Tests
  val notEmptyString = negGeneric(emptyString)
  println(notEmptyString("ciao")) // true
  println(notEmptyString("")) // false
  println(notEmptyString("ciao") && !notEmptyString("")) // true
  val notEmptyInt = negGeneric(emptyInt)
  println(notEmptyInt(23)) // true
  println(notEmptyInt(0)) // false
  println(notEmptyInt(23) && !notEmptyInt(0)) // true
}
