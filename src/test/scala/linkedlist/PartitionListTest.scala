package linkedlist

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class PartitionListTest extends AnyFunSuite {
  test("can partition the list") {
    val node = new LinkedListNode(1, None)
    node.append(4).append(3).append(2).append(5).append(2)
    var result = PartitionList.partition(node, 3)
    result.value shouldEqual 1
    result = result.next.get
    result.value shouldEqual 2
    result = result.next.get
    result.value shouldEqual 2
    result = result.next.get
    result.value shouldEqual 4
    result = result.next.get
    result.value shouldEqual 3
    result = result.next.get
    result.value shouldEqual 5
  }
}
