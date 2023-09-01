package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SummaryRangesTest extends AnyFunSuite {
  test("can get array range with break at end") {
    val nums = Array(0, 1, 2, 4, 5, 7)
    val result = SummaryRanges.summaryRanges(nums)
    result shouldEqual List("0->2", "4->5", "7")
  }

  test("can get array range with break at beginning") {
    val nums = Array(0, 2, 3, 4, 6, 8, 9)
    val result = SummaryRanges.summaryRanges(nums)
    result shouldEqual List("0", "2->4", "6", "8->9")
  }
}
