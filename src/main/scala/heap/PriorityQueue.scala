package heap

class PriorityQueue[T](var capacity: Int = 128) {
  private val queue = new Array[Element[T]](capacity)
  private var size = 0

  def offer(e: T, priority: Int): Unit =
    val element = Element(e, priority)
    var pos = size
    queue(pos) = element
    while pos != 0 && element.priority > queue(parent(pos)).priority do {
      swap(pos, parent(pos))
      pos = parent(pos)
    }
    queue(pos) = element
    size = size + 1

  def poll(): T =
    val root = queue(0)
    size = size - 1
    queue(0) = queue(size)
    queue(size) = null
    heapify(0)
    root.e

  private def heapify(i: Int): Unit =
    val (l, r) = (left(i), right(i))
    var smallest = i
    if l < size && queue(l).priority > queue(i).priority then smallest = l
    if r < size && queue(r).priority > queue(smallest).priority then smallest = r
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

  override def toString = queue.to(LazyList).filter(_ != null).mkString(",")
}

case class Element[T](e: T, priority: Int)

