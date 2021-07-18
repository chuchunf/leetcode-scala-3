package linkedlist

object AddTwoNumbers {
  def addTwoNumbers(l1: LinkedListNode[Int], l2: LinkedListNode[Int]): LinkedListNode[Int] =
    val dummyHeader = new LinkedListNode(0, None)
    var current = dummyHeader
    var (node1, node2) = (Option(l1), Option(l2))
    var carry = 0

    while (node1.isDefined && node2.isDefined) {
      val sum = node1.get.value + node2.get.value + carry
      current = current.append(
        if sum < 10 then {
          carry = 0
          sum
        } else {
          carry = 1
          sum % 10
        })
      node1 = node1.get.next
      node2 = node2.get.next
    }
    if carry == 1 then current.append(1)

    dummyHeader.next.get
}
