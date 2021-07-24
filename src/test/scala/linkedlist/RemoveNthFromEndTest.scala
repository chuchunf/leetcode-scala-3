package linkedlist

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class RemoveNthFromEndTest extends AnyFunSuite {
  test("can remove nth node") {
    val node = new LinkedListNode(1, None)
    node.append(2).append(3).append(4)
    var result = RemoveNthFromEnd.removeNthFromEnd(node, 2)
    result.value shouldEqual(1)
    result = result.next.get
    result.value shouldEqual(2)
    result = result.next.get
    result.value shouldEqual(4)
  }

  test("can throw exception if n is larger than lenght of linkedlist") {
    val node = new LinkedListNode(1, None)
    node.append(2).append(3).append(4)
    assertThrows[IllegalArgumentException] {
      RemoveNthFromEnd.removeNthFromEnd(node, 5)
    }
  }

  test("can remove 1st node") {
    val node = new LinkedListNode(1, None)
    node.append(2).append(3).append(4)
    var result = RemoveNthFromEnd.removeNthFromEnd(node, 4)
    result.value shouldEqual(2)
    result = result.next.get
    result.value shouldEqual(3)
    result = result.next.get
    result.value shouldEqual(4)
  }

  test("can remove last node") {
    val node = new LinkedListNode(1, None)
    node.append(2).append(3).append(4)
    var result = RemoveNthFromEnd.removeNthFromEnd(node, 1)
    result.value shouldEqual(1)
    result = result.next.get
    result.value shouldEqual(2)
    result = result.next.get
    result.value shouldEqual(3)
  }
}
