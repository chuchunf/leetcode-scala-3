# Fast Slow Pointers

Fast and Slow pointers is an algorithm that works by setting two pointers that move at different speeds, one faster than the other.
The technique works linked data structures such as array, linked list.

The key is to control the speed or distance (fast/slow)
- Move at different speed => detect cycle
- Move with given range => delete nth node in 1 pass
- Move 2 times speed => detect middle

This technique also has two pointers (same as two pointer technique), but 
- Slow/Fast pointers move dependently 
- Hence the condition is not to detect when to move which pointer, rather the end condition

Multiple pass could be used to collect more information

### 141. Linked List Cycle
```scala
  def hasCycle(head: LinkedListNode[Int]): Boolean =
    var (fast, slow) = (head, head)
    while fast.next.isDefined && slow.next.isDefined do {
      fast = fast.next.get
      if (fast.next.isDefined) fast = fast.next.get
      slow = slow.next.get
      if (fast == slow) return true
    }
    false
```

### 876. Middle of the Linked List
```scala
  def middleNode(head: LinkedListNode[Int]): LinkedListNode[Int] =
    var (fast, slow) = (head, head)
    while fast.next.isDefined do {
      fast = fast.next.get
      if (fast.next.isDefined) fast = fast.next.get
      slow = slow.next.get
    }
    slow
```

### 142. Linked List Cycle II
```scala
  def detectCycle(head: LinkedListNode[Int]): Option[LinkedListNode[Int]] =
    var (fast, slow) = (head, head)
    var (isCyle, index) = (false, 0)
    while fast.next.isDefined && slow.next.isDefined && isCyle == false do
      fast = fast.next.get
      if (fast.next.isDefined) {
        fast = fast.next.get
        slow = slow.next.get
        if (fast == slow) isCyle = true
      }

    if !isCyle then None
    else {
      fast = head
      while fast != slow do {
        fast = fast.next.get
        slow = slow.next.get
      }
      Option(fast)
    }
```

### 219. Contains Duplicate II
```scala
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean =
    val cache = mutable.HashSet[Int]()
    nums.zipWithIndex.find { case (num, index) => {
      if index > k then cache.remove(nums(index - k - 1))
      if !cache.add(num) then true else false
    }}.isDefined
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