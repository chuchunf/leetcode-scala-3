package bst

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class SameTreeTest extends AnyFunSuite {
  test("can match same tree") {
    val p = new TreeNode(1, Option(TreeNode(2)), Option(TreeNode(3)))
    val q = new TreeNode(1, Option(TreeNode(2)), Option(TreeNode(3)))
    val result = SameTree.isSameTree(p, q)
    result shouldEqual true
  }

  test("can not match diff tree") {
    val p = new TreeNode(1, None, Option(TreeNode(3)))
    val q = new TreeNode(1, Option(TreeNode(3)), None)
    val result = SameTree.isSameTree(p, q)
    result shouldEqual false
  }
}
