package linkedlist

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class ReverseListTest extends AnyFunSuite {
  test("can reverse a list with single element") {
    val node = new LinkedListNode(1, None)
    val result = ReverseList.reverseList(node)
    result.value shouldEqual 1
  }

  test("can reverse a list") {
    val node = new LinkedListNode(1, None)
    node.append(2).append(3).append(4)
    var current = ReverseList.reverseList(node)
    current.value shouldEqual 4
    current = current.next.get
    current.value shouldEqual 3
    current = current.next.get
    current.value shouldEqual 2
    current = current.next.get
    current.value shouldEqual 1
    current = current.next.get
  }
}
