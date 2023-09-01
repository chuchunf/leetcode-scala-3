package array

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class RotateArrayTest extends AnyFunSuite {
  test("can rotate array by reverse") {
    val nums = Array(1, 2, 3, 4, 5, 6, 7)
    RotateArray.rotate(nums, 3)
    nums shouldEqual Array(4, 5, 6, 7, 1, 2, 3)
  }
}
