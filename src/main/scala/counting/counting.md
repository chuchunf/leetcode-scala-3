# Counting
Counting is a simple and effective technical when dealing with numeric arrays.

# 169. Majority Element
[Boyer-Moore Majority Vote Algorithm](http://www.cs.utexas.edu/~moore/best-ideas/mjrty/)
```scala
  def majorityElement(nums: Array[Int]): Int =
    nums.foldLeft((nums(0), 0)) {
      case ((_, count), num) if count == 0 => (num, 1)
      case ((major, count), num) if major == num => (major, count + 1)
      case ((major, count), _) => (major, count - 1)
    }._1
```