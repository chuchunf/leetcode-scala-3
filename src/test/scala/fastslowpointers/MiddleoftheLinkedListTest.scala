package fastslowpointers

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class MiddleoftheLinkedListTest extends org.scalatest.funsuite.AnyFunSuite {
  test("can find the middle of the list") {
    val node = new LinkedListNode(1, None)
    node.append(2).append(3).append(4).append(5)
    val result = MiddleoftheLinkedList.middleNode(node)
    result.value shouldEqual (3)
  }
}
