# Bucket Sort

Bucket sort (bin sort) **distributes the elements into buckets**, 
then **buckets is sorted individually**, either as a sorted array or using same/different sorting algorithms. 

Bucket sort is useful when elements are **uniformly distributed over a range** => **Duplicates/Frequency** could be distributed into **Buckets** 

## Steps
The process of bucket sort can be understood as a **scatter-gather** approach
1. Set up an array of initially empty "buckets".
2. Go over the original array, putting each object in its bucket => scatter
3. Sort each non-empty bucket individually
4. Visit the buckets in order and put all elements back into the original array => gather

## Related Algorithms & Data structures 
* **Array**: the buckets could be initiated as a sorted array 
* **Counting sort** counts the number of objects with distinct key values (kind of hashing), 
then do some arithmetic to calculate the position of each object (array of counts/frequency).  
Counting sort handles same elements appears multiples times, 
while Bucket sort handles multiple elements have same hash value (e.g. floating number which could not be the index of array).   
Bucket sort can be seen as a generalization of counting sort; if each bucket has size 1 then bucket sort degenerates to counting sort
* **Quick sort**, Bucket sort with two buckets is a quicksort where the pivot value is the middle value of the value range
* **Hashmap**, Bucket Sort is kind of using the same underneath data structure as Hashmap, but for sorting.

### 347. Top K Frequent Elements
```scala
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] =
    nums.foldLeft(mutable.HashMap[Int, Int]()) { case (frequencyMap, num) =>
      frequencyMap.update(num, frequencyMap.getOrElse(num, 0) + 1)
      frequencyMap
    }.foldLeft(Array.fill(nums.length + 1)(mutable.ListBuffer[Int]())) { case (bucket, (num, counts)) =>
      bucket(counts).addOne(num)
      bucket
    }.foldRight(mutable.ListBuffer[Int]()) { case (result, nums) =>
      result.addAll(nums)
      result
    }.takeRight(k)
      .toArray
```

### 692. Top K Frequent Words
```scala
  def topKFrequent(words: Array[String], k: Int): List[String] =
    words.foldLeft(mutable.HashMap[String, Int]()) { case (frequencyMap, word) =>
      frequencyMap.update(word, frequencyMap.getOrElse(word, 0) + 1)
      frequencyMap
    }.foldLeft(Array.fill(words.length + 1)(mutable.ListBuffer[String]())) { case (bucket, (word, counts)) =>
      bucket(counts).addOne(word)
      bucket
    }.foldRight(mutable.ListBuffer[String]()) { case (unsorted, result) =>
      result.addAll(unsorted.sorted)
      result
    }.take(k)
      .toList
```

### 451. Sort Characters By Frequency
```scala
  def frequencySort(s: String): String =
    val (map, bucket) = (mutable.Map[Char, Int](), Array.fill(s.length + 1)(mutable.ListBuffer[Char]()))
    s.foreach { c => map.update(c, map.getOrElse(c, 0) + 1) }
    map.foreach((char, count) => bucket(count).addOne(char))
    bucket.zipWithIndex
      .foldRight("") { case ((list, count), str) =>
        str + list.foldLeft("") { case (result, char) => result + char.toString.repeat(count) }
      }
```

### 220. Contains Duplicate III
```scala
  def containsNearbyAlmostDuplicate(nums: Array[Int], k: Int, t: Int): Boolean =
    val cache = mutable.HashMap[Long, Long]()
    nums.zipWithIndex.find { case (num, index) => {
      if index > k then cache.remove((nums(index - k - 1).toLong - Int.MinValue) / (t.toLong + 1))
      val mapped = num.toLong - Int.MinValue
      val bucket = mapped / (t.toLong + 1)
      if cache.contains(bucket)
        || (cache.contains(bucket - 1) && mapped - cache.get(bucket - 1).get <= t)
        || (cache.contains(bucket + 1) && cache.get(bucket + 1).get - mapped <= t) then true else {
        cache.put(bucket, mapped)
        false
      }
    }}.isDefined
```

### 164. Maximum Gap
```scala
  def maximumGap(nums: Array[Int]): Int =
    val (min, max) = nums.foldLeft((Integer.MAX_VALUE, Integer.MIN_VALUE)) { case ((min, max), num) => (min.min(num), max.max(num)) }
    val gap = max - min
    val (mins, maxs) = (Array.fill[Int](nums.length - 1)(Integer.MAX_VALUE), Array.fill[Int](nums.length - 1)(Integer.MIN_VALUE))
    nums.foreach {
      case num if num == min || num == max =>
      case num => val index = (num - min) / gap
        mins(index) = mins(index).min(num)
        maxs(index) = maxs(index).max(num)
    }
    var (result, pre) = (Integer.MIN_VALUE, min)
    for (i <- 0 until mins.indices) {
      if mins(i) != Integer.MAX_VALUE && maxs(i) != Integer.MIN_VALUE then {
        result = result.max(mins(i) - pre)
        pre = maxs(i)
      }
    }
    result.max(max - pre)
```