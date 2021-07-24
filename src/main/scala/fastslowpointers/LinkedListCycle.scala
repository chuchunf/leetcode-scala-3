package fastslowpointers

import linkedlist.LinkedListNode

object LinkedListCycle {
  def hasCycle(head: LinkedListNode[Int]): Boolean =
    var (fast, slow) = (head, head)
    while fast.next.isDefined && slow.next.isDefined do {
      fast = fast.next.get
      if (fast.next.isDefined) fast = fast.next.get
      slow = slow.next.get
      if (fast == slow) return true
    }
    false
}
