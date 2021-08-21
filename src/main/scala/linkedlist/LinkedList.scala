package linkedlist

import scala.collection.mutable

case class LinkedList[T](head: LinkedListNode[T]):
  var tail = head

  def append(node: LinkedListNode[T]) =
    tail.next = Some(node)
    tail = node

class LinkedListNode[T](var value: T, var next: Option[LinkedListNode[T]]):
  def append(value: T): LinkedListNode[T] =
    val next = new LinkedListNode(value, None)
    this.next = Some(next)
    next

  def toList: List[T] =
    val array = mutable.ArrayBuffer[T]()
    var current = Option(this)
    while current.isDefined do
      array.append(current.get.value)
      current = current.get.next
    array.toList

  override def toString: String = this.toList.mkString("->")

class LinkedListWithPointer[T](var value: T, var next: Option[LinkedListWithPointer[T]], var random: Option[LinkedListWithPointer[T]])