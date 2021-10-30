package prefixsum

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class FindPivotIndexTest extends AnyFunSuite {
  test("can find the pivot index") {
    val nums = Array(1, 7, 3, 6, 5, 6)
    val result = FindPivotIndex.pivotIndex(nums)
    result shouldEqual (3)
  }

  test("can not find the pivot index") {
    val nums = Array(1, 2, 3)
    val result = FindPivotIndex.pivotIndex(nums)
    result shouldEqual (-1)
  }

  test("can find the pivot index at 0") {
    val nums = Array(2, 1, -1)
    val result = FindPivotIndex.pivotIndex(nums)
    result shouldEqual (0)
  }
}
