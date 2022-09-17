package sort

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object MergeIntervals {
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] =
    val sorted = intervals.sortBy(_ (0))
    sorted.tail.foldLeft(new ArrayBuffer[Array[Int]]().addOne(sorted.head)) {
      case (result, curr) if result.last(1) >= curr(0) => result.last(1) = result.last(1).max(curr(1))
        result
      case (result, curr) => result.addOne(curr)
    }.toArray
}
