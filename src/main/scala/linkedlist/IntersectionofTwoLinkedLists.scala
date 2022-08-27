package linkedlist

object IntersectionofTwoLinkedLists {
  def getIntersectionNode(headA: LinkedListNode[Int], headB: LinkedListNode[Int]): Option[LinkedListNode[Int]] =
    val diff = headA.getLen() - headB.getLen()
    var (pl, ps) = if diff > 0 then (Option(headA), Option(headB)) else (Option(headB), Option(headA))
    for (n <- 0 until diff.abs) pl = pl.get.next
    while pl != ps && pl != None do
      pl = pl.get.next
      ps = ps.get.next
    pl
}
