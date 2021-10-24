package prefixsum

object ProductofArrayExceptSelf {
  def productExceptSelf(nums: Array[Int]): Array[Int] =
    val result = Array.fill[Int](nums.length)(1)
    nums.drop(1).zipWithIndex.foldLeft(nums.head) { case (prod, (num, index)) =>
      result(1 + index) = prod
      result(1 + index) * num
    }
    nums.dropRight(1).zipWithIndex.foldRight(nums.last) { case ((num, index), prod) =>
      result(index) = prod * result(index)
      prod * num
    }
    result
}
