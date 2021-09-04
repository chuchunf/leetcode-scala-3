package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MinimumPathSumTest extends AnyFunSuite {
  test("can get the min sum") {
    val nums = Array(Array(1, 3, 1), Array(1, 5, 1), Array(4, 2, 1))
    val result = MinimumPathSum.minPathSum(nums)
    result shouldEqual (7)
  }
}
