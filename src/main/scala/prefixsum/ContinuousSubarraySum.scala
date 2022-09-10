package prefixsum

import scala.collection.mutable

object ContinuousSubarraySum {
  def checkSubarraySum(nums: Array[Int], k: Int): Boolean =
    val cache = mutable.HashSet[Int]()
    var sum = 0
    nums.exists { num =>
      sum = sum + num
      !cache.add(sum % k)
    }
}
