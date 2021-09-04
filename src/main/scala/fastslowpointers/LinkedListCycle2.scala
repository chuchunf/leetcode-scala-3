package fastslowpointers

import linkedlist.LinkedListNode

object LinkedListCycle2 {
  def detectCycle(head: LinkedListNode[Int]): Option[LinkedListNode[Int]] =
    var (fast, slow) = (head, head)
    var (isCyle, index) = (false, 0)
    while fast.next.isDefined && slow.next.isDefined && isCyle == false do
      fast = fast.next.get
      if (fast.next.isDefined) {
        fast = fast.next.get
        slow = slow.next.get
        if (fast == slow) isCyle = true
      }

    if !isCyle then None
    else {
      fast = head
      while fast != slow do {
        fast = fast.next.get
        slow = slow.next.get
      }
      Option(fast)
    }
}
