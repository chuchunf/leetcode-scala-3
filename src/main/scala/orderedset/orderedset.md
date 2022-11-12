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