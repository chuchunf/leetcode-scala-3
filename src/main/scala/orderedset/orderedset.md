# Ordered Set (Map)

A **set** can store **unique values, without any particular order**.

* Set is closely related to Map, the difference is **set is used to store only keys** while map is used to store key value pairs.
* Set is commonly **implemented the same way as Map**, in which the value of each key-value pair has a fixed value (like1)

An **ordered set** keeps the unique elements in sorted order. The time and space complexity depend on implementation

| Properties     | Hashmap             | TreeMap             | LinkedHashMap  |
|----------------|---------------------|---------------------|----------------|
| Iteration      | No guaranteed order | sorted order        | insertion order |
| Get/Put/Remove | O(1)                | O(log(n))           | O(1)           |
| Nulls          | keys and values     | only values         | keys and values |
| Implementation | buckets             | red-black tree      | double linked buckets |
| Applications   | general purpose     | where order matters | LRU cache, etc. where insertion/access order matters |

Common application is to **get a particular key (value pair) with given condition (head/tail/floor/ceil) of predefined order**.

Sortset enables **search for a key with Log(n) time**.

### 729. My Calendar I
```scala
  private[this] val cache = mutable.TreeMap[Int, Int]()

  def book(start: Int, end: Int): Boolean =
    if cache.minAfter(start).getOrElse((Int.MaxValue, Int.MaxValue))._1 > end
      && cache.maxBefore(start).getOrElse((Int.MinValue, Int.MinValue))._2 < start
    then {
      cache(start) = end
      true
    } else false
```

### 731. My Calendar II
```scala
  private[this] val cache = mutable.TreeMap[Int, Int]()

  def book(start: Int, end: Int): Boolean =
    if cache.minAfter(start).getOrElse((Int.MaxValue, Int.MaxValue))._1 <= end then {
      val second = cache.minAfter(cache.minAfter(start).get._1).getOrElse((Int.MaxValue, Int.MaxValue))._1
      if second <= end then false else
        cache(start) = end
        true
    } else if cache.maxBefore(start).getOrElse((Int.MinValue, Int.MinValue))._2 >= start then {
      val second = cache.maxBefore(cache.maxBefore(start).get._1).getOrElse(Int.MaxValue, Int.MaxValue)._2
      if second <= end then false else
        cache(start) = end
        true
    } else {
      cache(start) = end
      true
    }
```

### 855. Exam Room
```scala
class ExamRoom(n: Int) {
  private[this] val dists = mutable.TreeSet[(Int, Int)]()(DistOrdering)
  private[this] val points = mutable.TreeMap[Int, mutable.Set[Int]]()

  def seat(): Int = points.size match
    case 0 => points(0) = mutable.Set[Int]().addOne(n - 1)
      0
    case 1 => points(n - 1) = mutable.Set[Int]().addOne(0)
      dists.addOne((0, n - 1))
      n - 1
    case _ => val (begin, end) = dists.head
      val mid: Int = begin + (end - begin) / 2
      dists.addOne((begin, mid)).addOne((mid, end)).remove((begin, end))
      points(mid) = mutable.Set[Int]().addOne(begin).addOne(end)
      points(begin).addOne(mid).remove(end)
      points(end).addOne(mid).remove(begin)
      mid

  def leave(p: Int): Unit =
    val ps = points.remove(p).get.toList
    val (begin, end) = if ps.head > ps.last then (ps.last, ps.head) else (ps.head, ps.last)
    dists.remove((begin, p))
    dists.remove(p, end)
    dists.add(begin, end)
  
  object DistOrdering extends Ordering[(Int, Int)] {
    def compare(key1: (Int, Int), key2: (Int, Int)): Int = ((key2._2 - key2._1) / 2).compareTo((key1._2 - key1._1) / 2)
  }
}
```

### 1818. Minimum Absolute Sum Difference
```scala
  def minAbsoluteSumDiff(nums1: Array[Int], nums2: Array[Int]): Int =
    val cache = mutable.TreeSet[Int]().addAll(nums1)
    nums1.zip(nums2).foldLeft((0L, 0)) { case ((sum, maxdiff), (n1, n2)) =>
      val diff1 = Math.abs(cache.minAfter(n2).getOrElse(Int.MinValue) - n2)
      val diff2 = Math.abs(cache.maxBefore(n2).getOrElse(Int.MaxValue) - n2)
      val diff = Math.abs(n1 - n2)
      (sum + diff, maxdiff.max(diff - diff1.min(diff2)))
    } match
      case (sum, maxdiff) => ((sum - maxdiff) % (Math.pow(10, 9).toInt + 7)).toInt
```

### 732. My Calendar III
Use Order Map to simulate the time line to save space, as the time spot will be sparse.
```scala
class MyCalendar3 {
  private[this] val cache = mutable.TreeMap[Int, Int]()

  def book(startTime: Int, endTime: Int): Int =
    cache(startTime) = cache.getOrElse(startTime, 0) + 1
    cache(endTime) = cache.getOrElse(endTime, 0) - 1
    cache.values.foldLeft(0, 0) { case ((max, ongoing), booking) =>
      val curr = ongoing + booking
      (max.max(curr), curr)
    }._1
}
```