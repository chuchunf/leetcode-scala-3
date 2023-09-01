package linkedlist

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class CopyListwithRandomPointerTest extends AnyFunSuite {
  test("can copy list") {
    val node5 = new LinkedListWithPointer(5, None, None)
    val node4 = new LinkedListWithPointer(4, Option(node5), None)
    val node3 = new LinkedListWithPointer(3, Option(node4), None)
    val node2 = new LinkedListWithPointer(2, Option(node3), None)
    val node1 = new LinkedListWithPointer(1, Option(node2), None)
    node2.random = Option(node1)
    node4.random = Option(node3)
    node5.random = Option(node1)
    var result = CopyListwithRandomPointer.copyRandomList(node1)
    result.value shouldEqual 1
    result = result.next.get
    result.value shouldEqual 2
    result.random.get.value shouldEqual 1
    result = result.next.get
    result.value shouldEqual 3
    result = result.next.get
    result.value shouldEqual 4
    result.random.get.value shouldEqual 3
    result = result.next.get
    result.value shouldEqual 5
  }
}
