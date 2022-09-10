package prefixsum

import scala.collection.mutable

object ContiguousArray {
  def findMaxLength(nums: Array[Int]): Int =
    val cache = mutable.HashMap[Int, Int]()
    nums.map(n => if n == 0 then -1 else 1)
      .scanLeft(0) { case (sum, n) => sum + n }
      .zipWithIndex
      .foldLeft(0) { case (max, (sum, i)) =>
        if !cache.contains(sum) then cache.put(sum, i)
        max.max(i - cache(sum))
      }
}
