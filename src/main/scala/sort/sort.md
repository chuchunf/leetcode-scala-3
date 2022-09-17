# Sort
a collection of common sort algorithms and sort related problems

## Merge Sort
1. Splits the array in half until it cannot be further divided (empty or 1 element)
2. Merge the two sorted arrays into a large sorted array  

### 148. Sort List
merge sort, divide and merge (sort)
```scala
  def sortList(head: LinkedListNode[Int]): LinkedListNode[Int] =
    if head.next.isEmpty then head
    else {
      var (pre, slow, fast) = (head, Option(head), Option(head))
      while fast.isDefined do {
        fast = fast.get.next
        if fast.isDefined then fast = fast.get.next
        pre = slow.get
        slow = slow.get.next
      }
      pre.next = None
      merge(sortList(head), sortList(slow.get))
    }

  private def merge(l1: LinkedListNode[Int], l2: LinkedListNode[Int]): LinkedListNode[Int] =
    val tmp = new LinkedListNode[Int](0, None)
    var (p, l1p, l2p) = (tmp, Option(l1), Option(l2))
    while l1p.isDefined && l2p.isDefined do
      if l1p.get.value > l2p.get.value then {
        p.next = l1p
        l1p = l1p.get.next
      } else {
        p.next = l2p
        l2p = l2p.get.next
      }
      p = p.next.get
    if l1p.isDefined then p.next = l1p
    if l2p.isDefined then p.next = l2p
    tmp.next.get
```

### 49. Group Anagrams
```scala
  def groupAnagrams(strs: Array[String]): List[List[String]] =
    val cache = mutable.HashMap[String, List[String]]()
    strs.foreach { str => cache.update(str.sorted, cache.getOrElse(str.sorted, List.empty[String]) :+ str) }
    cache.values.toList
```

### 56. Merge Intervals
```scala
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] =
    val sorted = intervals.sortBy(_ (0))
    sorted.tail.foldLeft(new ArrayBuffer[Array[Int]]().addOne(sorted.head)) {
      case (result, curr) if result.last(1) >= curr(0) => result.last(1) = result.last(1).max(curr(1))
        result
      case (result, curr) => result.addOne(curr)
    }.toArray
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