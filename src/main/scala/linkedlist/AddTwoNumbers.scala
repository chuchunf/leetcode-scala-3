package linkedlist

object AddTwoNumbers {
  // recursive solution
  def addTwoNumbers(l1: LinkedListNode[Int], l2: LinkedListNode[Int]): LinkedListNode[Int] =
    _addTwoNumbers(Option(l1), Option(l2), 0).get

  private def _addTwoNumbers(l1: Option[LinkedListNode[Int]], l2: Option[LinkedListNode[Int]], carry: Int): Option[LinkedListNode[Int]] = (l1, l2) match
    case (None, None) => if carry == 0 then None else Option(new LinkedListNode(1, None))
    case (_, _) => val value = l1.get.value + l2.get.value + carry
      Option(new LinkedListNode(value % 10, _addTwoNumbers(l1.get.next, l2.get.next, value / 10)))

  // Iterative solution
  def addTwoNumbers2(l1: LinkedListNode[Int], l2: LinkedListNode[Int]): LinkedListNode[Int] =
    val dummyHeader = new LinkedListNode(0, None)
    var current = dummyHeader
    var (node1, node2) = (Option(l1), Option(l2))
    var carry = 0

    while node1.isDefined && node2.isDefined do
      val sum = node1.get.value + node2.get.value + carry
      current = current.append(sum % 10)
      carry = sum / 10
      node1 = node1.get.next
      node2 = node2.get.next
    if carry == 1 then current.append(1)

    dummyHeader.next.get
}
