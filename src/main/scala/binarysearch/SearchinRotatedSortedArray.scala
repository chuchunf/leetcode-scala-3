package binarysearch

object SearchinRotatedSortedArray {
  def search(nums: Array[Int], target: Int): Int =
    var (low, mid, high) = (0, nums.length / 2, nums.length - 1)
    while low <= high do {
      mid = (low + high) / 2
      if nums(mid) == target then return mid
      else if nums(mid) > target then {
        if nums(low) > target then low = mid + 1 else high = mid - 1
      } else {
        if nums(high) < target then high = mid - 1 else low = mid + 1
      }
    }
    -1
}
