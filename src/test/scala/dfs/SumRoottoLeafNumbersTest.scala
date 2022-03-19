package dfs

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class SumRoottoLeafNumbersTest extends AnyFunSuite {
  test("can sum root to left numbers") {
    val root = TreeNode(4)
    root.right = Option(TreeNode(0))
    val left = TreeNode(9)
    root.left = Option(left)
    left.left = Option(TreeNode(5))
    left.right = Option(TreeNode(1))
    val result = SumRoottoLeafNumbers.sumNumbers(root)
    result shouldEqual 1026
  }
}
