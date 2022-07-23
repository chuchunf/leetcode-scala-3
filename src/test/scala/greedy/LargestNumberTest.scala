package greedy

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class LargestNumberTest extends AnyFunSuite {
  test("can get largest number") {
    val nums = Array(10, 2)
    val result = LargestNumber.largestNumber(nums)
    result shouldEqual "210"
  }

  test("can get largest number with random order") {
    val nums = Array(3, 30, 34, 5, 9)
    val result = LargestNumber.largestNumber(nums)
    result shouldEqual "9534330"
  }
}
