# Linked List

A linked list is a linear collection of data elements, each element points to the next.
Standard operation, a node has a next pointing to next element, check null for end of the linked list.
Common operations
- dummy.next = head => save and keep the head
- ll.next.next => skip 1 item
- Use two pointers to cover a range 
- Instead of update view, just re-direct the next pointer 

### 2. Add Two Numbers
```scala
  def addTwoNumbers(l1: LinkedListNode[Int], l2: LinkedListNode[Int]): LinkedListNode[Int] =
    val dummyHeader = new LinkedListNode(0, None)
    var current = dummyHeader
    var (node1, node2) = (Option(l1), Option(l2))
    var carry = 0

    while node1.isDefined && node2.isDefined do
      val sum = node1.get.value + node2.get.value + carry
      current = current.append(
        if sum < 10 then {
          carry = 0
          sum
        } else {
          carry = 1
          sum % 10
        })
      node1 = node1.get.next
      node2 = node2.get.next
    if carry == 1 then current.append(1)

    dummyHeader.next.get
```

### 61. Rotate List
```scala
  def rotateRight(head: LinkedListNode[Int], k: Int): LinkedListNode[Int] =
    var offset = k % getLen(head, 0)
    var (kpoint, tail) = (head, Option(head))

    while tail.get.next.isDefined do
      offset = offset - 1
      if (offset == 0) then kpoint = tail.get
      tail = tail.get.next

    val newhead = kpoint.next.get
    kpoint.next = None
    tail.get.next = Some(head)
    newhead

  private def getLen(node: LinkedListNode[Int], acc: Int): Int = if node.next.isEmpty then acc + 1 else getLen(node.next.get, acc + 1)
```

### 19. Remove Nth Node From End of List
```scala
  def removeNthFromEnd(head: LinkedListNode[Int], n: Int): LinkedListNode[Int] =
    val len = getLen(head, 0)
    n match
      case num if (num > len) => throw IllegalArgumentException("n is larger than the length of head")
      case num if (num == len) => head.next.get
      case _ =>
        var (dummy, fast, slow) = (head, Option(head), Option(head))
        (0 to n).foreach(ingored => fast = fast.get.next)
        while (fast.isDefined) do
          fast = fast.get.next
          slow = slow.get.next
        slow.get.next = slow.get.next.get.next
        dummy

  private def getLen(node: LinkedListNode[Int], acc: Int): Int = if node.next.isEmpty then acc + 1 else getLen(node.next.get, acc + 1)
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