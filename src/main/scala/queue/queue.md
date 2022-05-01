# Queue
A queue is a data structure maintaining a collection of entities in First-In-First-Out order.
* The end of the sequence at which elements are added is called the tail, 
* The end at which elements are removed is called the head.

Application and tips
* when the order of element enter/exit is significant => Dota2 Senate
* store index not actual value
* if one queue is not enough, use multiple queues
* reverse the order of queue if there are reverse dependencies 

Theoretically, one characteristic of a queue is that it does not have a specific capacity, 
A bounded queue is a queue limited to a fixed number of items.

### 225. Implement Stack using Queues
```scala
class MyStack[T <: Comparable[T]] {
  private val q1 = mutable.Queue[T]()
  private val q2 = mutable.Queue[T]()

  def push(x: T): Unit =
    val (qe, qf) = if q1.isEmpty then (q1, q2) else (q2, q1)
    qe.enqueue(x)
    while !qf.isEmpty do qe.enqueue(qf.dequeue())

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
    if output.isEmpty then

  while !input.isEmpty
  do output.push(input.pop())
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
