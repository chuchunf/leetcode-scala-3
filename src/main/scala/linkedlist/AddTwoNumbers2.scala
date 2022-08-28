package linkedlist

object AddTwoNumbers2 {
  def addTwoNumbers(l1: LinkedListNode[Int], l2: LinkedListNode[Int]): LinkedListNode[Int] =
    val diff = l1.getLen() - l2.getLen()
    val (node, carry) = if diff >= 0 then _addTwoNumbers(Option(l1), Option(l2), diff) else _addTwoNumbers(Option(l2), Option(l1), -diff)
    if carry == 0 then node.get else new LinkedListNode[Int](1, node)

  private def _addTwoNumbers(l1: Option[LinkedListNode[Int]], l2: Option[LinkedListNode[Int]], diff: Int): (Option[LinkedListNode[Int]], Int) =
    if l1.isEmpty || l2.isEmpty then (None, 0) else {
      val (next, carry) = _addTwoNumbers(l1.get.next, if diff == 0 then l2.get.next else l2, if diff == 0 then 0 else diff - 1)
      val value = carry + (if diff == 0 then l1.get.value + l2.get.value else l1.get.value)
      (Option(new LinkedListNode(value % 10, next)), value / 10)
    }
}
