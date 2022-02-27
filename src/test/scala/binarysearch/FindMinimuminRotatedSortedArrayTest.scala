package binarysearch

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class FindMinimuminRotatedSortedArrayTest extends AnyFunSuite {
  test("can find min in rotated array") {
    val nums = Array(4, 5, 6, 1, 2, 3)
    val result = FindMinimuminRotatedSortedArray.findMin(nums)
    result shouldEqual 1
  }

  test("can find min in normal array") {
    val nums = Array(1, 2, 3, 4, 5, 6)
    val result = FindMinimuminRotatedSortedArray.findMin(nums)
    result shouldEqual 1
  }
}
