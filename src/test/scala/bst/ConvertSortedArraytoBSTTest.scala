package bst

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class ConvertSortedArraytoBSTTest extends AnyFunSuite {
  test("can covert 1 element array") {
    val nums = Array(1)
    val result = ConvertSortedArraytoBST.sortedArrayToBST(nums)
    result.value shouldEqual (1)
    result.left shouldEqual (None)
    result.right shouldEqual (None)
  }

  test("can covert 2 element array") {
    val nums = Array(1, 2)
    val result = ConvertSortedArraytoBST.sortedArrayToBST(nums)
    result.value shouldEqual (1)
    result.left shouldEqual (None)
    result.right.get.value shouldEqual (2)
  }

  test("can covert many element array") {
    val nums = Array(1, 2, 3, 4, 5)
    val result = ConvertSortedArraytoBST.sortedArrayToBST(nums)
    result.value shouldEqual (3)
    result.left.get.value shouldEqual (1)
    result.right.get.value shouldEqual (4)
  }
}
