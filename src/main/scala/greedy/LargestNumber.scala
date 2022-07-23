package greedy

// 179. Largest Number
object LargestNumber {
  def largestNumber(nums: Array[Int]): String =
    nums.sortWith { case (n1, n2) => s"$n1$n2" > s"$n2$n1" }
      .foldLeft("") { case (r, n) => s"$r$n" }
}
