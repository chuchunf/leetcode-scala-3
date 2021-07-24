package array

object RemoveDuplicatesfromSortedArray {
  def removeDuplicates(nums: Array[Int]): Int =
    var (fast, slow) = (0, 0)
    while fast < nums.length do
      nums(slow) = nums(fast)
      while (fast + 1) < nums.length && nums(fast) == nums(fast + 1) do
        fast = fast + 1
      slow = slow + 1
    slow
}
