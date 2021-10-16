package array

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MoveZeroesTest extends AnyFunSuite {
  test("can move zeroes") {
    val nums = Array(0, 1, 0, 3, 12)
    MoveZeroes.moveZeroes(nums)
    nums shouldEqual (Array(1, 3, 12, 0, 0))
  }
}
