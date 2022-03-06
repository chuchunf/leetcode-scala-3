package recursion

import linkedlist.LinkedListNode

object SwapNodesinPairs {
  def swapPairs(head: LinkedListNode[Int]): LinkedListNode[Int] =
    if head.next.isEmpty then head
    else {
      val next = head.next.get
      if next.next.isEmpty then {
        head.next = None
        next.next = Some(head)
        next
      } else {
        val newhead = next.next.get
        next.next = Some(head)
        head.next = Some(swapPairs(newhead))
        next
      }
    }
}
