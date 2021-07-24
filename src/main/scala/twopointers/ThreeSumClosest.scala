package twopointers

object ThreeSumClosest {
  def threeSumClosest(nums: Array[Int], target: Int): Int =
    var closest = 0
    val sortednum = nums.sorted
    sortednum.zipWithIndex.foreach { case (num, index) => {
      var (left, right) = (index + 1, nums.size - 1)
      while left < right do
        val sum = sortednum(index) + sortednum(left) + sortednum(right)
        closest = if (closest - sum).abs < (target - sum).abs then closest else sum
        if sum > target then right = right - 1
        else left = left + 1
    }}
    closest
}
