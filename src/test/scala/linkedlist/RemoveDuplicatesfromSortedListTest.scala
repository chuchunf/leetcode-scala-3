package linkedlist

import array.RemoveDuplicatesfromSortedArray
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class RemoveDuplicatesfromSortedListTest extends AnyFunSuite {
  test("can remove duplicates") {
    val node = new LinkedListNode(1, None)
    node.append(1).append(2)
    val result = RemoveDuplicatesfromSortedList.deleteDuplicates(node)
    result.value shouldEqual (1)
    result.next.get.value shouldEqual (2)
  }

  test("can remove duplicates at end") {
    val node = new LinkedListNode(1, None)
    node.append(2).append(2)
    val result = RemoveDuplicatesfromSortedList.deleteDuplicates(node)
    result.value shouldEqual (1)
    result.next.get.value shouldEqual (2)
    result.next.get.next shouldEqual (None)
  }
}
