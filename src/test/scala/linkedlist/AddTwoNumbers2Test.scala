package linkedlist

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class AddTwoNumbers2Test extends AnyFunSuite {
  test("can add two list with diff length") {
    val (l1, l2) = (new LinkedListNode(1, None), new LinkedListNode(2, None))
    l1.append(3).append(5)
    l2.append(4).append(6).append(8)
    var result = AddTwoNumbers2.addTwoNumbers(l1, l2)
    result.value shouldEqual 2
    result = result.next.get
    result.value shouldEqual 6
    result = result.next.get
    result.value shouldEqual 0
    result = result.next.get
    result.value shouldEqual 3
  }

  test("can add two list with diff length and carry") {
    val (l1, l2) = (new LinkedListNode(1, None), new LinkedListNode(9, None))
    l1.append(3).append(5)
    l2.append(9).append(6).append(8)
    var result = AddTwoNumbers2.addTwoNumbers(l1, l2)
    result.value shouldEqual 1
    result = result.next.get
    result.value shouldEqual 0
    result = result.next.get
    result.value shouldEqual 1
    result = result.next.get
    result.value shouldEqual 0
    result = result.next.get
    result.value shouldEqual 3
  }

}
