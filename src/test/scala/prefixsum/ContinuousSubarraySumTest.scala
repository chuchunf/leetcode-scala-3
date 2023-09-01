package prefixsum

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ContinuousSubarraySumTest extends AnyFunSuite {
  test("can find sub array") {
    val nums = Array(23, 2, 4, 6, 7)
    val result = ContinuousSubarraySum.checkSubarraySum(nums, 6)
    result shouldEqual true
  }

  test("can not find sub array") {
    val nums = Array(23, 2, 6, 4, 7)
    val result = ContinuousSubarraySum.checkSubarraySum(nums, 13)
    result shouldEqual false
  }
}
