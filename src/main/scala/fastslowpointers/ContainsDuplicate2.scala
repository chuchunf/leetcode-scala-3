package fastslowpointers

import scala.collection.mutable

object ContainsDuplicate2 {
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean =
    val cache = mutable.HashSet[Int]()
    nums.zipWithIndex.find { case (num, index) => {
      if index > k then cache.remove(nums(index - k - 1))
      if !cache.add(num) then true else false
    }}.isDefined
}
