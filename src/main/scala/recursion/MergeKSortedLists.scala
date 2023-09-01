package recursion

import heap.PriorityQueue
import linkedlist.LinkedListNode

object MergeKSortedLists {
  def mergeKLists(lists: Array[LinkedListNode[Int]]): LinkedListNode[Int] =
    _mergeKLists(lists.map(Option(_))).get

  private def _mergeKLists(lists: Array[Option[LinkedListNode[Int]]]): Option[LinkedListNode[Int]] =
    if lists.isEmpty then None else {
      val min = lists.zipWithIndex.foldLeft(0) { case (curr, (node, index)) =>
        if node.get.value < lists(curr).get.value then index else curr
      }
      val curr = lists(min)
      lists(min) = lists(min).get.next
      curr.get.next = _mergeKLists(lists.filter(_.isDefined))
      curr
    }

  // merge multiple list with priority queue
  def mergeKLists2(lists: Array[LinkedListNode[Int]]): LinkedListNode[Int] =
    val pg = new PriorityQueue[LinkedListNode[Int]](128, (a: Int, b: Int) => a < b)
    for (i <- lists.indices) {
      var node = Option(lists(i))
      while node.isDefined do
        pg.offer(node.get, node.get.value)
        node = node.get.next
    }
    val tmp = new LinkedListNode[Int](0, None)
    var curr = tmp
    while !pg.isEmpty do {
      curr.next = Option(pg.poll())
      curr = curr.next.get
    }
    curr.next = None
    tmp.next.get
}
