# Array

### 26. Remove Duplicates from Sorted Array
```scala
  def removeDuplicates(nums: Array[Int]): Int =
    nums.foldLeft(1) { case (num, index) =>
      if num > nums(index - 1) then {
        nums(index) = num
        index + 1
      } else index
    }
```
### 78. Subsets
```scala
  def subsets(nums: Array[Int]): List[List[Int]] =
    val cache = mutable.ListBuffer[List[Int]]()
    cache.addOne(List[Int]())
    nums.foreach(num => {
      val temp = mutable.ListBuffer[List[Int]]()
      cache.foreach(list => temp.addOne(mutable.ListBuffer[Int]().addAll(list).addOne(num).toList))
      cache.addAll(temp)
    })
    cache.toList
```

### 945. Minimum Increment to Make Array Unique
```scala
  def minIncrementForUnique(nums: Array[Int]): Int = nums match
    case Array(_) => 0
    case _ => val sorted = nums.sorted
      var (result, currentexpect) = (0, sorted(0) + 1)
      sorted.drop(1).foreach(num => {
        if (num < currentexpect) then
          result = result + (currentexpect - num)
          currentexpect = currentexpect + 1
        else
          currentexpect = num + 1
        end if
      })
      result
```

### 121. Best Time to Buy and Sell Stock
```scala
  def maxProfit(prices: Array[Int]): Int = prices match
    case Array(_) => 0
    case Array(head, tail) => if head < tail then tail - head else 0
    case _ => var (maxprofit, minprice) = (0, prices(0))
      prices.drop(1).foreach(price => {
        maxprofit = maxprofit.max(price - minprice)
        minprice = minprice.min(price)
      })
      maxprofit
```
### 88. Merge Sorted Array
```scala
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit =
    var (p1, p2) = (0, 0)
    while p1 < m do
      if n > 0 && nums1(p1) > nums2(p2) then {
        var tmp = nums2(p2)
        nums2(p2) = nums1(p1)
        nums1(p1) = tmp
      }
      p1 = p1 + 1
    for (i <- 0 until n) nums1(m + i) = nums2(i)
```

### 125. Valid Palindrome
```scala
  def isPalindrome(s: String): Boolean =
    var (lp, rp) = (0, s.length - 1)
    while lp < rp do
      (s.charAt(lp), s.charAt(rp)) match
    case (lc, _) if !lc.isLetterOrDigit => lp = lp + 1
    case (_, rc) if !rc.isLetterOrDigit => rp = rp - 1
    case (lc, rc) if lc.toLower != rc.toLower => return false
    case (_, _) =>
      lp = lp + 1
    rp = rp - 1
    true
```