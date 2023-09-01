package counting

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class MajorityElement2Test extends AnyFunSuite {
  test("can find majorities") {
    val nums = Array(1, 1, 2, 2, 3)
    val result = MajorityElement2.majorityElement(nums)
    result shouldEqual List(1, 2)
  }

  test("can find majority") {
    val nums = Array(3, 2, 3)
    val result = MajorityElement2.majorityElement(nums)
    result shouldEqual List(3)
  }
}
