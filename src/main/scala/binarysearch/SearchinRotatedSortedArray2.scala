package binarysearch

object SearchinRotatedSortedArray2 {
  def search(nums: Array[Int], target: Int): Boolean =
    var (low, high) = (0, nums.length)
    while low <= high do {
      val mid = low + (high - low) / 2
      if target == nums(mid) then return true
      else if target < nums(mid) then
        if nums(high) < target then high = mid - 1 else low = mid + 1
      else
        if nums(low) > target then low = mid + 1 else high = mid - 1
    }
    false
}
