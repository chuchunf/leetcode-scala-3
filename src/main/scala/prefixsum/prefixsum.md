# Prefix Sum
Prefix sums are the consecutive totals of the first 0, 1, 2, . . . , n elements of an array, 
which can easily calculate the prefix sums in O(n) time complexity. 
Notice that the total pk equals pk−1 + ak−1, so each consecutive value can be calculated in a constant time.
Prefix Sum allows for the **O(1) calculation of sums of elements in given range**.
The same idea could apply to prefix product.

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

### 724. Find Pivot Index
```scala
  def pivotIndex(nums: Array[Int]): Int =
    val leftprefixsum: Array[Int] = nums.scanLeft(0)(_ + _)
    val rightprefixsum: Array[Int] = nums.scanRight(0)(_ + _)
    leftprefixsum.zipWithIndex
      .filter { case (num, index) => index + 1 < rightprefixsum.length && num == rightprefixsum(index + 1) }
      .headOption match
      case Some(_, i) => i
      case _ => -1
```

### 536. Continuous Subarray Sum
```scala
  def checkSubarraySum(nums: Array[Int], k: Int): Boolean =
    val cache = mutable.HashSet[Int]()
    var sum = 0
    nums.find { num =>
      sum = sum + num
      !cache.add(sum % k)
    }.isDefined
```