package linkedlist

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class ReorderListTest extends AnyFunSuite {
  test("can reorder list") {
    val head = new LinkedListNode[Int](1, None)
    head.append(2).append(3).append(4).append(5)
    ReorderList.reorderList(head)
    head.value shouldEqual (1)
    var next = head.next.get
    next.value shouldEqual (5)
    next = next.next.get
    next.value shouldEqual (2)
    next = next.next.get
    next.value shouldEqual (4)
    next = next.next.get
    next.value shouldEqual (3)
  }
}
