package tree

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ConstructBinaryTreefromInorderandPostorderTest extends AnyFunSuite {
  test("can construct tree") {
    val in = Array(9, 3, 15, 20, 7)
    val post = Array(9, 15, 7, 20, 3)
    var root = ConstructBinaryTreefromInorderandPostorder.buildTree(in, post)
    root.value shouldEqual (3)
    root.left.get.value shouldEqual (9)
    root = root.right.get
    root.value shouldEqual (20)
    root.right.get.value shouldEqual (7)
    root.left.get.value shouldEqual (15)
  }
}
