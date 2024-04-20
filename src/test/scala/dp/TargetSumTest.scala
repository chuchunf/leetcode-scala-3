package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldEqual

class TargetSumTest extends AnyFunSuite {
  test("can get sum") {
    val nums = Array(1, 1, 1, 1, 1)
    val target = 3
    val result = TargetSum.findTargetSumWays(nums, target)
    result shouldEqual 5
  }
}
