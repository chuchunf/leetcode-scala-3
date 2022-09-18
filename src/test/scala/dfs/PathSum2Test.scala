package dfs

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class PathSum2Test extends AnyFunSuite {
  test("can find path sum") {
    val root = TreeNode(5)
    val right = TreeNode(8)
    root.right = Option(right)
    right.left = Option(TreeNode(13))
    val right2 = TreeNode(4)
    right.right = Option(right2)
    right2.left = Option(TreeNode(5))
    right2.right = Option(TreeNode(1))
    val left = TreeNode(4)
    root.left = Option(left)
    val left2 = TreeNode(11)
    left.left = Option(left2)
    left2.left = Option(TreeNode(7))
    left2.right = Option(TreeNode(2))

    val result = PathSum2.pathSum(root, 22)
    result shouldEqual Array(Array(5, 4, 11, 2), Array(5, 8, 4, 5))
  }
}
