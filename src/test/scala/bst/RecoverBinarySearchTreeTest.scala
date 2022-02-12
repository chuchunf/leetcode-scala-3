package bst

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class RecoverBinarySearchTreeTest extends AnyFunSuite {
  test("can switch the tree") {
    val root = new TreeNode(1, Option(new TreeNode(3, None, Option(TreeNode(2)))), None)
    RecoverBinarySearchTree.recoverTree(root)
    root.value shouldEqual 3
    var node = root.left.get
    node.value shouldEqual 1
    node = node.right.get
    node.value shouldEqual 2
  }
}
