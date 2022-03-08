package it.unibo.pps
package exercises

object Es8 extends App{
  enum Option[A]:
    case Some(a: A)
    case None() // here parens are needed because of genericity

  object Option:
    def filter[A](opt: Option[A])(p: A => Boolean): Option[A] = opt match
      case Some(a) => if(p(a)) Some(a) else None()
      case None() => None()

    def map[A, B](opt: Option[A])(p: A => Boolean) : Option[Boolean] = opt match
      case Some(a) => if(p(a)) Some(true) else Some(false)
      case None() => None()

    def map2[A, B](opt1: Option[A], opt2: Option[B]): Option[(A, B)] = (opt1, opt2) match {
      case (Some(a), Some(b)) => Some((a,b))
      case _ => None()
    }

  import Option.*

  println(filter(Some(5))(_ > 2)) // Some(5)
  println(filter(Some(5))(_ > 8)) // None
  println(filter(None[Int]())(_ > 2)) // None

  println(map(Some(5))(_ > 2))// Some(true)
  println(map(Some(5))(_ > 8)) // Some(false)
  println(map(None[Int]())(_ > 2)) // None

  println(map2(Some(5), Some("ciao")))// Some(5,ciao)
  println(map2(Some(5), Some(7))) // Some(5,7)
  println(map2(Some(5), None())) // None
}
