package prefixsum

object FindPivotIndex {
  def pivotIndex(nums: Array[Int]): Int =
    val leftprefixsum: Array[Int] = nums.scanLeft(0)(_ + _)
    val rightprefixsum: Array[Int] = nums.scanRight(0)(_ + _)
    leftprefixsum.zipWithIndex
      .filter { case (num, index) => index + 1 < rightprefixsum.length && num == rightprefixsum(index + 1) }
      .headOption match
      case Some(_, i) => i
      case _ => -1
}
