package linkedlist

object RemoveDuplicatesfromSortedListII {
  def deleteDuplicates(head: LinkedListNode[Int]): LinkedListNode[Int] =
    val temphead = new LinkedListNode[Int](-1, Option(head))
    var (pre, curr) = (temphead, Option(head))
    while curr.isDefined do {
      while curr.get.next.isDefined && curr.get.value == curr.get.next.get.value do curr = curr.get.next
      if pre.next.get.value == curr.get.value then pre = pre.next.get
      else pre.next = curr.get.next
      curr = curr.get.next
    }
    temphead.next.get
}
