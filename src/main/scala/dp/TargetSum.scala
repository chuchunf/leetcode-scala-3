package dp

object TargetSum {
  def findTargetSumWays(nums: Array[Int], target: Int): Int =
    val max = nums.sum
    _findTargetSumWays(0, target, max, nums, Array.tabulate[Int](nums.length + 1, max * 2 + target + 1)((_, _) => -1))

  private def _findTargetSumWays(i: Int, amount: Int, max: Int, nums: Array[Int], cache: Array[Array[Int]]): Int =
    if i == nums.length then {
      if amount == 0 then 1 else 0
    } else if cache(i)(max + amount) != -1 then cache(i)(max + amount)
    else {
      cache(i)(max + amount) = _findTargetSumWays(i + 1, amount + nums(i), max, nums, cache)
        + _findTargetSumWays(i + 1, amount - nums(i), max, nums, cache)
      cache(i)(max + amount)
    }
}
