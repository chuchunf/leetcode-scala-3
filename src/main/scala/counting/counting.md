# Counting (Sort)
**Counting** is a simple and effective technique when dealing with numeric arrays,
by counting the number of occurrences of each unique element in the array.

The count is stored in an auxiliary array, and the **counting sort** is done by mapping the count to an index of the auxiliary array

- It is not a comparison-based sorting.
- Its running time complexity is O(n) with space complexity O(k).
- It can be considered as a special kind of hashing (hashmap), key-value maps to index directly (without hashing function)

## Applications
- There are **smaller integers with multiple counts**.
- Linear complexity is the need.

## Related Algorithms
- **Bucket Sort** or bin sort, works by distributing the elements of an array into several buckets.
  Each bucket is then sorted individually. Counting sort stores a single number (the count of items) per bucket.

## Related Data structures
- Array => Counting sort
- Hashmap => Counting

### 169. Majority Element
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
      case ((_, c1, m2, c2), num) if c1 == 0 => (num, 1, m2, c2)
      case ((m1, c1, _, c2), num) if c2 == 0 => (m1, c1, num, 1)
      case ((m1, c1, m2, c2), _) => (m1, c1 - 1, m2, c2 - 1)
    } match
      case (m1, _, m2, _) => List(m1, m2).filter(m => nums.count(_ == m) > nums.length / 3)
```

### 358. Rearrange String k Distance Apart
```scala
  def rearrangeString(str: String, k: Int): String =
    str.foldLeft(mutable.HashMap[Char, Int]()) { case (frequencyMap, char) =>
      frequencyMap.update(char, frequencyMap.getOrElse(char, 0) + 1)
      frequencyMap
    }.foldLeft(Array.fill(str.length + 1)(mutable.ListBuffer[Char]())) { case (bucket, (char, counts)) =>
      bucket(counts).addOne(char)
      bucket
    }.zipWithIndex.foldRight((Array.fill[Char](str.length)(' '), 0)) { case ((chars, count), (buffer, index)) =>
      (buffer, chars.foldLeft(0) { case (offset, char) =>
        for (i <- 0 until count) {
          if i * k + index + offset > str.length then return ""
          else buffer(i * k + index + offset) = char
        }
        offset + 1
      })
    }._1.mkString
```

### 383. Ransom Note
```scala
  def canConstruct(ransomNote: String, magazine: String): Boolean =
    val (rmap, mmap) = (mutable.HashMap[Char, Int](), mutable.HashMap[Char, Int]())
    ransomNote.foreach(char => rmap.update(char, rmap.getOrElse(char, 0) + 1))
    magazine.foreach(char => mmap.update(char, mmap.getOrElse(char, 0) + 1))
    !rmap.exists { case (char, count) => count > mmap.getOrElse(char, 0) }
```