package fastslowpointers

import linkedlist.LinkedListNode

object LinkedListCycle2 {
  def detectCycle(head: LinkedListNode[Int]): Option[LinkedListNode[Int]] =
    var (fast, slow, isCycle) = (head, head, false)
    while fast.next.isDefined && slow.next.isDefined && !isCycle do
      fast = fast.next.get
      if (fast.next.isDefined) {
        fast = fast.next.get
        slow = slow.next.get
        if (fast == slow) isCycle = true
      }

    if !isCycle then None
    else {
      fast = head
      while fast != slow do {
        fast = fast.next.get
        slow = slow.next.get
      }
      Option(fast)
    }
}
