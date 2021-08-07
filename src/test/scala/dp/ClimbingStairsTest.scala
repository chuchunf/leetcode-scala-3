package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ClimbingStairsTest extends AnyFunSuite {
  test("can handle 2") {
    val result = ClimbingStairs.climbStairs(2)
    result shouldEqual (2)
  }

  test("can handle 3") {
    val result = ClimbingStairs.climbStairs(3)
    result shouldEqual (3)
  }
}
