package array

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class RemoveDuplicatesfromSortedArrayTest extends AnyFunSuite {
  test("can remove duplicates") {
    val nums = Array(1, 1, 2, 2)
    val result = RemoveDuplicatesfromSortedArray.removeDuplicates(nums)
    result shouldEqual (2)
  }

  test("can remove duplicates with single element") {
    val nums = Array(1)
    val result = RemoveDuplicatesfromSortedArray.removeDuplicates(nums)
    result shouldEqual (1)
  }
}
