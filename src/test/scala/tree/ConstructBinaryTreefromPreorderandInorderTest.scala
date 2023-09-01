package tree

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ConstructBinaryTreefromPreorderandInorderTest extends AnyFunSuite {
  test("can construct tree") {
    val pre = Array(3, 9, 20, 15, 7)
    val in = Array(9, 3, 15, 20, 7)
    var root = ConstructBinaryTreefromPreorderandInorder.buildTree(pre, in)
    root.value shouldEqual 3
    root.left.get.value shouldEqual 9
    root = root.right.get
    root.value shouldEqual 20
    root.right.get.value shouldEqual 7
    root.left.get.value shouldEqual 15
  }
}
