# Binary Search
Binary search / half-interval search / logarithmic search finds the position of a target value within a sorted data structure.
It compares the target value to the middle element of the array. If they are not equal, the half in which the target cannot lie is eliminated and the search continues on the remaining half, and repeats the process.

### 69. Sqrt(x)
```scala
  def mySqrt(x: Int): Int = x match
    case 0 => 0
    case n if n < 4 => 1
    case 4 => 2
    case _ => var (low, mid, high) = (1, 1 + (x / 2 - 1) / 2, x / 2)
      while !(mid * mid == x || (mid * mid < x && (mid + 1) * (mid + 1) > x)) do
        if mid * mid < x then low = mid else high = mid
        mid = low + (high - low) / 2
      mid
```

### 34. Find First and Last Position of Element in Sorted Array
```scala
  def searchRange(nums: Array[Int], target: Int): Array[Int] =
    Array(find(nums, target, (a: Int, b: Int) => a >= b), find(nums, target, (a: Int, b: Int) => a > b))

  private def find(nums: Array[Int], target: Int, compare: (Int, Int) => Boolean): Int =
    var (index, left, mid, right) = (-1, 0, nums.length / 2, nums.length - 1)
    while left <= right do {
      mid = (left + right) / 2
      if compare(nums(mid), target) then right = mid - 1 else left = mid + 1
      if nums(mid) == target then index = mid
    }
    index
```

### 33. Search in Rotated Sorted Array
```scala
  def search(nums: Array[Int], target: Int): Int =
    var (low, mid, high) = (0, nums.length / 2, nums.length - 1)
    while low <= high do {
      mid = (low + high) / 2
      if nums(mid) == target then return mid
      else if nums(mid) > target then {
        if nums(low) > target then low = mid + 1 else high = mid - 1
      } else {
        if nums(high) < target then high = mid - 1 else low = mid + 1
      }
    }
    -1
```

### 81. Search in Rotated Sorted Array II
```scala
  def search(nums: Array[Int], target: Int): Boolean =
    var (low, high) = (0, nums.length)
    while low <= high do {
      val mid = low + (high - low) / 2
      if target == nums(mid) then return true
      else if target < nums(mid) then
        if nums(high) < target then high = mid - 1 else low = mid + 1
      else
        if nums(low) > target then low = mid + 1 else high = mid - 1
    }
    false
```

### 153. Find Minimum in Rotated Sorted Array
```scala
  def findMin(nums: Array[Int]): Int =
    var (low, high) = (0, nums.length - 1)
    while low < high do {
      val mid = low + (high - low) / 2
      if nums(mid) > nums(high) then low = mid + 1
      else high = mid
    }
    nums(high)
```

### 154. Find Minimum in Rotated Sorted Array II
```scala
  def findMin(nums: Array[Int]): Int =
    var (low, high) = (0, nums.length - 1)
    while low < high do {
      val mid = low + (high - low) / 2
      if nums(mid) > nums(high) then low = mid + 1
      else if nums(mid) < nums(low) then {
        high = mid
        low = low + 1
      } else high = high - 1
    }
    nums(low)
```

### 35. Search Insert Position
```scala
  def searchInsert(nums: Array[Int], target: Int): Int =
    var (low, high) = (0, nums.length - 1)
    while low <= high do {
      val mid = low + (high - low) / 2
      if nums(mid) == target then return mid
      else if nums(mid) > target then high = mid - 1
      else low = mid + 1
    }
    low
```

### 278. First Bad Version
```scala
  def firstBadVersion(n: Int): Int =
    var (low, high) = (1, n)
    while low < high do {
      val mid = low + (high - low) / 2
      if !isBadVersion(mid) then low = mid + 1
      else high = mid
    }
    low
```

### 4. Median of Two Sorted Arrays
```scala
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double =
    val (len1, len2) = (nums1.length, nums2.length)
    if len1 < len2 then findMedianSortedArrays(nums2, nums1)
    else {
      var (low1, high1, half) = (0, len1, (len1 + len2 + 1) / 2)
      while low1 <= high1 do {
        val i = (low1 + high1) / 2
        val j = half - i
        if i < len1 && nums2(j - 1) > nums1(i) then low1 = i + 1
        else if i > 0 && nums1(i - 1) > nums2(j) then high1 = i - 1
        else {
          val maxleft = if i == 0 then nums2(j - 1) else if j == 0 then nums1(i - 1) else nums1(i - 1).max(nums2(j - 1))
          if (len1 + len2) % 2 == 1 then return maxleft
          val minright = if i == len1 then nums2(j) else if j == len2 then nums1(i) else nums1(i).min(nums2(j))
          return (maxleft + minright) / 2
        }
      }
      -1
    }
```

### 162. Find Peak Element
```scala
  def findPeakElement(nums: Array[Int]): Int =
    var (low, high) = (0, nums.length - 1)
    while low < high do {
      val mid = low + (high - low) / 2
      val (midb, mida) = (mid - 1, mid + 1)
      if (midb < 0 && nums(mid) > nums(mida)) || (nums(mid) > nums(mida) && nums(mid) > nums(midb)) || (mida >= nums.length && nums(mid) > nums(midb)) then return mid
      else if nums(mid) < nums(midb) then high = mid
      else low = mid
    }
    low
```