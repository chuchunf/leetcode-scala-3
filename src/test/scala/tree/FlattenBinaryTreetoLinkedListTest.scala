package tree

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class FlattenBinaryTreetoLinkedListTest extends AnyFunSuite {
  test("can flatten tree") {
    val left = new TreeNode(3, Option(TreeNode(4)), None)
    val root = new TreeNode(1, Option(left), Option(TreeNode(2)))
    println(s"root=$root")
    FlattenBinaryTreetoLinkedList.flatten(root)
    var node = root
    node.left shouldEqual (None)
    node = node.right.get
    node.value shouldEqual (3)
    node.left shouldEqual (None)
    node = node.right.get
    node.value shouldEqual (4)
    node.left shouldEqual (None)
    node = node.right.get
    node.value shouldEqual (2)
  }
}
