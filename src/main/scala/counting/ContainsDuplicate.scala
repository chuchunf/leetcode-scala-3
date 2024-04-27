package counting

object ContainsDuplicate {
  def containsDuplicate(nums: Array[Int]): Boolean =
    val cache = collection.mutable.Set[Int]()
    nums.exists { i => cache.contains(i) || !cache.add(i) }
}
