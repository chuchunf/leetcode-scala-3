package dfs

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class BinaryTreeUpsideDownTest extends AnyFunSuite {
  test("can upside down a binary tree") {
    val root = TreeNode(1)
    root.right = Option(TreeNode(3))
    val left = TreeNode(2)
    root.left = Option(left)
    left.left = Option(TreeNode(4))
    left.right = Option(TreeNode(5))
    var result = BinaryTreeUpsideDown.upsideDownBinaryTree(root)
    result.value shouldEqual 4
    result.left.get.value shouldEqual 5
    result = result.right.get
    result.value shouldEqual 2
    result.right.get.value shouldEqual 1
    result.left.get.value shouldEqual 3
  }
}
