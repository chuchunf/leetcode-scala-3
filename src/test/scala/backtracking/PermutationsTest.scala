package backtracking

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class PermutationsTest extends AnyFunSuite {
  test("can get all permutations") {
    val nums = Array(1, 2, 3)
    val result = Permutations.permute(nums)
    result shouldEqual (List(List(1, 2, 3), List(1, 3, 2), List(2, 1, 3), List(2, 3, 1), List(3, 1, 2), List(3, 2, 1)))
  }
}
