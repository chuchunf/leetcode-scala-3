package binarysearch

object SearchInsertPosition {
  def searchInsert(nums: Array[Int], target: Int): Int =
    var (low, high) = (0, nums.length - 1)
    while low <= high do {
      val mid = low + (high - low) / 2
      if nums(mid) == target then return mid
      else if nums(mid) > target then high = mid - 1
      else low = mid + 1
    }
    low
}
