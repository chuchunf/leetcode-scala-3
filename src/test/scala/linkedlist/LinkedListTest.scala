package linkedlist

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class LinkedListTest extends AnyFunSuite {
  test("can create and append a LinkedListNode") {
    val node = new LinkedListNode(10, None)
    node.value shouldEqual (10)
    node.next shouldEqual (None)

    val next = node.append(20)
    node.value shouldEqual (10)
    next.value shouldEqual (20)
    next.next shouldEqual (None)
    node.next.get.value shouldEqual (20)
    node.next.get.next shouldEqual (None)
  }

  test("can create and append a LinkedList") {
    val node = new LinkedListNode(10, None)
    node.value shouldEqual (10)
    node.next shouldEqual (None)

    val ll = new LinkedList(node)
    ll.head.value shouldEqual (10)

    val next = new LinkedListNode(20, None)
    ll.append(next)
    ll.head.value shouldEqual (10)
    ll.head.next.get.value shouldEqual (20)
  }
}
