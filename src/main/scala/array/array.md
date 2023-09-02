# Array
**Array** is a container that can hold a fixed number of items sequentially and these items should be of the same type.
The elements of the array could be accessed by index.
The simplest type of data structure is a linear array, also called a one-dimensional array.
A **matrix** can be represented as a two-dimensional

## Related Data Structures
* Convert from/to other 1d data structures such as **linked list, queue, or stack**
* implementation of 2d and high dimensional data structure such as **matrix**
* implementation of **hashmap, hashset, queue, stack, and string**
* implementation of **heap (priority queue)**
* implementation of dynamic memory allocation, memory pool, and control table (jumper)

## Related Algorithms
* Binary search
* Two pointers / Sliding windows
* Prefix sum

## Common approaches
* sort could simplify the 1d data structure
* if 1 pass could not solve a problem, try multiple passes and collect more information during each pass

### 26. Remove Duplicates from Sorted Array
https://github.com/chuchunf/leetcode-scala-3/blob/92b3d76a55d80580bf31904e16207bce7fdc6c89/src/main/scala/array/RemoveDuplicatesfromSortedArray.scala#L4-L10

### 88. Merge Sorted Array
```scala
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit =
    var (p1, p2) = (0, 0)
    while p1 < m do
      if n > 0 && nums1(p1) > nums2(p2) then {
        val tmp = nums2(p2)
        nums2(p2) = nums1(p1)
        nums1(p1) = tmp
      }
      p1 = p1 + 1
    for (i <- 0 until n) nums1(m + i) = nums2(i)
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
        if num < currentexpect then
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
        val tmp = nums2(p2)
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

### 151. Reverse Words in a String
```scala
  def reverseWords(s: String): String =
    var array = mutable.ArrayBuffer[Char]().addAll(s)
    swapArray(array, 0, array.size - 1)
    array = removeExtraSapce(array)
    swapWords(array)
    array.mkString

  private def swapWords(array: mutable.ArrayBuffer[Char]): Unit =
    var (s, e) = (0, 0)
    while e < array.size do
      while e < array.size && array(e).isLetterOrDigit do e = e + 1
      swapArray(array, s, e - 1)
      e = e + 1
      s = e

  private def removeExtraSapce(array: mutable.ArrayBuffer[Char]): mutable.ArrayBuffer[Char] =
    var (a, c) = (0, 0)
    while c < array.size do
      while c < array.size && array(c).isSpaceChar do c = c + 1
      while c < array.size && array(c).isLetterOrDigit do
        array(a) = array(c)
        a = a + 1
        c = c + 1
      while c < array.size && array(c).isSpaceChar do c = c + 1
      if c < array.size then {
        array(a) = ' '
        a = a + 1
      }
    array.slice(0, a)

  private def swapArray(array: mutable.ArrayBuffer[Char], from: Int, to: Int): Unit =
    var (l, r) = (from, to)
    while l < r do
      val tmp = array(r)
      array(r) = array(l)
      array(l) = tmp
      l = l + 1
      r = r - 1
```

### 189. Rotate Array
Rotation could be archived via reverse
```scala
  def rotate(nums: Array[Int], k: Int): Unit =
    reverse(nums, 0, nums.length - 1)
    reverse(nums, 0, k)
    reverse(nums, k + 1, nums.length - 1)

  private def reverse(nums: Array[Int], sp: Int, ep: Int): Unit =
    var (s, e) = (sp, ep)
    while s < e do
      val tmp = nums(e)
      nums(e) = nums(s)
      nums(s) = tmp
      s = s + 1
      e = e - 1
```

### 680. Valid Palindrome II
```scala
  def validPalindrome(s: String): Boolean = isValidPalindrome(s, 0, s.length - 1) match
    case (false, sp, ep) => isValidPalindrome(s, sp + 1, ep)._1 || isValidPalindrome(s, sp, ep - 1)._1
    case _ => true

  private def isValidPalindrome(str: String, s: Int, e: Int): (Boolean, Int, Int) =
    var (sp, ep) = (s, e)
    while sp < ep do
      (str.charAt(sp), str.charAt(ep)) match
        case (sc, ec) if sc != ec => return (false, sp, ep)
        case (_, _) => sp = sp + 1
          ep = ep - 1
    (true, s, e)
```

### 283. Move Zeroes
```scala
  def moveZeroes(nums: Array[Int]): Unit =
    var (index, nonezeroPos) = (0, 0)
    while nonezeroPos < nums.length do
      while nums(nonezeroPos) == 0 do nonezeroPos = nonezeroPos + 1
      if nonezeroPos < nums.length then {
        nums(index) = nums(nonezeroPos)
        nonezeroPos = nonezeroPos + 1
        index = index + 1
      }
    (index until nums.length).foreach(nums(_) = 0)
```