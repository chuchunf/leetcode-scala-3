package sort

import linkedlist.LinkedListNode

object SortList {
  def sortList(head: LinkedListNode[Int]): LinkedListNode[Int] =
    if head.next.isEmpty then head
    else {
      var (pre, slow, fast) = (head, Option(head), Option(head))
      while fast.isDefined do {
        fast = fast.get.next
        if fast.isDefined then fast = fast.get.next
        pre = slow.get
        slow = slow.get.next
      }
      pre.next = None
      merge(sortList(head), sortList(slow.get))
    }

  private def merge(l1: LinkedListNode[Int], l2: LinkedListNode[Int]): LinkedListNode[Int] =
    val tmp = new LinkedListNode[Int](0, None)
    var (p, l1p, l2p) = (tmp, Option(l1), Option(l2))
    while l1p.isDefined && l2p.isDefined do
      if l1p.get.value > l2p.get.value then {
        p.next = l1p
        l1p = l1p.get.next
      } else {
        p.next = l2p
        l2p = l2p.get.next
      }
      p = p.next.get
    if l1p.isDefined then p.next = l1p
    if l2p.isDefined then p.next = l2p
    tmp.next.get
}
