package linkedlist

object ReverseList {
  def reverseList(head: LinkedListNode[Int]): LinkedListNode[Int] = head.next match
    case None => head
    case _ => var (pre, curr) = (head, head.next.get)
      while curr.next.isDefined do
        val next = curr.next.get
        curr.next = Option(pre)
        pre = curr
        curr = next
      curr.next = Option(pre) // TODO: this could be optimized ???
      curr
}
