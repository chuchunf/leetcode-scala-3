package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MaximumSubarrayTest extends AnyFunSuite {
  test("can find the max sub array") {
    val nums = Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val result = MaximumSubarray.maxSubArray(nums)
    result shouldEqual (6)
  }

  test("can find the max sub array case 2") {
    val nums = Array(5, 4, -1, 7, 8)
    val result = MaximumSubarray.maxSubArray(nums)
    result shouldEqual (23)
  }
}
