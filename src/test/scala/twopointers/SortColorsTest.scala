package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SortColorsTest extends AnyFunSuite {
  test("can sort colors") {
    val nums = Array(2, 0, 2, 1, 1, 0)
    SortColors.sortColors(nums)
    nums shouldEqual Array(0, 0, 1, 1, 2, 2)
  }
}
