package tree

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class InvertBinaryTreeTest extends AnyFunSuite {
  test("can invert a single node") {
    val root = TreeNode(1)
    val result = InvertBinaryTree.invertTree(root)
    result.value shouldEqual 1
    result.left shouldEqual None
    result.right shouldEqual None
  }

  test("can invert a tree") {
    val root = TreeNode(1)
    root.left = Option(TreeNode(2))
    root.right = Option(TreeNode(3))
    val result = InvertBinaryTree.invertTree(root)
    root.value shouldEqual 1
    root.left.get.value shouldEqual 3
    root.right.get.value shouldEqual 2
  }
}
