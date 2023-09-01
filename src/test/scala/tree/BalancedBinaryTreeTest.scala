package tree

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class BalancedBinaryTreeTest extends AnyFunSuite {
  test("can detect a not-balanced tree") {
    val root = TreeNode(1)
    root.left = Option(TreeNode(2))
    val result = BalancedBinaryTree.isBalanced(root)
    result shouldEqual false
  }

  test("can detect a balanced tree") {
    val root = TreeNode(1)
    root.left = Option(TreeNode(2))
    root.right = Option(TreeNode(3))
    val result = BalancedBinaryTree.isBalanced(root)
    result shouldEqual true
  }
}
