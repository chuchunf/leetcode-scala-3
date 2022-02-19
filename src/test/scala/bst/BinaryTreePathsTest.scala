package bst

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class BinaryTreePathsTest extends AnyFunSuite {
  test("can find paths") {
    val root = TreeNode(4)
    root.right = Option(TreeNode(5))
    val left = TreeNode(2)
    root.left = Option(left)
    left.left = Option(TreeNode(1))
    left.right = Option(TreeNode(3))
    val result = BinaryTreePaths.binaryTreePaths(root)
    result shouldEqual List("4->2->1", "4->2->3", "4->5")
  }
}
