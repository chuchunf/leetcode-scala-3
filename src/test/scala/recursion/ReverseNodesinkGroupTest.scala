package recursion

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ReverseNodesinkGroupTest extends AnyFunSuite {
  test("can reverse in k groups") {
    val node = new LinkedListNode(1, None)
    node.append(2).append(3).append(4).append(5)
    var result = ReverseNodesinkGroup.reverseKGroup(node, 2)
    println(s"result=$result")
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
