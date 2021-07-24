package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class MinimumSizeSubarraySumTest extends AnyFunSuite {
  test("can get minsize for 1 element array") {
    val nums = Array(4)
    val result = MinimumSizeSubarraySum.minSubArrayLen(4, nums)
    result shouldEqual (1)
  }

  test("can get miniszie for 1 element array -> sad case") {
    val nums = Array(2)
    val result = MinimumSizeSubarraySum.minSubArrayLen(4, nums)
    result shouldEqual (0)
  }

  test("can get minsize") {
    val nums = Array(2,3,1,2,4,3)
    val result = MinimumSizeSubarraySum.minSubArrayLen(7, nums)
    result shouldEqual (2)
  }
}
