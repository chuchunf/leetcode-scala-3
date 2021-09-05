package linkedlist

object IntersectionofTwoLinkedLists {
  def getIntersectionNode(headA: LinkedListNode[Int], headB: LinkedListNode[Int]): Option[LinkedListNode[Int]] =
    val diff = getLen(new LinkedListNode[Int](0, Option(headA)), 0) - getLen(new LinkedListNode[Int](0, Option(headB)), 0)
    var (pl, ps) = if diff > 0 then (Option(headA), Option(headB)) else (Option(headB), Option(headA))
    for (n <- 0 until diff.abs) pl = pl.get.next
    while pl != ps && pl != None do
      pl = pl.get.next
      ps = ps.get.next
    pl

  private def getLen(node: LinkedListNode[Int], acc: Int): Int = if node.next.isEmpty then acc + 1 else getLen(node.next.get, acc + 1)
}
