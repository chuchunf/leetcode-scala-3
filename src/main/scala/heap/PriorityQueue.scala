package heap

import scala.annotation.tailrec
import scala.collection.mutable

class PriorityQueue[T](var capacity: Int = 128, val compare: (Int, Int) => Boolean = (a, b) => a > b, unique: Boolean = true) {
  private val queue = new Array[Element[T]](capacity)
  private val visited = new mutable.HashSet[T]()
  private var size = 0

  def offer(e: T, priority: Int): Boolean =
    if unique && visited.contains(e) then false else {
      visited.addOne(e)
      val element = Element(e, priority)
      var pos = size
      queue(pos) = element
      while pos != 0 && compare(element.priority, queue(parent(pos)).priority) do {
        swap(pos, parent(pos))
        pos = parent(pos)
      }
      queue(pos) = element
      size = size + 1
      true
    }

  def peek(): T = queue(0).e

  def poll(): T =
    val root = queue(0)
    size = size - 1
    queue(0) = queue(size)
    queue(size) = null
    heapify(0)
    root.e

  def length(): Int = size

  def isEmpty(): Boolean = size == 0

  @tailrec
  private def heapify(i: Int): Unit =
    val (l, r) = (left(i), right(i))
    var smallest = i
    if l < size && compare(queue(l).priority, queue(i).priority) then smallest = l
    if r < size && compare(queue(r).priority, queue(smallest).priority) then smallest = r
    if smallest != i then {
      swap(smallest, i)
      heapify(smallest)
    }

  private def parent(i: Int): Int = (i - 1) / 2

  private def left(i: Int): Int = 2 * i + 1

  private def right(i: Int): Int = 2 * i + 2

  private def swap(l: Int, r: Int): Unit =
    val temp = queue(l)
    queue(l) = queue(r)
    queue(r) = temp

  override def toString: String = queue.to(LazyList).filter(_ != null).mkString(",")
}

case class Element[T](e: T, priority: Int)

