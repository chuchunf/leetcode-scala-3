package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ThreeSumTest extends AnyFunSuite {
  test("can find all combination") {
    val nums = Array(-1, 0, 1, 2, -1, -4)
    val result = ThreeSum.threeSum(nums)
    result shouldEqual (Array(Array(-1, -1, 2), Array(-1, 0, 1)))
  }
}
