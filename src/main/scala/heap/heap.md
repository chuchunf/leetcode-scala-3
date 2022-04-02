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