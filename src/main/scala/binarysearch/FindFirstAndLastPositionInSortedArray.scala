package binarysearch

object FindFirstAndLastPositionInSortedArray {
  def searchRange(nums: Array[Int], target: Int): Array[Int] =
    Array(find(nums, target, (a: Int, b: Int) => a >= b), find(nums, target, (a: Int, b: Int) => a > b))

  private def find(nums: Array[Int], target: Int, compare: (Int, Int) => Boolean): Int =
    var (index, left, mid, right) = (-1, 0, nums.length / 2, nums.length - 1)
    while left <= right do {
      mid = (left + right) / 2
      if compare(nums(mid), target) then right = mid - 1 else left = mid + 1
      if nums(mid) == target then index = mid
    }
    index
}
