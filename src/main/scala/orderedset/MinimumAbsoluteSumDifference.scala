package orderedset

import scala.collection.mutable

object MinimumAbsoluteSumDifference {
  def minAbsoluteSumDiff(nums1: Array[Int], nums2: Array[Int]): Int =
    val cache = mutable.TreeSet[Int]().addAll(nums1)
    nums1.zip(nums2).foldLeft((0L, 0)) { case ((sum, maxdiff), (n1, n2)) =>
      val diff1 = Math.abs(cache.minAfter(n2).getOrElse(Int.MinValue) - n2)
      val diff2 = Math.abs(cache.maxBefore(n2).getOrElse(Int.MaxValue) - n2)
      val diff = Math.abs(n1 - n2)
      (sum + diff, maxdiff.max(diff - diff1.min(diff2)))
    } match
      case (sum, maxdiff) => ((sum - maxdiff.toLong) % (Math.pow(10, 9).toInt + 7)).toInt
}
