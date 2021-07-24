package fastslowpointers

import linkedlist.LinkedListNode

object MiddleoftheLinkedList {
  def middleNode(head: LinkedListNode[Int]): LinkedListNode[Int] =
    var (fast, slow) = (head, head)
    while fast.next.isDefined do {
      fast = fast.next.get
      if (fast.next.isDefined) fast = fast.next.get
      slow = slow.next.get
    }
    slow
}
