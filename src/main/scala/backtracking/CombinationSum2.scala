package backtracking

import scala.collection.mutable

object CombinationSum2 {
  def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] =
    val (nums, result) = (candidates.sorted, mutable.ListBuffer[List[Int]]())
    combine(nums, 0, target, mutable.ListBuffer[Int](), result)
    result.toList

  private def combine(nums: Array[Int], i: Int, required: Int, tmp: mutable.ListBuffer[Int], result: mutable.ListBuffer[List[Int]]): Unit =
    required match
      case r if r < 0 =>
      case 0 => result.append(tmp.toList)
      case r if r > 0 => for (n <- i until nums.length)
        if n == i || nums(n) != nums(n - 1) then
          combine(nums, n + 1, required - nums(n), mutable.ListBuffer[Int]().addAll(tmp).append(nums(n)), result)
}
