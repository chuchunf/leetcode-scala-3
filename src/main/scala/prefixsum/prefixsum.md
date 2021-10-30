# Prefix Sum

### 238. Product of Array Except Self
```scala
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
```

### 303. Range Sum Query - Immutable
```scala
class RangeSumQueryImmutable(nums: Array[Int]) {
  private val prefixSum = nums.scanLeft(0)(_ + _)

  def sumRange(left: Int, right: Int): Int = prefixSum(right + 1) - (if left == 0 then 0 else prefixSum(left))
}
```