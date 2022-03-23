import org.junit.Test
import org.junit.Assert.*
import u04lab.code.List.*
import u04lab.code.{Course, List, Student}
import u04lab.code.Student.*

class TestLastExercise:

  @Test def testFactory() =
    assertEquals(Cons(3, Cons(10, Cons(65, Nil()))), List(3, 10, 65))