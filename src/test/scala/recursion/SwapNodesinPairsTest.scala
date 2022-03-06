package recursion

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SwapNodesinPairsTest extends AnyFunSuite {
  test("can swap pairs") {
    val list = new LinkedListNode(1, None)
    list.append(2).append(3).append(4)
    var result = SwapNodesinPairs.swapPairs(list)
    result.value shouldEqual 2
    result = result.next.get
    result.value shouldEqual 1
    result = result.next.get
    result.value shouldEqual 4
    result = result.next.get
    result.value shouldEqual 3
  }

  test("can swap pairs for odd number of nodes") {
    val list = new LinkedListNode(1, None)
    list.append(2).append(3).append(4).append(5)
    var result = SwapNodesinPairs.swapPairs(list)
    result.value shouldEqual 2
    result = result.next.get
    result.value shouldEqual 1
    result = result.next.get
    result.value shouldEqual 4
    result = result.next.get
    result.value shouldEqual 3
    result = result.next.get
    result.value shouldEqual 5
  }
}
