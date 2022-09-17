package queue

import scala.collection.mutable

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
