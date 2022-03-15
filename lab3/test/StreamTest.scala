package u03

import org.junit.*
import org.junit.Assert.*
import Streams.*
import Lists.*
import Lists.List.*

class StreamTest:

  @Test def testDrop() =
    val s = Stream.take(Stream.iterate(0)(_ + 1))(10)
    assertEquals(Cons(6, Cons(7, Cons(8, Cons(9, Nil())))), Stream.toList(Stream.drop(s)(6)))

  @Test def testConstant() =
    assertEquals(Cons(6, Cons(6, Cons(6, Cons(6, Nil())))), Stream.toList(Stream.take(Stream.constant(6))(4)))
    assertEquals(Cons("x", Cons("x", Nil())), Stream.toList(Stream.take(Stream.constant("x"))(2)))

  @Test def testFibonacci() =
    val expected = Cons(0, Cons(1, Cons(1, Cons(2, Cons(3, Cons(5, Cons(8, Cons(13, Nil()))))))))
    assertEquals(expected, Stream.toList(Stream.take(Stream.fibs)(8)))
