package binarysearch

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class FindMinimuminRotatedSortedArray2Test extends AnyFunSuite {
  test("can find min of rotated array") {
    val nums = Array(4, 5, 6, 7, 0, 1, 4)
    val result = FindMinimuminRotatedSortedArray2.findMin(nums)
    println(s"result=$result")
  }
}
