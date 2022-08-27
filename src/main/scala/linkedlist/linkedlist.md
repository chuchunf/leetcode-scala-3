# Linked List

A linked list is a linear collection of data elements, each element has a pointer to the next element.
Linked list allows for efficient **insertion or removal of elements from any position** in the sequence during iteration.
Linked list does not allow random access, index based operation, requires an iteration.

- Standard operation
    - a node has a next pointing to next element, check null for end of the linked list. 
- Common operations
    - dummy.next = head => use a dummy a head to save and keep the original head
    - ll.next.next => skip 1 item
    - Use two pointers to cover a range 
    - Instead of update value, just re-point the next pointer 

### Data structures built from Linked List
Linked list can be used to implement other common abstract data types
- Lists
- Stacks
- Queues
- Hashmaps

### Algorithms with Listed list
- Listed list is a **recursive data structure** and works well with recursion.
- Two pointers / fast slow pointers / sliding windows

## Typical Questions 
### Basic Linked list operation
- Rotate a list
- Reverse a list
- Reorder a list
- Partition a list

### Additional list operations
- Remove Nth from end
- Remove duplicates from sorted list
- Remove duplicates from sorted list 2
- Copy List with Random Pointers

### Application of linked list
- Add Two numbers

### 2. Add Two Numbers
```scala
  def addTwoNumbers(l1: LinkedListNode[Int], l2: LinkedListNode[Int]): LinkedListNode[Int] =
  _addTwoNumbers(Option(l1), Option(l2), 0).get

  private def _addTwoNumbers(l1: Option[LinkedListNode[Int]], l2: Option[LinkedListNode[Int]], carry: Int): Option[LinkedListNode[Int]] = (l1, l2) match
    case (None, None) => if carry == 0 then None else Option(new LinkedListNode(1, None))
    case (Some(node1), Some(node2)) => val value = node1.value + node2.value + carry
    Option(new LinkedListNode(value % 10, _addTwoNumbers(node1.next, node2.next, value / 10)))
```

### 61. Rotate List
```scala
  def rotateRight(head: LinkedListNode[Int], k: Int): LinkedListNode[Int] =
    var offset = head.getLen()
    var (kpoint, tail) = (head, Option(head))

    while tail.get.next.isDefined do
      offset = offset - 1
      if (offset == 0) then kpoint = tail.get
      tail = tail.get.next

    val newhead = kpoint.next.get
    kpoint.next = None
    tail.get.next = Some(head)
    newhead
```

### 19. Remove Nth Node From End of List
```scala
  def removeNthFromEnd(head: LinkedListNode[Int], n: Int): LinkedListNode[Int] =
    val len = head.getLen()
    n match
      case num if num > len => throw IllegalArgumentException("n is larger than the length of head")
      case num if num == len => head.next.get
      case _ =>
        var (dummy, fast, slow) = (head, Option(head), Option(head))
        (0 to n).foreach(_ => fast = fast.get.next)
        while fast.isDefined do
          fast = fast.get.next
          slow = slow.get.next
        slow.get.next = slow.get.next.get.next
        dummy
```

### 206. Reverse Linked List
```scala
  def reverseList(head: LinkedListNode[Int]): LinkedListNode[Int] = head.next match
    case None => head
    case _ => var (pre, curr) = (head, head.next.get)
      while curr.next.isDefined do
        val next = curr.next.get
        curr.next = Option(pre)
        pre = curr
        curr = next
      curr.next = Option(pre) 
      curr
```

### 83. Remove Duplicates from Sorted List
```scala
  def deleteDuplicates(head: LinkedListNode[Int]): LinkedListNode[Int] =
    var first = head
    while first.next.isDefined do
      if first.value == first.next.get.value then first.next = first.next.get.next
      else first = first.next.get
    head
```
### 138. Copy List with Random Pointer
```scala
  def copyRandomList(head: LinkedListWithPointer[Int]): LinkedListWithPointer[Int] =
    val cache = mutable.HashMap[LinkedListWithPointer[Int], LinkedListWithPointer[Int]]()

    var node = Option(head)
    while node.isDefined do
      cache.put(node.get, new LinkedListWithPointer[Int](node.get.value, None, None))
      node = node.get.next

    node = Option(head)
    while node.isDefined do
      cache.get(node.get).get.next = node.get.next.map { key => cache.get(key).get }
      cache.get(node.get).get.random = node.get.random.map { key => cache.get(key).get }
      node = node.get.next

    cache.get(head).get
```

### 82. Remove Duplicates from Sorted List II
```scala
  def deleteDuplicates(head: LinkedListNode[Int]): LinkedListNode[Int] =
    val temphead = new LinkedListNode[Int](-1, Option(head))
    var (pre, curr) = (temphead, Option(head))
    while curr.isDefined do {
      while curr.get.next.isDefined && curr.get.value == curr.get.next.get.value do curr = curr.get.next
      if pre.next.get.value == curr.get.value then pre = pre.next.get
      else pre.next = curr.get.next
      curr = curr.get.next
    }
    temphead.next.get
```

### 86. Partition List
```scala
  def partition(head: LinkedListNode[Int], x: Int): LinkedListNode[Int] =
    var (smallp, bigp, tmp) = (new LinkedListNode[Int](0, None), new LinkedListNode[Int](0, None), Option(head))
    val (smallhead, bighead) = (smallp, bigp)
    while tmp.isDefined do {
      if tmp.get.value < x then {
        smallp.next = tmp
        smallp = smallp.next.get
      } else {
        bigp.next = tmp
        bigp = bigp.next.get
      }
      tmp = tmp.get.next
    }
    bigp.next = None
    smallp.next = Option(bighead.next.get)
    smallhead.next.get
```

### 143. Reorder List
```scala
  def reorderList(head: LinkedListNode[Int]): Unit =
    var (p1, p2) = (head, head)
    while p1.next.isDefined && p2.next.isDefined do
      p1 = p1.next.get
      p2 = p2.next.get.next.get

    var (premid, precurr) = (p1, p1.next.get)
    while precurr.next.isDefined do
      val curr = precurr.next.get
      precurr.next = curr.next
      curr.next = premid.next
      premid.next = Option(curr)

    p1 = head
    p2 = premid.next.get
    while p1 != premid do
      premid.next = p2.next
      p2.next = p1.next
      p1.next = Option(p2)
      p1 = p2.next.get
      if premid.next.isDefined then p2 = premid.next.get
```

### 160. Intersection of Two Linked Lists
```scala
  def getIntersectionNode(headA: LinkedListNode[Int], headB: LinkedListNode[Int]): Option[LinkedListNode[Int]] =
    val diff = getLen(new LinkedListNode[Int](0, Option(headA)), 0) - getLen(new LinkedListNode[Int](0, Option(headB)), 0)
    var (pl, ps) = if diff > 0 then (Option(headA), Option(headB)) else (Option(headB), Option(headA))
    for (n <- 0 until diff.abs) pl = pl.get.next
    while pl != ps && pl != None do
      pl = pl.get.next
      ps = ps.get.next
    pl

  private def getLen(node: LinkedListNode[Int], acc: Int): Int = if node.next.isEmpty then acc + 1 else getLen(node.next.get, acc + 1)
```