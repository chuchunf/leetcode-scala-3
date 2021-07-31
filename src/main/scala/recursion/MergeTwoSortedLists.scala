package recursion

import linkedlist.LinkedListNode

object MergeTwoSortedLists {
  def mergeTwoLists(l1: LinkedListNode[Int], l2: LinkedListNode[Int]): LinkedListNode[Int] = mergeTwolistsInternal(Option(l1), Option(l2)).get

  private def mergeTwolistsInternal(l1: Option[LinkedListNode[Int]], l2: Option[LinkedListNode[Int]]): Option[LinkedListNode[Int]] =
    (l1, l2) match
      case (None, None) => None
      case (Some(_), None) => l1
      case (None, Some(_)) => l2
      case (Some(n1), Some(n2)) => if n1.value < n2.value then {
        n1.next = mergeTwolistsInternal(n1.next, l2)
        l1
      } else {
        n2.next = mergeTwolistsInternal(l1, n2.next)
        l2
      }
}
