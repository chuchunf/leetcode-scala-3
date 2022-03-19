package dfs

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class PopulatingNextRightPointersinEachNodeTest extends AnyFunSuite {
  test("can connect node") {
    val l21 = new Node[Int](4, None, None, None)
    val l22 = new Node[Int](5, None, None, None)
    val l23 = new Node[Int](6, None, None, None)
    val l24 = new Node[Int](7, None, None, None)

    val l11 = new Node(2, Option(l21), None, Option(l22))
    val l12 = new Node(3, Option(l23), None, Option(l24))

    val root = new Node(1, Option(l11), None, Option(l12))

    val result = PopulatingNextRightPointersinEachNode.connect(root)
    result.next shouldEqual None
    val left = result.left.get
    left.next.get.value shouldEqual 3
    val left2 = left.left.get
    left2.next.get.value shouldEqual 5
  }
}
