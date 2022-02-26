package binarysearch

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MedianofTwoSortedArraysTest extends AnyFunSuite {
  test("can find median of 2 sort array") {
    val nums1 = Array(1, 3, 5)
    val nums2 = Array(2, 4)
    val result = MedianofTwoSortedArrays.findMedianSortedArrays(nums1, nums2)
    result shouldEqual (3)
  }
}
