# Counting
Counting is a simple and effective technical when dealing with numeric arrays.

# 169. Majority Element
[Boyer-Moore Majority Vote Algorithm](http://www.cs.utexas.edu/~moore/best-ideas/mjrty/)
* The algorithm depends on there is a majority
* Which can be easier validated with a 2nd pass of counting
```scala
  def majorityElement(nums: Array[Int]): Int =
    nums.foldLeft((nums(0), 0)) {
      case ((_, count), num) if count == 0 => (num, 1)
      case ((major, count), num) if major == num => (major, count + 1)
      case ((major, count), _) => (major, count - 1)
    }._1
```

### 229. Majority Element 2
```scala
  def majorityElement(nums: Array[Int]): List[Int] =
    nums.foldLeft((nums(0), 0, nums(1), 0)) {
      case ((m1, c1, m2, c2), num) if num == m1 => (m1, c1 + 1, m2, c2)
      case ((m1, c1, m2, c2), num) if num == m2 => (m1, c1, m2, c2 + 1)
      case ((m1, c1, m2, c2), num) if c1 == 0 => (num, 1, m2, c2)
      case ((m1, c1, m2, c2), num) if c2 == 0 => (m1, c1, num, 1)
      case ((m1, c1, m2, c2), _) => (m1, c1 - 1, m2, c2 - 1)
    } match
      case (m1, _, m2, _) => List(m1, m2).filter(m => nums.count(_ == m) > nums.length / 3)
```

### 347. Top K Frequent Elements
```scala
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] =
    nums.foldLeft(mutable.HashMap[Int, Int]()) { case (frequencyMap, num) => {
      frequencyMap.update(num, frequencyMap.get(num).getOrElse(0) + 1)
      frequencyMap
    }}.foldLeft(Array.fill(nums.length + 1)(mutable.ListBuffer[Int]())) { case (bucket, (num, counts)) => {
      bucket(counts).addOne(num)
      bucket
    }}.foldRight(mutable.ListBuffer[Int]()) { case (result, nums) => {
      result.addAll(nums)
      result
    }}.takeRight(k)
      .toArray
```

### 358. Rearrange String k Distance Apart
```scala
  def rearrangeString(str: String, k: Int): String =
    str.foldLeft(mutable.HashMap[Char, Int]()) { case (frequencyMap, char) => {
      frequencyMap.update(char, frequencyMap.get(char).getOrElse(0) + 1)
      frequencyMap
    }}.foldLeft(Array.fill(str.length + 1)(mutable.ListBuffer[Char]())) { case (bucket, (char, counts)) => {
      bucket(counts).addOne(char)
      bucket
    }}.zipWithIndex.foldRight((Array.fill[Char](str.length)(' '), 0)) { case ((chars, count), (buffer, index)) => {
      (buffer, chars.foldLeft(0) { case (offset, char) => {
        for (i <- 0 until count) {
          if i * k + index + offset > str.length then return ""
          else buffer(i * k + index + offset) = char
        }
        offset + 1
      }})
    }}._1.mkString
```

### 383. Ransom Note
```scala
  def canConstruct(ransomNote: String, magazine: String): Boolean =
    val (rmap, mmap) = (countChar(ransomNote), countChar(magazine))
    rmap.find { case (char, count) => count > mmap.get(char).getOrElse(0) }.isEmpty

  private def countChar(s: String): Map[Char, Int] =
    s.foldLeft(mutable.HashMap[Char, Int]()) { case (cache, char) => {
      cache.update(char, cache.get(char).getOrElse(0) + 1)
      cache
    }}.toMap
```