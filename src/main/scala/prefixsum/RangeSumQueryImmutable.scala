package prefixsum

class RangeSumQueryImmutable(nums: Array[Int]) {
  private val prefixSum = nums.scanLeft(0)(_ + _)

  def sumRange(left: Int, right: Int): Int = prefixSum(right + 1) - (if left == 0 then 0 else prefixSum(left))
}
