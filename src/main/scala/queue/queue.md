# Queue

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