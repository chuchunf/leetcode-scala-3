package tree

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class BinaryTreeTraversalTest extends AnyFunSuite {
  def getTestData: TreeNode[Int] =
    val root = TreeNode(1)
    root.right = Option(TreeNode(3))
    val left = TreeNode(2)
    root.left = Option(left)
    left.left = Option(TreeNode(4))
    left.right = Option(TreeNode(5))
    root

  test("can do inorder traversal") {
    val root = getTestData
    val result = BinaryTreeTraversal.inorderTraversal(root)
    result shouldEqual (List(4, 2, 5, 1, 3))
  }

  test("can do preorder traversal") {
    val root = getTestData
    val result = BinaryTreeTraversal.preorderTraversal(root)
    result shouldEqual (List(1, 2, 4, 5, 3))
  }

  test("can do postorder traversal") {
    val root = getTestData
    val result = BinaryTreeTraversal.postorderTraversal(root)
    result shouldEqual (List(4, 5, 2, 3, 1))
  }

  test("can do levelorder traversal") {
    val root = getTestData
    val result = BinaryTreeTraversal.levelOrder(root)
    result shouldEqual (List(List(1), List(2, 3), List(4, 5)))
  }

  test("can do zigzag traversal") {
    val root = getTestData
    val result = BinaryTreeTraversal.zigzagLevelOrder(root)
    result shouldEqual (List(List(1), List(2, 3), List(5, 4)))
  }
}
