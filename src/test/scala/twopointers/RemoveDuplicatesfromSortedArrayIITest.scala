package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class RemoveDuplicatesfromSortedArrayIITest extends AnyFunSuite {
  test("can remove duplicates from sorted array") {
    val nums = Array(1,1,1,2,2,3)
    val result = RemoveDuplicatesfromSortedArrayII.removeDuplicates(nums)
    result shouldEqual (5)
  }

  test("can remove duplicates from sorted array 2") {
    val nums = Array(0,0,1,1,1,1,2,3,3)
    val result = RemoveDuplicatesfromSortedArrayII.removeDuplicates(nums)
    result shouldEqual (7)
  }
}
