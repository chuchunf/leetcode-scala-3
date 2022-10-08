package backtracking

import scala.collection.mutable

object NQueens {
  def solveNQueens(n: Int): List[List[String]] =
    val result = mutable.ListBuffer[List[String]]()
    _solveNQueens(0, n, mutable.ListBuffer[Int](), result)
    result.toList

  private def _solveNQueens(current: Int, n: Int, buffer: mutable.ListBuffer[Int], result: mutable.ListBuffer[List[String]]): Unit = current match
    case num if num == n => result.addOne(buffer.foldLeft(mutable.ListBuffer[String]()) { case (b, i) => b.addOne(".".repeat(n).updated(i, 'Q')) }.toList)
    case _ => for (i <- 0 until n if !buffer.contains(i)) {
      if (!buffer.zipWithIndex.foldLeft(false) { case (r, (v, idx)) => r || (i - (current - idx)) == v || (i + (current - idx)) == v }) {
        buffer.addOne(i)
        _solveNQueens(current + 1, n, buffer, result)
        buffer.remove(buffer.length - 1)
      }
    }
}
