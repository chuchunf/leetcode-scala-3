package backtracking

import java.util.concurrent.atomic.AtomicInteger
import scala.collection.mutable

object NQueens2 {
  def totalNQueens(n: Int): Int =
    val (cols, dia1, dia2) = (mutable.HashSet[Int](), mutable.HashSet[Int](), mutable.HashSet[Int]())
    val result = AtomicInteger(0)
    _totalNQueens(0, n, cols, dia1, dia2, result)
    result.intValue()

  private def _totalNQueens(row: Int, n: Int, cols: mutable.HashSet[Int], dia1: mutable.HashSet[Int], dia2: mutable.HashSet[Int], result: AtomicInteger): Unit = row match
    case num if num == n => result.incrementAndGet()
    case _ => for (i <- 0 until n if !cols.contains(i) && !dia1.contains(i - row) && !dia2.contains(i + row)) {
      cols.addOne(i)
      dia1.addOne(i - row)
      dia2.addOne(i + row)
      _totalNQueens(row + 1, n, cols, dia1, dia2, result)
      cols.remove(i)
      dia1.remove(i - row)
      dia2.remove(i + row)
    }
}
