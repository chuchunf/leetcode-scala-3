package binarysearch

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SearchinRotatedSortedArray2Test extends AnyFunSuite {
  test("can find index of sorted array") {
    val nums = Array(2, 5, 6, 0, 0, 1, 2)
    val result = SearchinRotatedSortedArray2.search(nums, 0)
    result shouldEqual true
  }

  test("can not find index of sorted array") {
    val nums = Array(2, 5, 6, 0, 0, 1, 2)
    val result = SearchinRotatedSortedArray2.search(nums, 4)
    result shouldEqual false
  }
}
