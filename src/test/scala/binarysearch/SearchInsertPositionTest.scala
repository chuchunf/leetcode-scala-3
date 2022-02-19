package binarysearch

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SearchInsertPositionTest extends AnyFunSuite {
  test("can find the element index") {
    val nums = Array(1, 2, 4, 5, 6, 7)
    val index = SearchInsertPosition.searchInsert(nums, 4)
    index shouldEqual 2
  }

  test("can find the index to insert") {
    val nums = Array(1, 2, 4, 5, 6, 7)
    val index = SearchInsertPosition.searchInsert(nums, 3)
    index shouldEqual 2
  }

  test("can find the element index out of rage") {
    val nums = Array(1, 2, 4, 5, 6, 7)
    val index = SearchInsertPosition.searchInsert(nums, 8)
    index shouldEqual 6
  }
}
