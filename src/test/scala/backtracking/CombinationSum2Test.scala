package backtracking

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class CombinationSum2Test extends AnyFunSuite {
  test("can get all combinations") {
    val nums = Array(10, 1, 2, 7, 6, 1, 5)
    val result = CombinationSum2.combinationSum2(nums, 8)
    result shouldEqual (List(List(1, 1, 6), List(1, 2, 5), List(1, 7), List(2, 6)))
  }
}
