package linkedlist

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

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

  test("can get len from linked list node") {
    var node = new LinkedListNode(10, None)
    node.getLen() shouldEqual 1

    node = new LinkedListNode(10, Option(new LinkedListNode(9, None)))
    node.getLen() shouldEqual 2
  }

  test("can convert linked list to list") {
    val node = new LinkedListNode(10, Option(new LinkedListNode(9, None)))
    node.toList shouldEqual List(10, 9)
  }
}
