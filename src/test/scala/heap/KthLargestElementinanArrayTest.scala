package heap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class KthLargestElementinanArrayTest extends AnyFunSuite {
  test("can find kth largest element in unique array") {
    val nums = Array(3, 2, 1, 5, 6, 4)
    val result = KthLargestElementinanArray.findKthLargest(nums, 2)
    result shouldEqual 5
  }

  test("can find kth largest element in non-unique array") {
    val nums = Array(3, 2, 3, 1, 2, 4, 5, 5, 6)
    val result = KthLargestElementinanArray.findKthLargest(nums, 4)
    result shouldEqual 4
  }
}
