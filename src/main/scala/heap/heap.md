# Heap (priority queue)
The **(binary) heap** is one maximally efficient implementation of an abstract data type **priority queue**.
In fact priority queues are often referred to as "heaps", regardless of how they may be implemented.
- In a heap, the highest (or lowest) priority element is always stored at the root. 
- However, a heap is not a sorted structure; it can be regarded as being **partially ordered**. 

A heap is a useful data structure when it is necessary to repeatedly remove the object with the highest (or lowest) priority, 
or when insertions need to be interspersed with removals of the root node.

Heap can be considered as an alternative data structure of queue/stack that instead of maintain in/out order,
it maintains **an user controlled order** (for example, min and max)

### Implementation
Heap can be implemented as an array with following properties
- parent = Arr[(i-1) / 2]
- left = Arr[(2*i) + 1]
- right = Arr[(2*i) + 2]

### Operation
1. insert: insert an new element
2. delete: remove the root element
3. **heapifiy**: reorder the heap after insertion/deletion to maintain the partial order

### Heapitify
Parent is the smallest/biggest value, when insert or remove, heapitify function called to maintain the partial order of the heap
1. reduce size and move the last element as root
2. start heapifiy process at 0 (root)
3. compare left, right and parent (root)
4. swap with value at largest 
5. recursive heapifty at from largest

### Usages
1. Heap Sort uses Binary Heap to sort an array in O(nLogn) time.
2. Priority queue to get min/max (user defined order) element in O(nLogn) time. 

### 506. Relative Ranks
```scala
  def findRelativeRanks(score: Array[Int]): Array[String] =
    val (pq, buffer) = (new PriorityQueue[Int](score.length), Array.ofDim[String](score.length))
    score.zipWithIndex.foreach { case (num, index) => pq.offer(index, num) }
    for (n <- buffer.indices) {
      buffer(pq.poll()) = n match
        case 0 => "Gold Medal"
        case 1 => "Silver Medal"
        case 2 => "Bronze Medal"
        case n => (n + 1).toString
    }
    buffer
```

### 264. Ugly Number II
```scala
  def nthUglyNumber(n: Int): Int = n match
    case s if s < 7 => s
    case _ => val (pq, factors) = (new PriorityQueue[Int](n * 2, (a, b) => a < b), Array(2, 3, 5))
      var (last, count) = (1, 1)
      while count < n do {
        count = count + 1
        factors.foreach(n => pq.offer(n * last, n * last))
        last = pq.poll()
      }
      last
```

### 215. Kth Largest Element in an Array
```scala
  def findKthLargest(nums: Array[Int], k: Int): Int =
    val pq = new PriorityQueue[Int](unique = false)
    nums.foreach(num => pq.offer(num, num))
    (0 until k).map(_ => pq.poll()).last
```

### 23. Merge K sorted list
```scala
  def mergeKLists2(lists: Array[LinkedListNode[Int]]): LinkedListNode[Int] =
    val pg = new PriorityQueue[LinkedListNode[Int]](128, (a: Int, b: Int) => a < b)
    for (i <- 0 until lists.length) {
      var node = Option(lists(i))
      while node.isDefined do
        pg.offer(node.get, node.get.value)
        node = node.get.next
    }
    val tmp = new LinkedListNode[Int](0, None)
    var curr = tmp
    while !pg.isEmpty() do {
      curr.next = Option(pg.poll())
      curr = curr.next.get
    }
    curr.next = None
    tmp.next.get
```

### 218. The Skyline
```scala
  def getSkyline(buildings: Array[Array[Int]]): List[List[Int]] =
    val (points, result, active) = (mutable.ArrayBuffer[Array[Int]](), mutable.ArrayBuffer[List[Int]](), mutable.HashSet[Int](-1))
    val heap = new PriorityQueue[(Int, Int)]()
    heap.offer((0, -1), 0)
    buildings.zipWithIndex.foreach { case (a, i) => points.addAll(Array(Array(a(0), a(2), 1, i), Array(a(1), a(2), -1, i))) }
    points.sortWith { case (b1, b2) => if b1(0) != b2(0) then b1(0) < b2(0) else b1(1) * b1(2) > b2(1) * b2(2) }
      .foreach { case Array(x, h, lr, i) =>
        if lr == 1 then active.add(i) else active.remove(i)
        if lr == 1 then {
          if !heap.isEmpty() && h > heap.peek()._1 then result.addOne(List(x, h))
          heap.offer((h, i), h)
        } else {
          while !heap.isEmpty() && !active.contains(heap.peek()._2) do heap.poll()
          if !heap.isEmpty() && heap.peek()._1 != result.last(1) then result.addOne(List(x, heap.peek()._1))
        }
      }
    result.toList
```