package dfs

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class PathSumTest extends AnyFunSuite {
  test("can find tree sum") {
    val root = TreeNode(1)
    root.right = Option(TreeNode(3))
    val left = TreeNode(2)
    root.left = Option(left)
    left.left = Option(TreeNode(4))
    left.right = Option(TreeNode(5))
    val result = PathSum.hasPathSum(root, 7)
    result shouldEqual true
  }

  test("can not find tree sum") {
    val root = TreeNode(1)
    root.right = Option(TreeNode(3))
    val left = TreeNode(2)
    root.left = Option(left)
    left.left = Option(TreeNode(4))
    left.right = Option(TreeNode(5))
    val result = PathSum.hasPathSum(root, 100)
    result shouldEqual false
  }
}
