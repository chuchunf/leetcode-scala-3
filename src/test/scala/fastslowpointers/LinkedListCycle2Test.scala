package fastslowpointers

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class LinkedListCycle2Test extends AnyFunSuite {
  test("can detect cycle and start node") {
    val node1 = new LinkedListNode(3, None)
    val node2 = new LinkedListNode(2, None)
    val node3 = new LinkedListNode(0, None)
    val node4 = new LinkedListNode(-4, None)
    node1.next = Option(node2)
    node2.next = Option(node3)
    node3.next = Option(node4)
    node4.next = Option(node2)
    val result = LinkedListCycle2.detectCycle(node1)
    result.get shouldEqual node2
  }

  test("can detect if there is no cycle") {
    val node1 = new LinkedListNode(3, None)
    val node2 = new LinkedListNode(2, None)
    val node3 = new LinkedListNode(0, None)
    val node4 = new LinkedListNode(-4, None)
    node1.next = Option(node2)
    node2.next = Option(node3)
    node3.next = Option(node4)
    val result = LinkedListCycle2.detectCycle(node1)
    result shouldEqual None
  }
}
