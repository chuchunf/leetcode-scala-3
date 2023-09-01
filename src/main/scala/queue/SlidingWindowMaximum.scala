package queue

import scala.collection.mutable

object SlidingWindowMaximum {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] =
    // fold/slide the windows of k from left of the array
    nums.indices.foldLeft((mutable.ArrayDeque[Int](), mutable.ArrayBuffer[Int]())) {
      // q: a double queue to hold the current, solution: array to store final result, i, the current index
      case ((q, solution), i) =>
        q.removeLastWhile { last => nums(last) < nums(i) && last >= (i - k + 1) }
        q.append(i)
        q.removeHeadWhile(_ < i - k + 1)
        if i >= (k - 1) then (q, solution :+ nums(q.head)) else (q, solution)
    }._2.toArray
}
