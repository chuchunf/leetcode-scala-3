package fastslowpointers

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class LinkedListCycleTest extends AnyFunSuite {
  test("can find linked list with cycle") {
    val node1 = new LinkedListNode(1, None)
    val node2 = new LinkedListNode(2, None)
    val node3 = new LinkedListNode(3, None)
    node1.next = Option(node2)
    node2.next = Option(node3)
    node3.next = Option(node1)
    val result = LinkedListCycle.hasCycle(node1)
    result shouldEqual true
  }

  test("can find linked list without cycle") {
    val node1 = new LinkedListNode(1, None)
    val node2 = new LinkedListNode(2, None)
    val node3 = new LinkedListNode(3, None)
    node1.next = Option(node2)
    node2.next = Option(node3)
    val result = LinkedListCycle.hasCycle(node1)
    result shouldEqual false
  }
}
