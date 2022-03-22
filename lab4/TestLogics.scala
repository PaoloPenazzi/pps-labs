import org.junit.*
import org.junit.Assert.*
import u04lab.code.List.*
import u04lab.code.List
import u04lab.polyglot.a01b.*
import u04lab.polyglot.a01b.LogicsImpl

import java.util.Optional
import scala.util.Random

class TestLogics:

  @Test def testMineDeployment() =
    val logicsImpl = LogicsImpl(8, 5)
    assertEquals(5, length(logicsImpl.minesSet))

  @Test def testClickOnAMine() =
    val logicsImpl = LogicsImpl(4, 0)
    logicsImpl.minesSet = Cons((0, 3), Cons((1, 1), Cons((3, 2), Nil())))
    assertEquals(Optional.empty(), logicsImpl.hit(1, 1))

  @Test def testClickOnAnEmptyCell() =
    val logicsImpl = LogicsImpl(4, 0)
    logicsImpl.minesSet = Cons((3, 3), Cons((2, 2), Cons((3, 2), Nil())))
    assertEquals(Optional.of(0), logicsImpl.hit(0, 0))

  @Test def testComputeNeighbours() =
    val logicsImpl = LogicsImpl(4, 0)
    logicsImpl.minesSet = Cons((0, 0), Cons((1, 1), Cons((3, 2), Nil())))
    assertEquals(Optional.of(2), logicsImpl.hit(1, 0))

  @Test def testWin() =
    val logicsImpl = LogicsImpl(2, 0)
    logicsImpl.minesSet = Cons((0, 0), Cons((1, 1), Nil()))
    logicsImpl.hit(1, 0)
    logicsImpl.hit(0, 1)
    assertTrue(logicsImpl.won())

  @Test def testMatchIsNotOverYet() =
    val logicsImpl = LogicsImpl(2, 0)
    logicsImpl.minesSet = Cons((0, 0), Cons((1, 1), Nil()))
    logicsImpl.hit(0, 1)
    assertFalse(logicsImpl.won())
