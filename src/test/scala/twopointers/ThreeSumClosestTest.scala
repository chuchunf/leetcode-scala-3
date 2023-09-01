package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class ThreeSumClosestTest extends AnyFunSuite {
  test("can find the closest") {
    val nums = Array(-1, 2, 1, -4)
    val result = ThreeSumClosest.threeSumClosest(nums, 1)
    result shouldEqual 2
  }
}
