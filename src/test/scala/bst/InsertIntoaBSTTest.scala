package bst

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._
import tree.TreeNode

class InsertIntoaBSTTest extends AnyFunSuite {
  test("can insert into bst") {
    val root = new TreeNode(4, Option(TreeNode(2)), Option(TreeNode(7)))
    val result = InsertIntoaBST.insertIntoBST(root, 5)
    result.right.get.value shouldEqual 7
    result.right.get.left.get.value shouldEqual 5
  }

  test("can insert into bst from another side") {
    val root = new TreeNode(4, Option(TreeNode(2)), Option(TreeNode(7)))
    val result = InsertIntoaBST.insertIntoBST(root, 3)
    result.right.get.value shouldEqual 7
    result.left.get.right.get.value shouldEqual 3
  }
}
