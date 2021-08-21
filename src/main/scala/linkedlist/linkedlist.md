# Linked List

A linked list is a linear collection of data elements, each element points to the next.
Standard operation, a node has a next pointing to next element, check null for end of the linked list.
Common operations
- dummy.next = head => save and keep the head
- ll.next.next => skip 1 item
- Use two pointers to cover a range 

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