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