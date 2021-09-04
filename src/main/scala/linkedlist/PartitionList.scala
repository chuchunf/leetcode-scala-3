package linkedlist

object PartitionList {
  def partition(head: LinkedListNode[Int], x: Int): LinkedListNode[Int] =
    var (smallp, bigp, tmp) = (new LinkedListNode[Int](0, None), new LinkedListNode[Int](0, None), Option(head))
    val (smallhead, bighead) = (smallp, bigp)
    while tmp.isDefined do {
      if tmp.get.value < x then {
        smallp.next = tmp
        smallp = smallp.next.get
      } else {
        bigp.next = tmp
        bigp = bigp.next.get
      }
      tmp = tmp.get.next
    }
    bigp.next = None
    smallp.next = Option(bighead.next.get)
    smallhead.next.get
}
