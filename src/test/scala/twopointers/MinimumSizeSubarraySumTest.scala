package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class MinimumSizeSubarraySumTest extends AnyFunSuite {
  test("can get invalid case") {
    val nums = Array(4, 3, 2)
    val result = MinimumSizeSubarraySum.minSubArrayLen(100, nums)
    result shouldEqual 0
  }

  test("can get miniszie for 1 element array -> sad case") {
    val nums = Array(2)
    val result = MinimumSizeSubarraySum.minSubArrayLen(4, nums)
    result shouldEqual 0
  }

  test("can get minsize") {
    val nums = Array(2,3,1,2,4,3)
    val result = MinimumSizeSubarraySum.minSubArrayLen(7, nums)
    result shouldEqual 2
  }

  test("can handle 1 elment array") {
    val nums = Array(10)
    val result = MinimumSizeSubarraySum.minSubArrayLen(7, nums)
    result shouldEqual 1
    val result2 = MinimumSizeSubarraySum.minSubArrayLen(20, nums)
    result2 shouldEqual 0
  }
}
