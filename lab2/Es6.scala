package it.unibo.pps

object Es6 extends App{
  // @annotation.tailrec
  def fib(n: Int): Int = n match
    case 0 => 0
    case 1 => 1
    case n => fib(n-1) + fib(n-2)

  println(fib(10))    // 55
}
