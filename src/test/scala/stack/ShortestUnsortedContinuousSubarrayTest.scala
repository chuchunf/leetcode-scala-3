package stack

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class ShortestUnsortedContinuousSubarrayTest extends AnyFunSuite {
  test("can find the length of shortest unsorted sub array") {
    val nums = Array(2, 6, 4, 8, 10, 9, 15)
    val result = ShortestUnsortedContinuousSubarray.findUnsortedSubarray(nums)
    result shouldEqual 5
  }

  test("can handle sorted case") {
    val nums = Array(2, 3, 4, 8, 10, 15)
    val result = ShortestUnsortedContinuousSubarray.findUnsortedSubarray(nums)
    result shouldEqual 0
  }
}
