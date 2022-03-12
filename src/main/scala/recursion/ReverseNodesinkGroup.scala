package recursion

import linkedlist.LinkedListNode

object ReverseNodesinkGroup {
  def reverseKGroup(head: LinkedListNode[Int], k: Int): LinkedListNode[Int] =
    var (tmphead, tail, count) = (head, Option(head), 0)
    while tail.isDefined && count != k do {
      tail = tail.get.next
      count = count + 1
    }
    if count < k then head
    else {
      tail = Option(reverseKGroup(tail.get, k))
      while count > 0 do {
        count = count - 1
        val tmp = tmphead.next
        tmphead.next = tail
        tail = Option(tmphead)
        tmphead = tmp.get
      }
      tail.get
    }
}
