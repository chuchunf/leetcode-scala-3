package linkedlist

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class RotateListTest extends AnyFunSuite {
  test("can roate list") {
    val node = new LinkedListNode(1, None)
    node.append(2).append(3).append(4)
    var current = RotateList.rotateRight(node, 2)

    current.value shouldEqual 3
    current = current.next.get
    current.value shouldEqual 4
    current = current.next.get
    current.value shouldEqual 1
    current = current.next.get
    current.value shouldEqual 2
    current.next shouldEqual None
  }

  test("can roate list with k larger then length") {
    val node = new LinkedListNode(1, None)
    node.append(2).append(3).append(4)
    var current = RotateList.rotateRight(node, 6)

    current.value shouldEqual 3
    current = current.next.get
    current.value shouldEqual 4
    current = current.next.get
    current.value shouldEqual 1
    current = current.next.get
    current.value shouldEqual 2
    current.next shouldEqual None
  }
}
