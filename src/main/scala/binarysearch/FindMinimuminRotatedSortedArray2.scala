package binarysearch

object FindMinimuminRotatedSortedArray2 {
  def findMin(nums: Array[Int]): Int =
    var (low, high) = (0, nums.length - 1)
    while low < high do {
      val mid = low + (high - low) / 2
      if nums(mid) > nums(high) then low = mid + 1
      else if nums(mid) < nums(low) then {
        high = mid
        low = low + 1
      } else high = high - 1
    }
    nums(low)
}

