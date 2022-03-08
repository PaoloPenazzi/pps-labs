package it.unibo.pps

object Es2 extends App{
  def negMethod(pred: String => Boolean): String => Boolean =
    (x: String) => !pred(x)

  val negFunction: (String => Boolean) => (String => Boolean) =
    fun => (x: String) => !fun(x)

  val empty: String => Boolean = _ == "" // predicate on strings

  // Function Tests
  val notEmpty = negFunction(empty)
  println("Negative function:")
  println(notEmpty("foo")) // true
  println(notEmpty("")) // false
  println(notEmpty("foo") && !notEmpty("")) // true

  // Method Tests
  val notEmptyMethod = negFunction(empty)
  println("Negative method:")
  println(notEmptyMethod("foo")) // true
  println(notEmptyMethod("")) // false
  println(notEmptyMethod("foo") && !notEmptyMethod("")) // true
}
