package monotonicstack

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldEqual

class NextGreaterElement2Test extends AnyFunSuite {
  test("can get next greater element") {
    val nums = Array(1, 2, 1)
    val result = NextGreaterElement2.nextGreaterElements(nums)
    result shouldEqual Array(2, -1, 2)
  }

  test("can get next greater element 2") {
    val nums = Array(1, 2, 3, 4, 3)
    val result = NextGreaterElement2.nextGreaterElements(nums)
    result shouldEqual Array(2, 3, 4, -1, 4)
  }
}
