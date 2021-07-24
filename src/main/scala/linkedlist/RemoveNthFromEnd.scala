package linkedlist

object RemoveNthFromEnd {
  def removeNthFromEnd(head: LinkedListNode[Int], n: Int): LinkedListNode[Int] =
    val len = getLen(head, 0)
    n match
      case num if (num > len) => throw IllegalArgumentException("n is larger than the length of head")
      case num if (num == len) => head.next.get
      case _ =>
        var (dummy, fast, slow) = (head, Option(head), Option(head))
        (0 to n).foreach(ingored => fast = fast.get.next)
        while (fast.isDefined) do
          fast = fast.get.next
          slow = slow.get.next
        slow.get.next = slow.get.next.get.next
        dummy

  private def getLen(node: LinkedListNode[Int], acc: Int): Int = if node.next.isEmpty then acc + 1 else getLen(node.next.get, acc + 1)
}
