package bucketsort

object MaximumGap {
  def maximumGap(nums: Array[Int]): Int =
    val (min, max) = nums.foldLeft((Integer.MAX_VALUE, Integer.MIN_VALUE)) { case ((min, max), num) => (min.min(num), max.max(num)) }
    val (minbucket, maxbucket) = (Array.fill[Int](nums.length - 1)(Integer.MAX_VALUE), Array.fill[Int](nums.length - 1)(Integer.MIN_VALUE))
    nums.foreach { num =>
      val index = (num - min) / (max - min)
      minbucket(index) = minbucket(index).min(num)
      maxbucket(index) = maxbucket(index).max(num)
    }
    var (result, pre) = (Integer.MIN_VALUE, min)
    for (i <- minbucket.indices) {
      if minbucket(i) != Integer.MAX_VALUE && maxbucket(i) != Integer.MIN_VALUE then
        result = result.max(minbucket(i) - pre)
        pre = maxbucket(i)
    }
    result.max(max - pre)
}
