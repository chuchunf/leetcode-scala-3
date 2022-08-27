package linkedlist

object ReorderList {
  def reorderList(head: LinkedListNode[Int]): Unit =
    var (p1, p2) = (head, head)
    while p1.next.isDefined && p2.next.isDefined do
      p1 = p1.next.get
      p2 = p2.next.get.next.get

    val (premid, precurr) = (p1, p1.next.get)
    while precurr.next.isDefined do
      val curr = precurr.next.get
      precurr.next = curr.next
      curr.next = premid.next
      premid.next = Option(curr)

    p1 = head
    p2 = premid.next.get
    while p1 != premid do
      premid.next = p2.next
      p2.next = p1.next
      p1.next = Option(p2)
      p1 = p2.next.get
      if premid.next.isDefined then p2 = premid.next.get
}
