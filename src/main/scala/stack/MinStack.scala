package stack

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class MinStack[T <: Comparable[T]]() {
  private var head: Option[Node[T]] = None
  private var min: Option[T] = None

  def push(value: T): Unit = head match
    case None => head = Option(new Node(value, None))
      min = Option(value)
    case _ => head = Option(new Node(value, head))
      min = Option(if min.get.compareTo(value) > 0 then value else min.get)

  def pop(): T = head match
    case None => throw new IllegalArgumentException("empty stack!")
    case Some(node) => head = head.get.next
      head match {
        case None => min = None
        case _ => var (temp, newmin) = (head, head.get.value)
          while temp.isDefined do
            newmin = if newmin.compareTo(temp.get.value) > 0 then temp.get.value else newmin
            temp = temp.get.next
          min = Option(newmin)
      }
      node.value

  def top(): T = head match
    case None => throw new IllegalArgumentException("empty stack!")
    case Some(node) => node.value

  def getMin(): T = min match
    case None => throw new IllegalArgumentException("empty stack!")
    case Some(value) => value

  override def toString(): String =
    var (temp, buffer) = (head, new ArrayBuffer[T]())
    while (temp.isDefined) do
      buffer.append(temp.get.value)
      temp = temp.get.next
    buffer.mkString("->")

  def isEmpty(): Boolean = head.isEmpty

  def clear(): Unit =
    head = None
    min = None
}

class Node[T](var value: T, var next: Option[Node[T]]) {
}
