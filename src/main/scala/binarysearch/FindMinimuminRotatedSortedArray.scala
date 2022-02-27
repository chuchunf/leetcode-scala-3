package binarysearch

object FindMinimuminRotatedSortedArray {
  def findMin(nums: Array[Int]): Int =
    var (low, high) = (0, nums.length - 1)
    while low < high do {
      val mid = low + (high - low) / 2
      if nums(mid) > nums(high) then low = mid + 1
      else high = mid
    }
    nums(high)
}
