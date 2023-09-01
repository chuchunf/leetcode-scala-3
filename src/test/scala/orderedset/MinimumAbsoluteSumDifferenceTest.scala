package orderedset

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MinimumAbsoluteSumDifferenceTest extends AnyFunSuite {
  test("can find MAS") {
    val nums1 = Array(1, 7, 5)
    val nums2 = Array(2, 3, 5)
    val result = MinimumAbsoluteSumDifference.minAbsoluteSumDiff(nums1, nums2)
    result shouldEqual 3
  }

  test("test find MAS for equal arrays") {
    val nums1 = Array(2, 4, 6, 8, 10)
    val nums2 = Array(2, 4, 6, 8, 10)
    val result = MinimumAbsoluteSumDifference.minAbsoluteSumDiff(nums1, nums2)
    result shouldEqual 0
  }

  test("test find MAS for long arrays") {
    val nums1 = Array(1, 10, 4, 4, 2, 7)
    val nums2 = Array(9, 3, 5, 1, 7, 4)
    val result = MinimumAbsoluteSumDifference.minAbsoluteSumDiff(nums1, nums2)
    result shouldEqual 20
  }
}
