# Fast Slow Pointers

Fast and Slow pointers is an algorithm that works by setting two pointers that move at different speeds, one faster than the other.
The technique works linked data structures such as array, linked list.

The key is to control the speed or starting position (fast/slow) from same direction
- Move at different speed => detect cycle
- Move 2 times speed => detect middle
- Start from different start position => delete nth node in 1 pass

This technique also has two pointers (same as two pointers technique), but 
- Slow/Fast pointers move dependently 
- Hence the key is not to detect when to move which pointer, rather the end condition

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