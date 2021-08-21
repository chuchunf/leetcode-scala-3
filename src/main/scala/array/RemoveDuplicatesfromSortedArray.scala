package array

object RemoveDuplicatesfromSortedArray {
  def removeDuplicates(nums: Array[Int]): Int =
    nums.foldLeft(1) { case (index, num) =>
      val result = if num > nums(index - 1) then {
        nums(index) = num
        index + 1
      } else index
      result
    }
}
