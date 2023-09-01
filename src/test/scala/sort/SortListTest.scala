package sort

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SortListTest extends AnyFunSuite {
  test("can sort the list") {
    val head = new LinkedListNode[Int](-1, None)
    head.append(5).append(3).append(4).append(0)
    var result = SortList.sortList(head)
    result.value shouldEqual 5
    result = result.next.get
    result.value shouldEqual 4
    result = result.next.get
    result.value shouldEqual 3
    result = result.next.get
    result.value shouldEqual 0
    result = result.next.get
    result.value shouldEqual -1
  }
}
