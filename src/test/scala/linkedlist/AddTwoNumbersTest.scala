package linkedlist

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class AddTwoNumbersTest extends org.scalatest.funsuite.AnyFunSuite {
  test("can add two linked list - iterative approach") {
    val (l1, l2) = (new LinkedListNode(1, None), new LinkedListNode(2, None))
    l1.append(2).append(3)
    l2.append(3).append(4)
    val result = AddTwoNumbers.addTwoNumbers(l1, l2)
    result.value shouldEqual 3
    result.next.get.value shouldEqual 5
    result.next.get.next.get.value shouldEqual 7
  }

  test("can add two linked list with carry - iterative approach") {
    val (l1, l2) = (new LinkedListNode(9, None), new LinkedListNode(2, None))
    l1.append(2).append(3)
    l2.append(3).append(4)
    val result = AddTwoNumbers.addTwoNumbers(l1, l2)
    result.value shouldEqual 1
    result.next.get.value shouldEqual 6
    result.next.get.next.get.value shouldEqual 7
  }

  test("can add two linked list - recursive approach") {
    val (l1, l2) = (new LinkedListNode(1, None), new LinkedListNode(2, None))
    l1.append(2).append(3)
    l2.append(3).append(4)
    val result = AddTwoNumbers.addTwoNumbers2(l1, l2)
    result.value shouldEqual 3
    result.next.get.value shouldEqual 5
    result.next.get.next.get.value shouldEqual 7
  }

  test("can add two linked list with carry - recursive approach") {
    val (l1, l2) = (new LinkedListNode(9, None), new LinkedListNode(2, None))
    l1.append(2).append(3)
    l2.append(3).append(4)
    val result = AddTwoNumbers.addTwoNumbers2(l1, l2)
    result.value shouldEqual 1
    result.next.get.value shouldEqual 6
    result.next.get.next.get.value shouldEqual 7
  }

}
