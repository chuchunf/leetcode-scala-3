package tree

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class MaximumDepthofBinaryTreeTest extends AnyFunSuite {
  test("can get depth of root only") {
    val root = TreeNode(1)
    val result = MaximumDepthofBinaryTree.maxDepth(root)
    result shouldEqual 1
  }

  test("can get depth of a tree") {
    val left = new TreeNode(3, Option(TreeNode(4)), None)
    val root = new TreeNode(1, Option(left), Option(TreeNode(2)))
    val result = MaximumDepthofBinaryTree.maxDepth(root)
    result shouldEqual 3
  }

}
