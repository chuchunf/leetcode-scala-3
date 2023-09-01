package array

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class MinimumIncrementtoMakeArrayUniqueTest extends AnyFunSuite {
  test("can find the min increment") {
    val nums = Array(3, 2, 1, 2, 1, 7)
    val result = MinimumIncrementtoMakeArrayUnique.minIncrementForUnique(nums)
    result shouldEqual 6
  }
}
