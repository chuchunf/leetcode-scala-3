package bst

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class LowestCommonAncestorofBSTTest extends AnyFunSuite {
  test("can get lowest from left") {
    val root = TreeNode(4)
    root.right = Option(TreeNode(5))
    val left = TreeNode(2)
    root.left = Option(left)
    left.left = Option(TreeNode(1))
    left.right = Option(TreeNode(3))
    val result = LowestCommonAncestorofBST.lowestCommonAncestor(root, TreeNode(1), TreeNode(3))
    result.value shouldEqual 2
  }

  test("can get lowest in middle") {
    val root = TreeNode(4)
    root.right = Option(TreeNode(5))
    val left = TreeNode(2)
    root.left = Option(left)
    left.left = Option(TreeNode(1))
    left.right = Option(TreeNode(3))
    val result = LowestCommonAncestorofBST.lowestCommonAncestor(root, TreeNode(1), TreeNode(5))
    result.value shouldEqual 4
  }

  test("can get lowest with same side") {
    val root = TreeNode(4)
    root.right = Option(TreeNode(5))
    val left = TreeNode(2)
    root.left = Option(left)
    left.left = Option(TreeNode(1))
    left.right = Option(TreeNode(3))
    val result = LowestCommonAncestorofBST.lowestCommonAncestor(root, TreeNode(1), TreeNode(2))
    result.value shouldEqual 2
  }
}
