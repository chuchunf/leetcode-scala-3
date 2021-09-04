package array

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MergeSortedArrayTest extends AnyFunSuite {
  test("can merge sorted array") {
    var nums1 = Array(1, 2, 3, 0, 0, 0)
    var nums2 = Array(2, 5, 6)
    MergeSortedArray.merge(nums1, 3, nums2, 3)
    nums1 shouldEqual (Array(1, 2, 2, 3, 5, 6))
  }

  test("can merge sorted array with empty nums2") {
    var nums1 = Array(1)
    var nums2 = Array.empty[Int]
    MergeSortedArray.merge(nums1, 1, nums2, 0)
    nums1 shouldEqual (Array(1))
  }

  test("can merge sorted array with empty nums1") {
    var nums1 = Array(0)
    var nums2 = Array(1)
    MergeSortedArray.merge(nums1, 0, nums2, 1)
    nums1 shouldEqual (Array(1))
  }
}
