package tree

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class LowestCommonAncestorofaBinaryTreeTest extends AnyFunSuite {
  test("can find common ancestor of a parent-child") {
    val root = TreeNode(1)
    root.right = Option(TreeNode(3))
    val left = TreeNode(2)
    root.left = Option(left)
    left.left = Option(TreeNode(4))
    val result = LowestCommonAncestorofaBinaryTree.lowestCommonAncestor(root, TreeNode(2), TreeNode(4))
    result.value shouldEqual 2
  }

  test("can find common ancestor of a child-child") {
    val root = TreeNode(1)
    root.right = Option(TreeNode(3))
    val left = TreeNode(2)
    root.left = Option(left)
    left.left = Option(TreeNode(4))
    val result = LowestCommonAncestorofaBinaryTree.lowestCommonAncestor(root, TreeNode(2), TreeNode(3))
    result.value shouldEqual 1
  }
}
