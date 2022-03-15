package u03

object Lists extends App:

  // A generic linkedlist
  enum List[E]:
    case Cons(head: E, tail: List[E])
    case Nil()
  // a companion object (i.e., module) for List
  object List:
    import u02.Modules.Person

    def sum(l: List[Int]): Int = l match
      case Cons(h, t) => h + sum(t)
      case _ => 0

    def map[A, B](l: List[A])(mapper: A => B): List[B] =
      flatMap(l)(a => Cons(mapper(a), Nil()))

    def filter[A](l1: List[A])(pred: A => Boolean): List[A] =
      flatMap(l1)(a => a match
        case a if pred(a) => Cons(a, Nil())
        case _ => Nil()
      )

    def drop[A](l: List[A], n: Int): List[A] = (l, n) match
      case (Cons(h, t), n) if (n > 0) => drop(t, n - 1)
      case _ => l

    def append[A](left: List[A], right: List[A]): List[A] = left match
      case Cons(h, t) => Cons(h, append(t, right))
      case Nil() => right

    def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] = l match
      case Cons(h, t) => append(f(h), flatMap(t)(f))
      case Nil() => Nil()

    def max(l: List[Int]): Option[Int] = l match
      case Cons(h, Cons(h2, t2)) if (h >= h2) => max(Cons(h, t2))
      case Cons(h, Cons(h2, t2)) if (h < h2) => max(Cons(h2, t2))
      case Cons(h, t) => Some(h)
      case _ => None

    def getCourses(l: List[Person]): List[String] =
      flatMap(l)(x => x match
        case Person.Teacher(_, s) => Cons(s, Nil())
        case _ => Nil()
      )

    def foldLeft[A, B](l: List[A])(n: B)(f: (B, A) => B): B = l match
      case Cons(h, t) => foldLeft(t)(f(n, h))(f)
      case _ => n

    def foldRight[A, B](l: List[A])(n: B)(f: (B, A) => B): B = l match
      case Cons(h, t) => f(foldRight(t)(n)(f), h)
      case _ => n

  val l = List.Cons(10, List.Cons(20, List.Cons(30, List.Nil())))
  println(List.sum(l)) // 60

  import List.*

  println(sum(map(filter(l)(_ >= 20))(_ + 1))) // 21+31 = 52
