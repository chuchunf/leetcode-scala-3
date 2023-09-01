package math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MaxPointsonaLineTest extends AnyFunSuite {
  test("can find 3 points") {
    val points = Array(Array(1, 1), Array(2, 2), Array(3, 3))
    val result = MaxPointsonaLine.maxPoints(points)
    result shouldEqual 3
  }

  test("can find 4 points") {
    val points = Array(Array(1, 1), Array(3, 2), Array(5, 3), Array(4, 1), Array(2, 3), Array(1, 4))
    val result = MaxPointsonaLine.maxPoints(points)
    result shouldEqual 4
  }
}
