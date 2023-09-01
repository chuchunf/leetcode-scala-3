package tree

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MinimumDepthofBinaryTreeTest extends AnyFunSuite {
  test("can get min depth of no leaves") {
    val root = TreeNode(1)
    val depth = MinimumDepthofBinaryTree.minDepth(root)
    depth shouldEqual 1
  }

  test("can get min depth of 1 leaf") {
    val root = TreeNode(1)
    root.right = Option(TreeNode(2))
    val depth = MinimumDepthofBinaryTree.minDepth(root)
    depth shouldEqual 1
  }

  test("can get min depth") {
    val left = new TreeNode(3, Option(TreeNode(4)), None)
    val root = new TreeNode(1, Option(left), Option(TreeNode(2)))
    val depth = MinimumDepthofBinaryTree.minDepth(root)
    depth shouldEqual 2
  }
}
