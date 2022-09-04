package hashmap

import scala.collection.mutable

object ContainsDuplicate3 {
  def containsNearbyAlmostDuplicate(nums: Array[Int], k: Int, t: Int): Boolean =
    val cache = mutable.HashMap[Long, Long]()
    nums.zipWithIndex.exists { case (num, index) =>
      if index > k then cache.remove((nums(index - k - 1).toLong - Int.MinValue) / (t.toLong + 1))
      val mapped = num.toLong - Int.MinValue
      val bucket = mapped / (t.toLong + 1)
      if cache.contains(bucket)
        || (cache.contains(bucket - 1) && mapped - cache.get(bucket - 1).get <= t)
        || (cache.contains(bucket + 1) && cache.get(bucket + 1).get - mapped <= t) then true else {
        cache.put(bucket, mapped)
        false
      }
    }
}
