package it.unibo.pps
package exercises

object Es4 extends App {
  val curriedCheckFunction: Int => Int => Int => Boolean =
    x => y => z => (x<=y && y<=z)

  val checkFunction: (Int, Int, Int) => Boolean =
    (x, y, z) => (x <= y && y <= z)

  def checkMethod(x: Int, y: Int, z: Int): Boolean =
    (x <= y && y <= z)

  def curriedCheckMethod(x: Int)(y: Int)(z: Int): Boolean =
    (x <= y && y <= z)

  val testX = 5
  val testY = 10
  val testZ = 23

  println(curriedCheckFunction(testX)(testY)(testZ))
  println(checkFunction(testX, testY, testZ))
  println(checkMethod(testX, testY, testZ))
  println(curriedCheckMethod(testX)(testY)(testZ))
}
