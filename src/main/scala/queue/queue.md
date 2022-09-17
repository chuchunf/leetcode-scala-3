# Queue
A queue is a data structure maintaining a collection of entities in **First-In-First-Out** order.
* The end of the sequence at which elements are added is called the tail => **Enqueue**
* The end at which elements are removed is called the head => **Dequeue**

Theoretically, one characteristic of a queue is that it does not have a specific capacity,
A bounded queue is a queue limited to a fixed number of items.

## Implementation
1. Use a fixed-size **array** and two pointers to indicate the starting position and the ending position.
2. Use a **Linked List**,
    * a doubly linked list has O(1) insertion and deletion at both ends, so it is a natural choice for queues.
    * a singly linked list could provide the same with a pointer at tis end

## Application and tips
* Breath first search
* When the order of element enter/exit is significant 

## Tips
* Store index not actual value
* If one queue is not enough, use multiple queues
* Reverse the order of queue if there are reverse dependencies 

## Related data structure
* **Priority queue**: a queue with each element additionally has a priority associated with it
* **Circular buffer**: a single, fixed-size buffer as if it were connected end-to-end

### 225. Implement Stack using Queues
```scala
class MyStack[T <: Comparable[T]] {
  private val q1 = mutable.Queue[T]()
  private val q2 = mutable.Queue[T]()

  def push(x: T): Unit =
  val (qe, qf) = if q1.isEmpty then (q1, q2) else (q2, q1)
  qe.enqueue(x)
  while qf.nonEmpty do qe.enqueue(qf.dequeue())

  def pop(): T =
  val q = if q1.isEmpty then q2 else q1
  if q.isEmpty then throw new IllegalArgumentException("empty stack")
  else q.dequeue()

  def top(): T =
  val q = if q1.isEmpty then q2 else q1
  if q.isEmpty then throw new IllegalArgumentException("empty stack")
  else q.head

  def empty(): Boolean = q1.isEmpty && q2.isEmpty
}
```

### 232. Implement Queue Using Stacks
```scala
class MyQueue[T] {
  private val input = mutable.Stack[T]()
  private val output = mutable.Stack[T]()

  def push(x: T): Unit = input.push(x)

  def pop(): T =
    this.peek()
    output.pop()

  def peek(): T =
    if output.isEmpty then while input.nonEmpty do output.push(input.pop())
    output.head

  def empty(): Boolean = input.isEmpty && output.isEmpty
}
```

### 239. Sliding Window Maximum
```scala
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] =
    nums.indices.foldLeft((mutable.ArrayDeque[Int](), mutable.ArrayBuffer[Int]())) { case ((q, solution), i) =>
      q.removeLastWhile { last => nums(last) < nums(i) && last >= (i - k + 1) }
      q.append(i)
      q.removeHeadWhile(_ < i - k + 1)
      if i >= (k - 1) then (q, solution :+ nums(q.head)) else (q, solution)
    }._2.toArray
```

### 649. Dota2 Senate
```scala
  def predictPartyVictory(senate: String): String =
    val (qr, qd) = (mutable.ArrayDeque[Int](), mutable.ArrayDeque[Int]())
    senate.zipWithIndex.foreach {
      case ('R', index) => qr.addOne(index)
      case (_, index) => qd.addOne(index)
    }
    while !qr.isEmpty && !qd.isEmpty do
      val (ri, di) = (qr.removeHead(), qd.removeHead())
      if ri < di then qr.addOne(senate.length + ri) else qd.addOne(senate.length + di)
    if qr.size > qd.size then "Radiant" else "Dire"
```

### 281. Zigzag Iterator
```scala
class ZigzagIterator(val l1: List[Int], val l2: List[Int]) {
  private[this] val iterators = mutable.Queue[Iterator[Int]]()
  if l1.nonEmpty then iterators.enqueue(l1.iterator)
  if l2.nonEmpty then iterators.enqueue(l2.iterator)

  def next: Int =
    val iterator = iterators.dequeue()
    val result = iterator.next()
    if iterator.hasNext then iterators.enqueue(iterator)
    result

  def hasNext: Boolean = iterators.nonEmpty
}
```

### 950. Reveal Cards In Increasing Order
```scala
  def deckRevealedIncreasing(deck: Array[Int]): Array[Int] =
    deck.sorted.reverse
      .foldLeft(mutable.ArrayDeque[Int]()) { case (q, num) =>
        if q.nonEmpty then q.prepend(q.removeLast())
        q.prepend(num)
      }.toArray
```