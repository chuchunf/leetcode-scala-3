package recursion

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MergeKSortedListsTest extends AnyFunSuite {
  test("can merge to sorted list") {
    val node1 = new LinkedListNode(1, None)
    node1.append(4).append(5)
    val node2 = new LinkedListNode(1, None)
    node2.append(3).append(4)
    val node3 = new LinkedListNode(2, None)
    node3.append(6)

    val lists = Array(node1, node2, node3)
    var result = MergeKSortedLists.mergeKLists(lists)
    result.value shouldEqual 1
    result = result.next.get
    result.value shouldEqual 1
    result = result.next.get
    result.value shouldEqual 2
    result = result.next.get
    result.value shouldEqual 3
    result = result.next.get
    result.value shouldEqual 4
    result = result.next.get
    result.value shouldEqual 4
    result = result.next.get
    result.value shouldEqual 5
    result = result.next.get
    result.value shouldEqual 6
  }

  test("can merge to sorted list with pg") {
    val node1 = new LinkedListNode(1, None)
    node1.append(4).append(5)
    val node2 = new LinkedListNode(1, None)
    node2.append(3).append(4)
    val node3 = new LinkedListNode(2, None)
    node3.append(6)

    val lists = Array(node1, node2, node3)
    var result = MergeKSortedLists.mergeKLists2(lists)
    result.value shouldEqual 1
    result = result.next.get
    result.value shouldEqual 1
    result = result.next.get
    result.value shouldEqual 2
    result = result.next.get
    result.value shouldEqual 3
    result = result.next.get
    result.value shouldEqual 4
    result = result.next.get
    result.value shouldEqual 4
    result = result.next.get
    result.value shouldEqual 5
    result = result.next.get
    result.value shouldEqual 6
  }
}
