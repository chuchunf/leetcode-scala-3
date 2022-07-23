package graph

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

case class Node[T](var value: T, neighbors: mutable.ListBuffer[Node[T]]) {
  override def hashCode(): Int = this.value.hashCode()

  override def equals(obj: Any): Boolean = obj match
    case node2: Node[T] => this.value == node2.value
    case _ => false

  override def toString: String =
    val (sb, cache) = (new StringBuilder(), mutable.HashSet[Node[T]]())
    _toString(this, sb, cache)
    sb.toString()

  private def _toString(node: Node[T], sb: StringBuilder, cache: mutable.HashSet[Node[T]]): Unit =
    sb.append(node.value.toString).append("->[")
    sb.append(node.neighbors.map(_.value.toString).mkString(",")).append("]").append("\n")
    cache.addOne(node)
    node.neighbors.foreach { case n =>
      if !cache.contains(n) then _toString(n, sb, cache)
    }

  def deepEquals(n2: Node[T]): Boolean =
    val cache = mutable.HashSet[Node[T]]()
    _deepEquals(this, n2, cache)

  private def _deepEquals(n1: Node[T], n2: Node[T], cache: mutable.HashSet[Node[T]]): Boolean =
    if cache.contains(n1) then true else {
      cache.addOne(n1)
      if n1.value != n2.value then false
      else if n1.neighbors.length != n2.neighbors.length then false else {
        n1.neighbors.zip(n2.neighbors).foldLeft(false) { case (r, (nn1, nn2)) =>
          r || _deepEquals(nn1, nn2, cache)
        }
      }
    }
}

object Node {
  def apply[T](value: T): Node[T] = new Node[T](value, new ListBuffer[Node[T]]())

  def array2Node(values: Array[Array[Int]]): Node[Int] =
    val nodes = (0 until values.length).map { case i => Node(i) }.toList
    (0 to values.length - 1).foreach { case i =>
      values(i).foreach { case n => nodes(i).neighbors.addOne(nodes(n-1)) }
    }
    nodes.head
}