package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class TwoSumIITest extends AnyFunSuite {
  test("can get two sum") {
    val nums = Array(2, 7, 11, 15)
    val result = TwoSumII.twoSum(nums, 9)
    result shouldEqual (Array(1, 2))
  }
}
