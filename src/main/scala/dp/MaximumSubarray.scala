package dp

import scala.math.Ordering

object MaximumSubarray {
  def maxSubArray(nums: Array[Int]): Int =
    for (i <- 1 until nums.length) nums(i) = nums(i).max(nums(i) + nums(i - 1))
    nums.reduceLeft(Ordering[Int].max)
}
