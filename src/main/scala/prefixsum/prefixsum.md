# Prefix Sum
Prefix sums are the consecutive totals of the first 0, 1, 2, . . . , n elements of an array, 
```scala
Yi = Y(i−1) + Xi 
```
which can easily calculate the prefix sums in O(n) time complexity. 
Notice that the total pk equals pk−1 + ak−1, so each consecutive value can be calculated in a constant time.
Prefix Sum allows for the **O(1) calculation of sums of elements in given range**.

The same idea could apply to **prefix product**.

## Applications
- Used to answer range-sum-query, range-xor-query etc. 
- Used to find subarray with max sum. 
- Used to find subarray with sum closest to given number. 
- Used to find equal length and equal sum subarrays of 2 arrays.

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
    leftprefixsum.zipWithIndex.find { case (num, index) => index + 1 < rightprefixsum.length && num == rightprefixsum(index + 1) } match
        case Some(_, i) => i
        case _ => -1
```

### 536. Continuous Subarray Sum
```scala
  def checkSubarraySum(nums: Array[Int], k: Int): Boolean =
    val cache = mutable.HashSet[Int]()
    var sum = 0
    nums.exists { num =>
      sum = sum + num
      !cache.add(sum % k)
    }
```

### 525. Contiguous Array
```scala
  def findMaxLength(nums: Array[Int]): Int =
    val cache = mutable.HashMap[Int, Int]()
    nums.map(n => if n == 0 then -1 else 1)
      .scanLeft(0) { case (sum, n) => sum + n }
      .zipWithIndex
      .foldLeft(0) { case (max, (sum, i)) =>
        if !cache.contains(sum) then cache.put(sum, i)
        max.max(i - cache(sum))
      }
```