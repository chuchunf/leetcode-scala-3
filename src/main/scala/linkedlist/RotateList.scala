package linkedlist

import scala.annotation.tailrec

object RotateList {
  def rotateRight(head: LinkedListNode[Int], k: Int): LinkedListNode[Int] =
    var offset = k % getLen(head, 0)
    var (kpoint, tail) = (head, Option(head))

    while tail.get.next.isDefined do
      offset = offset - 1
      if offset == 0 then kpoint = tail.get
      tail = tail.get.next

    val newhead = kpoint.next.get
    kpoint.next = None
    tail.get.next = Some(head)
    newhead

  @tailrec
  private def getLen(node: LinkedListNode[Int], acc: Int): Int = if node.next.isEmpty then acc + 1 else getLen(node.next.get, acc + 1)
}
