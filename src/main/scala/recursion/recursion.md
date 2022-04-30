# Recursion
Recursion solves problems where the solution depends on solutions to smaller instances of the same problem by using functions that call themselves from within their own code.
- Works with tree/linked list etc. recursive data structures 
- Recursion normally could be converted to Iteration via a Stack

Implement the recursion function 
- Identify recursion case => a problem could be resolved by re-apply same function
- Assume we already find the function then identify exit condition
- Add helper function and with additional variables to keep information

### 21. Merge Two Sorted Lists
```scala
  def mergeTwoLists(l1: LinkedListNode[Int], l2: LinkedListNode[Int]): LinkedListNode[Int] = mergeTwolistsInternal(Option(l1), Option(l2)).get

  private def mergeTwolistsInternal(l1: Option[LinkedListNode[Int]], l2: Option[LinkedListNode[Int]]): Option[LinkedListNode[Int]] =
    (l1, l2) match
      case (None, None) => None
      case (Some(_), None) => l1
      case (None, Some(_)) => l2
      case (Some(n1), Some(n2)) => if n1.value < n2.value then {
        n1.next = mergeTwolistsInternal(n1.next, l2)
        l1
      } else {
        n2.next = mergeTwolistsInternal(l1, n2.next)
        l2
      }
```

### 24. Swap Nodes in Pairs
```scala
  def swapPairs(head: LinkedListNode[Int]): LinkedListNode[Int] =
    if head.next.isEmpty then head
    else {
      val next = head.next.get
      if next.next.isEmpty then {
        head.next = None
        next.next = Some(head)
        next
      } else {
        val newhead = next.next.get
        next.next = Some(head)
        head.next = Some(swapPairs(newhead))
        next
      }
    }
```

### 25. Reverse Nodes in K-Group
```scala
  def reverseKGroup(head: LinkedListNode[Int], k: Int): LinkedListNode[Int] =
    var (tmphead, tail, count) = (head, Option(head), 0)
    while tail.isDefined && count != k do {
      tail = tail.get.next
      count = count + 1
    }
    if count < k then head
    else {
      tail = Option(reverseKGroup(tail.get, k))
      while count > 0 do {
        count = count - 1
        val tmp = tmphead.next
        tmphead.next = tail
        tail = Option(tmphead)
        tmphead = tmp.get
      }
      tail.get
    }
```

### 60. Permutation Sequence
```scala
  def getPermutation(n: Int, k: Int): String =
    val (factorial, numbers) = (ArrayBuffer[Int]().addOne(1), ArrayBuffer[Int]())
    for (i <- 2 to n) factorial.addOne(factorial.last * i)
    for (i <- 1 to n) numbers.addOne(i)
    _getPermutation(n, k, factorial, numbers, "")

  private def _getPermutation(n: Int, k: Int, factorial: ArrayBuffer[Int], nums: ArrayBuffer[Int], buffer: String): String = n match
    case 1 => buffer + nums(0)
    case _ => val i = (k - 1) / factorial(n - 2)
      val num = nums(i)
      nums.remove(i)
      _getPermutation(n - 1, k % factorial(n - 2), factorial, nums, buffer + num.toString)
```

### 23. Merge K Sorted List
```scala
  def mergeKLists(lists: Array[LinkedListNode[Int]]): LinkedListNode[Int] = _mergeKLists(lists.map(Option(_))).get

  private def _mergeKLists(lists: Array[Option[LinkedListNode[Int]]]): Option[LinkedListNode[Int]] =
    if lists.isEmpty then None else {
      val min = lists.zipWithIndex.foldLeft(0) { case (curr, (node, index)) =>
        if node.get.value < lists(curr).get.value then index else curr
      }
      val curr = lists(min)
      lists(min) = lists(min).get.next
      curr.get.next = _mergeKLists(lists.filter(_.isDefined))
      curr
    }
```