package monotonicstack

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*


class NextGreaterElementTest extends AnyFunSuite {
  test("can find with head not valid") {
    val nums1 = Array(4, 1, 2)
    val nums2 = Array(1, 3, 4, 2)
    val expected = Array(-1, 3, -1)
    val actual = NextGreaterElement.nextGreaterElement(nums1, nums2)
    actual shouldEqual expected
  }

  test("can find with end not valid") {
    val nums1 = Array(2, 4)
    val nums2 = Array(1, 2, 3, 4)
    val expected = Array(3, -1)
    val actual = NextGreaterElement.nextGreaterElement(nums1, nums2)
    actual shouldEqual expected
  }
}
