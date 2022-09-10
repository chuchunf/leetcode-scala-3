package prefixsum

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ContiguousArrayTest extends AnyFunSuite {
  test("can find contiguous array") {
    val nums = Array(0, 1, 0)
    val result = ContiguousArray.findMaxLength(nums)
    result shouldEqual 2
  }

  test("can find odd distributed contiguous array") {
    val nums = Array(0, 0, 0, 0, 0, 1, 1, 1, 1)
    val result = ContiguousArray.findMaxLength(nums)
    result shouldEqual 8
  }
}
