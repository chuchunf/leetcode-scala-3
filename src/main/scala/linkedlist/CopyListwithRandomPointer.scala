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
      cache.get(node.get).get.next = node.get.next.map { key => cache.get(key).get }
      cache.get(node.get).get.random = node.get.random.map { key => cache.get(key).get }
      node = node.get.next

    cache.get(head).get
}
