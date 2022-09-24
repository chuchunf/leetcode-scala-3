package backtracking

import scala.collection.mutable

object Permutations2 {
  def permuteUnique(nums: Array[Int]): List[List[Int]] = _permuteUnique(nums, mutable.HashSet[List[Int]]())

  private def _permuteUnique(nums: Array[Int], buffer: mutable.HashSet[List[Int]]): List[List[Int]] = nums match
    case Array() => buffer.toList
    case _ => nums.zipWithIndex.flatMap { case (_, i) =>
      _permuteUnique(nums.take(i) ++ nums.drop(i + 1)
        , if buffer.isEmpty then mutable.HashSet(List(nums(i))) else buffer.map(l => nums(i) :: l))
    }.toList
}
