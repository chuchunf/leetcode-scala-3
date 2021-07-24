package twopointers

object MinimumSizeSubarraySum {
  def minSubArrayLen(target: Int, nums: Array[Int]): Int = nums match
    case Array(num) => if (num >= target) 1 else 0
    case _ => var (min, sum, left, right) = (Int.MaxValue, nums(0), 0, 1)
      while left < nums.length do
        if sum >= target then {
          min = min.min(right - left)
          sum = sum - nums(left)
          left = left + 1
        } else {
          if right < nums.length then {
            sum = sum + nums(right)
            right = right + 1
          } else {
            sum = sum - nums(left)
            left = left + 1
          }
        }
      if (min == Int.MaxValue) 0 else min
}
