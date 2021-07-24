package linkedlist

case class LinkedList[T](head: LinkedListNode[T]):
  var tail = head

  def append(node: LinkedListNode[T]) =
    tail.next = Some(node)
    tail = node

sealed class LinkedListNode[T](var value: T, var next: Option[LinkedListNode[T]]):
  def append(value: T): LinkedListNode[T] =
    val next = new LinkedListNode(value, None)
    this.next = Some(next)
    next

  override def toString: String =
    import scala.collection.mutable
    val list = mutable.ArrayBuffer[T]()
    var current = Option(this)

    while (current.isDefined) {
      list.append(current.get.value)
      current = current.get.next
    }
    list.mkString("->")