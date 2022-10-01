package backtracking

import scala.collection.mutable

object Combinations {
  def combine(n: Int, k: Int): List[List[Int]] =
    val result = mutable.ListBuffer[List[Int]]()
    for (i <- 1 to n) _combine(i, n, k, mutable.ListBuffer[Int](), result)
    result.toList

  private def _combine(i: Int, n: Int, k: Int, buffer: mutable.ListBuffer[Int], result: mutable.ListBuffer[List[Int]]): Unit =
    buffer.addOne(i)
    if buffer.length == k then result.addOne(buffer.clone.toList)
    else if buffer.length < k then for (j <- i + 1 to n) _combine(j, n, k, buffer, result)
    buffer.remove(buffer.length - 1)
}
