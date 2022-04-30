# Array
Array is a container which can hold a fix number of items and these items should be of the same type.
* convert from/to other 1d data structures such as linked list, queue or stack
* foundation of 2d and high dimensional data structure such as matrix
* implementation of hashmap, hashset, queue, stack and string
* implementation of heap (priority queue) 

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