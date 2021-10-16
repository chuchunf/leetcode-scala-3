package array

object MoveZeroes {
  def moveZeroes(nums: Array[Int]): Unit =
    var (index, nonezeroPos) = (0, 0)
    while nonezeroPos < nums.length do
      while nums(nonezeroPos) == 0 do nonezeroPos = nonezeroPos + 1
      if nonezeroPos < nums.length then {
        nums(index) = nums(nonezeroPos)
        nonezeroPos = nonezeroPos + 1
        index = index + 1
      }
    (index until nums.length).foreach(nums(_) = 0)
}
