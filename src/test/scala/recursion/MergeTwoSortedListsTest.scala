package recursion

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class MergeTwoSortedListsTest extends AnyFunSuite {
  test("can merge two list") {
    val list1 = new LinkedListNode(1, None)
    list1.append(3)
    val list2 = new LinkedListNode(2, None)
    list2.append(4)
    val result = MergeTwoSortedLists.mergeTwoLists(list1, list2)
    result.toList shouldEqual List(1, 2, 3, 4)
  }
}
