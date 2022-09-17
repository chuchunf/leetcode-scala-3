package queue

import scala.collection.mutable

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
