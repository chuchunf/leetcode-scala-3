package bst

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._
import tree.TreeNode

class ValidateBinarySearchTreeTest extends AnyFunSuite {
  test("can detect a valid binary search tree") {
    val root = TreeNode(2)
    root.left = Option(TreeNode(1))
    root.right = Option(TreeNode(3))
    val result = ValidateBinarySearchTree.isValidBST(root)
    result shouldEqual true
  }

  test("can detect an invalid binary search tree") {
    val root = TreeNode(2)
    root.left = Option(TreeNode(1))
    val right = TreeNode(3)
    root.right = Option(right)
    right.right = Option(TreeNode(4))
    val result = ValidateBinarySearchTree.isValidBST(root)
    result shouldEqual false
  }
}
