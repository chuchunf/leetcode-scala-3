package linkedlist

object RemoveDuplicatesfromSortedList {
  def deleteDuplicates(head: LinkedListNode[Int]): LinkedListNode[Int] =
    var first = head
    while first.next.isDefined do
      if first.value == first.next.get.value then first.next = first.next.get.next
      else first = first.next.get
    head
}

