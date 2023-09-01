package queue

import scala.collection.mutable

object SlidingWindowMaximum {
  // use a deque to implement sliding window, the queue maintains the order with n complexity
  // the head of the queue is the index of current max in the queue/sliding window
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] =
    // slide the window of k from left to right
    nums.indices.foldLeft((mutable.ArrayDeque[Int](), mutable.ArrayBuffer[Int]())) {
      // q: a double queue to hold indexes in big to small order of window of k
      // solution: array to store final result
      case ((q, solution), i) =>
        // remove any number smaller than current index number, ensure the queue is ordered
        q.removeLastWhile { last => nums(last) < nums(i) && last >= (i - k + 1) }
        // add current index, ensure there is a value when current head slides out
        q.append(i)
        // make sure window's size is k
        q.removeHeadWhile(_ < i - k + 1)
        // only start to add solution after reaching window size k, otherwise just continue
        // as the queue's head always holds the index of current max
        if i >= (k - 1) then (q, solution :+ nums(q.head)) else (q, solution)
    }._2.toArray
}
