# Two Pointers
Two pointers is really an easy and effective technique in a sorted sequence, such as array or linked list.
Common scenarios are **find a pair/min/max/equals/closest in a range defined by the two pointers**

- It could be from same direction or matching towards centre
- The technique deals with a **continuous** range 
- Move two pointers independently of each other but depend on condition of the problem
- Identify the condition of moving the pointer is the key to use this technique
  - Longest unique string => find/not-find repeating character 
  - Container with Most water => move the point which is not definitely smaller than current 
  - Trap water fall => the water will flow from the lower part, and we start again when encounter a higher bar.
- Slow fast pointers/Sliding window is kind of variant of this technique

### 3.Longest Substring Without Repeating Characters
```scala
  def lengthOfLongestSubstring(s: String): Int =
    val cache = mutable.Map[Char, Int]()
    var (max, leftp) = (0, 0)
    s.toCharArray.zipWithIndex.foreach { case (char, rightp) => {
      if cache.contains(char) then leftp = leftp.max(cache.get(char).get + 1)
      cache.update(char, rightp)
      max = max.max(rightp - leftp + 1)
    }}
    max
```

### 11. Container With Most Water
```scala
  def maxArea(height: Array[Int]): Int =
    var (max, right, left) = (0, 0, height.size - 1)
    while right < left do
      max = max.max(height(right) * height(left))
      if height(right) > height(left) then left = left - 1
      else right = right + 1
    max
```

### 16. 3Sum Closest
```scala
  def threeSumClosest(nums: Array[Int], target: Int): Int =
    var closest = 0
    val sortednum = nums.sorted
    sortednum.zipWithIndex.foreach { case (num, index) => {
      var (left, right) = (index + 1, nums.size - 1)
      while left < right do
      val sum = sortednum(index) + sortednum(left) + sortednum(right)
      closest = if (closest - sum).abs < (target - sum).abs then closest else sum
      if sum > target then right = right - 1
      else left = left + 1
    }}
    closest
```

### 209. Minimum Size Sub array Sum
```scala
  def minSubArrayLen(target: Int, nums: Array[Int]): Int = nums match
    case Array(num) => if (num >= target) 1 else 0
    case _ => var (min, sum, left, right) = (Int.MaxValue, nums(0), 0, 1)
      while left < nums.length do
        if sum >= target then {
          min = min.min(right - left)
          sum = sum - nums(left)
          left = left + 1
        } else {
          if right < nums.length then {
            sum = sum + nums(right)
            right = right + 1
          } else {
            sum = sum - nums(left)
            left = left + 1
          }
        }
      if (min == Int.MaxValue) 0 else min
```

### 42. Trapping Rain Water
```scala
  def trap(height: Array[Int]): Int =
    var (water, left, right) = (0, 0, height.length - 1)
    while left < right && height(left) <= height(left + 1) do left = left + 1
    while left < right && height(right - 1) >= height(right) do right = right - 1
    while right > (left + 1) do
      var (lefth, righth) = (height(left), height(right))
      if lefth > righth then {
        while height(right - 1) < righth do
          water = water + righth - height(right - 1)
          right = right - 1
      } else {
        while lefth > height(left + 1) do
          water = water + lefth - height(left + 1)
          left = left + 1
      }
    water
```

### 15. 3Sum
```scala
  def threeSum(nums: Array[Int]): List[List[Int]] =
    val result = mutable.ListBuffer[List[Int]]()
    val sorted = nums.sorted
    for (index<-0 until sorted.length) {
      if index==0 || sorted(index-1)!=sorted(index) then
        var (leftp, rightp) = (index + 1, sorted.length - 1)
        while leftp < rightp do {
          sorted(index) + sorted(leftp) + sorted(rightp) match
            case sum if sum > 0 => rightp = rightp - 1
            case sum if sum < 0 => leftp = leftp + 1
            case _ => result.append(List(sorted(index), sorted(leftp), sorted(rightp)))
              while sorted(leftp + 1) == sorted(leftp) do leftp = leftp + 1
              while sorted(rightp - 1) == sorted(rightp) do rightp = rightp - 1
              leftp = leftp + 1
              rightp = rightp - 1
        }
    }
    result.toList
```

### 28. Implement strStr()
```scala
  def strStr(haystack: String, needle: String): Int =
    haystack.toCharArray.zipWithIndex.find { case (char, index) => {
      needle.toCharArray.zipWithIndex.find { case (char2, index2) => {
        haystack(index + index2) != char2
      }}.isEmpty
    }}.map(_._2).getOrElse(-1)
```

### 75. Sort Colors
```scala
  def sortColors(nums: Array[Int]): Unit = sortColorsInternal(nums, sortColorsInternal(nums, 0, 0), 1)

  private def sortColorsInternal(nums: Array[Int], start: Int, target: Int): Int =
    var lp = start
    while nums(lp) == target do lp = lp + 1
    var rp = lp + 1
    while rp < nums.length do {
      if nums(rp) == target then
        nums(rp) = nums(lp)
        nums(lp) = target
        lp = lp + 1
      end if
      rp = rp + 1
    }
    lp
```

### 80. Remove Duplicates from Sorted Array II
```scala
  def removeDuplicates(nums: Array[Int]): Int =
    var (count, actualp, searchp) = (1, 1, 1)
    while searchp < nums.length do {
      if nums(searchp) != nums(searchp - 1) then
        count = 1
        actualp = actualp + 1
        nums(actualp) = nums(searchp)
      else if count < 2 then {
        count = count + 1
        actualp = actualp + 1
        nums(actualp) = nums(searchp)
      }
      searchp = searchp + 1
    }
    actualp
```

### 167. Two Sum II
```scala
  def twoSum(numbers: Array[Int], target: Int): Array[Int] =
    var (lp, rp) = (0, numbers.length - 1)
    while lp < rp && numbers(lp) + numbers(rp) != target do numbers(lp) + numbers(rp) match
      case sum if sum < target => lp = lp + 1
      case _ => rp = rp - 1
    Array(lp + 1, rp + 1)
```

### 159. Longest Substring with At Most Two Distinct Characters
```scala
  def lengthOfLongestSubstringTwoDistinct(s: String): Int =
    val cache = mutable.HashSet[Char]()
    var (max, left, right) = (0, 0, 0)
    while left < s.length do
      while cache.size < 2 && right < s.length do
        cache.add(s.charAt(right))
        right = right + 1
      max = max.max(right - left + 1)
      cache.remove(s.charAt(left))
      left = left + 1
    max
```