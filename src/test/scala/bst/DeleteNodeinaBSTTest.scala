package bst

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._
import tree.TreeNode

class DeleteNodeinaBSTTest extends AnyFunSuite {
  test("can delete node from tree") {
    val root = TreeNode(4)
    root.right = Option(TreeNode(5))
    val left = TreeNode(2)
    root.left = Option(left)
    left.left = Option(TreeNode(1))
    left.right = Option(TreeNode(3))

    val result = DeleteNodeinaBST.deleteNode(root, 2)
    result.left.get.value shouldEqual (3)
    result.left.get.left.get.value shouldEqual(1)
  }
}
