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
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/prefixsum/ProductofArrayExceptSelf.scala#L4-L14

### 303. Range Sum Query - Immutable
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/prefixsum/RangeSumQueryImmutable.scala#L3-L7

### 724. Find Pivot Index
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/prefixsum/FindPivotIndex.scala#L4-L9

### 536. Continuous Subarray Sum
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/prefixsum/ContinuousSubarraySum.scala#L6-L12

### 525. Contiguous Array
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/prefixsum/ContiguousArray.scala#L6-L14