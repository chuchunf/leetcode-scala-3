package twopointers

object RemoveDuplicatesfromSortedArrayII {
  def removeDuplicates(nums: Array[Int]): Int =
    var (count, actualp, searchp) = (1, 1, 1)
    while searchp < nums.length do {
      if nums(searchp) != nums(searchp - 1) then
        count = 1
        actualp = actualp + 1
        nums(actualp) = nums(searchp)
      else if count < 2 then {
        count = count + 1
        actualp = actualp + 1
        nums(actualp) = nums(searchp)
      }
      searchp = searchp + 1
    }
    actualp
}