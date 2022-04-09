# Heap
The heap is one maximally efficient implementation of an abstract data type called a priority queue, 
and in fact, priority queues are often referred to as "heaps", regardless of how they may be implemented. 
In a heap, the highest (or lowest) priority element is always stored at the root. 
However, a heap is not a sorted structure; it can be regarded as being partially ordered. 
A heap is a useful data structure when it is necessary to repeatedly remove the object with the highest (or lowest) priority, 
or when insertions need to be interspersed with removals of the root node.

### 506. Relative Ranks
```scala
  def findRelativeRanks(score: Array[Int]): Array[String] =
    val (pq, buffer) = (new PriorityQueue[Int](score.length), Array.ofDim[String](score.length))
    score.zipWithIndex.foreach { case (num, index) => pq.offer(index, num) }
    for (n <- 0 until buffer.length) {
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
    case b => val (pq, factors) = (new PriorityQueue[Int](n * 2, (a, b) => a < b), Array(2, 3, 5))
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