package binarysearch

object FindPeakElement {
  def findPeakElement(nums: Array[Int]): Int =
    var (low, high) = (0, nums.length - 1)
    while low < high do {
      val mid = low + (high - low) / 2
      val (midb, mida) = (mid - 1, mid + 1)
      if (midb < 0 && nums(mid) > nums(mida)) || (nums(mid) > nums(mida) && nums(mid) > nums(midb)) || (mida >= nums.length && nums(mid) > nums(midb)) then return mid
      else if nums(mid) < nums(midb) then high = mid
      else low = mid
    }
    low
}
