package binarysearch

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class SearchinRotatedSortedArrayTest extends AnyFunSuite {
  test("can find in a sorted array") {
    val nums = Array(0, 1, 2, 3, 4, 5, 6)
    val result = SearchinRotatedSortedArray.search(nums, 3)
    result shouldEqual (3)
  }

  test("can return -1 if could not find") {
    val nums = Array(0, 1, 2, 3, 5, 6, 7)
    val result = SearchinRotatedSortedArray.search(nums, 4)
    result shouldEqual (-1)
  }
}
