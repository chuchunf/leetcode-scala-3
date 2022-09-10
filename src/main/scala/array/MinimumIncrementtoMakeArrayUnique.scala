package array

object MinimumIncrementtoMakeArrayUnique {
  def minIncrementForUnique(nums: Array[Int]): Int = nums match
    case Array(_) => 0
    case _ => val sorted = nums.sorted
      var (result, currentexpect) = (0, sorted(0) + 1)
      sorted.drop(1).foreach(num => {
        if num < currentexpect then
          result = result + (currentexpect - num)
          currentexpect = currentexpect + 1
        else
          currentexpect = num + 1
        end if
      })
      result
}
