package sort

object MaximumGap {
  def maximumGap(nums: Array[Int]): Int =
    val (min, max) = nums.foldLeft((Integer.MAX_VALUE, Integer.MIN_VALUE)) { case ((min, max), num) => (min.min(num), max.max(num)) }
    val gap = max - min
    val (mins, maxs) = (Array.fill[Int](nums.length - 1)(Integer.MAX_VALUE), Array.fill[Int](nums.length - 1)(Integer.MIN_VALUE))
    nums.foreach {
      case num if num == min || num == max =>
      case num => val index = (num - min) / gap
        mins(index) = mins(index).min(num)
        maxs(index) = maxs(index).max(num)
    }
    var (result, pre) = (Integer.MIN_VALUE, min)
    for (i <- 0 until mins.length) {
      if mins(i) != Integer.MAX_VALUE && maxs(i) != Integer.MIN_VALUE then {
        result = result.max(mins(i) - pre)
        pre = maxs(i)
      }
    }
    result.max(max - pre)
}
