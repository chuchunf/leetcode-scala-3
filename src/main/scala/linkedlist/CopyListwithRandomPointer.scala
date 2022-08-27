package linkedlist

import scala.collection.mutable

object CopyListwithRandomPointer {
  def copyRandomList(head: LinkedListWithPointer[Int]): LinkedListWithPointer[Int] =
    val cache = mutable.HashMap[LinkedListWithPointer[Int], LinkedListWithPointer[Int]]()

    var node = Option(head)
    while node.isDefined do
      cache.put(node.get, new LinkedListWithPointer[Int](node.get.value, None, None))
      node = node.get.next

    node = Option(head)
    while node.isDefined do
      cache(node.get).next = node.get.next.map { key => cache(key) }
      cache(node.get).random = node.get.random.map { key => cache(key) }
      node = node.get.next

    cache(head)
}
