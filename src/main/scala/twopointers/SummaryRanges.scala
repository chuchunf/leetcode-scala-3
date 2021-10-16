package twopointers

import scala.collection.mutable

object SummaryRanges {
  def summaryRanges(nums: Array[Int]): List[String] =
    val result = mutable.ListBuffer[String]()
    var (left, right) = (0, 0)
    while right < nums.length do
      while right + 1 < nums.length && nums(right) + 1 == nums(right + 1) do right = right + 1
      if left == right then result.addOne(s"${nums(left)}") else result.addOne(s"${nums(left)}->${nums(right)}")
      right = right + 1
      left = right
    result.toList
}
