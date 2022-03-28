package u04lab.polyglot.a01b
import scala.jdk.javaapi.OptionConverters
import u04lab.polyglot.OptionToOptional
import u04lab.code.Option
import u04lab.code.Option.*
import u04lab.code.List
import u04lab.code.List.*

import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01b/sol2/ */
class LogicsImpl(private val size: Int, private val mines: Int) extends Logics:
  var minesSet: List[(Int, Int)] = Nil()
  var selected: List[(Int, Int)] = Nil()
  private val random = Random()
  deployMines()
  println(minesSet)

  private def deployMines(): Unit = length(minesSet) match
      case x if x < mines =>
        val newMine = (random.nextInt(size), random.nextInt(size))
        if (contains(minesSet, newMine)) then deployMines() else minesSet = append(minesSet, Cons(newMine, Nil()))
        deployMines()
      case _ =>

  private def neighbours(x: Int, y: Int): Int =
    var n = filter(computeCells(x, y))(x => contains(minesSet, x))
    length(n)

  private def computeCells(x: Int, y: Int): List[(Int, Int)] =
    var neighbours: List[(Int, Int)] = Nil()
    for
      i <- x - 1 to x + 1
      j <- y - 1 to y + 1
    do  
      neighbours = append(neighbours, Cons((i, j), Nil()))
    neighbours

  def hit(x: Int, y: Int): java.util.Optional[Integer] =
    val hit = (x, y)
    if (contains(minesSet, hit))
    then
      OptionToOptional(None())
    else
      selected = append(selected, Cons(hit, Nil()))
      OptionToOptional(Some(neighbours(x, y)))

  def won(): Boolean = (length(selected) + length(minesSet)) == (size * size)
