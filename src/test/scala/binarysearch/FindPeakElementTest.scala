package binarysearch

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class FindPeakElementTest extends AnyFunSuite {
  test("can find local peak in between") {
    val nums = Array(1, 2, 1, 3, 5, 6, 4)
    val result = FindPeakElement.findPeakElement(nums)
    result shouldEqual 5
  }

  test("can find local peak at edge") {
    val nums = Array(6, 5, 4, 3, 2)
    val result = FindPeakElement.findPeakElement(nums)
    result shouldEqual 0
  }
}
