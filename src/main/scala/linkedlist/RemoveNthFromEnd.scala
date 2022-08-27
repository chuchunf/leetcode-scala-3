package linkedlist

object RemoveNthFromEnd {
  def removeNthFromEnd(head: LinkedListNode[Int], n: Int): LinkedListNode[Int] =
    val len = head.getLen()
    n match
      case num if num > len => throw IllegalArgumentException("n is larger than the length of head")
      case num if num == len => head.next.get
      case _ =>
        var (dummy, fast, slow) = (head, Option(head), Option(head))
        (0 to n).foreach(_ => fast = fast.get.next)
        while fast.isDefined do
          fast = fast.get.next
          slow = slow.get.next
        slow.get.next = slow.get.next.get.next
        dummy
}
