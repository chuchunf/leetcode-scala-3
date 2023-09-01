package binarysearch

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class FindFirstAndLastPositionInSortedArrayTest extends AnyFunSuite {
  test("can find the 1st and last") {
    val nums = Array(5, 7, 7, 8, 8, 10)
    val result = FindFirstAndLastPositionInSortedArray.searchRange(nums, 8)
    result shouldEqual Array(3, 4)
  }

  test("can return -1 -1 if there is no valid result") {
    val nums = Array(5, 7, 7, 8, 8, 10)
    val result = FindFirstAndLastPositionInSortedArray.searchRange(nums, 6)
    result shouldEqual Array(-1, -1)
  }
}
