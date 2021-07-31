package tree

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class SymmetricTreeTest extends AnyFunSuite {
  test("can detect a valid case") {
    val root = new TreeNode(1, Option(TreeNode(2)), Option(TreeNode(3)))
    val result = SymmetricTree.isSymmetric(root)
    result shouldEqual (true)
  }

  test("can detect an invalid case") {
    val root = new TreeNode(1, Option(TreeNode(2)), None)
    val result = SymmetricTree.isSymmetric(root)
    result shouldEqual (false)
  }
}
