package tree

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class TreeNodeTest extends AnyFunSuite {
  test("can create a tree and print the tree structure") {
    val root = TreeNode(1)
    root.right = Option(TreeNode(2))
    root.left = Option(TreeNode(3))
    root.value shouldEqual (1)
    root.right.get.value shouldEqual (2)
    val output = root.toString
    output shouldEqual (
      """1
        |+   2
        |\   3
        |""".stripMargin)
  }
}
