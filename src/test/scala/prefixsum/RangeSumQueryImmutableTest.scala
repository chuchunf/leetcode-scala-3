package prefixsum

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class RangeSumQueryImmutableTest extends AnyFunSuite {
  test("can query range sum") {
    val nums = Array(-2, 0, 3, -5, 2, -1)
    val query = new RangeSumQueryImmutable(nums)
    val result = query.sumRange(0, 2)
    result shouldEqual (1)
  }

  test("can query range sum in between") {
    val nums = Array(-2, 0, 3, -5, 2, -1)
    val query = new RangeSumQueryImmutable(nums)
    val result = query.sumRange(2, 5)
    result shouldEqual (-1)
  }
}
