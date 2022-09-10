package array

object RemoveDuplicatesfromSortedArray {
  def removeDuplicates(nums: Array[Int]): Int =
    nums.foldLeft(1) { case (index, num) =>
      if num <= nums(index - 1) then index else {
        nums(index) = num
        index + 1
      }
    }
}
