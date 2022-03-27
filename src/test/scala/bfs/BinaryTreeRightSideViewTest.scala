package bfs

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class BinaryTreeRightSideViewTest extends AnyFunSuite {
  test("can get the right side view") {
    val root = TreeNode(1)
    root.right = Option(TreeNode(3))
    val left = TreeNode(2)
    root.left = Option(left)
    left.left = Option(TreeNode(4))
    left.right = Option(TreeNode(5))
    val result = BinaryTreeRightSideView.rightSideView(root)
    result shouldEqual List(1, 3, 5)
  }
}
