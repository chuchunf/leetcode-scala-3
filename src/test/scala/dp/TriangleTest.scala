package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class TriangleTest extends AnyFunSuite {
  test("can find path simple") {
    val triangle = List(List(2), List(3, 4))
    val result = Triangle.minimumTotal(triangle)
    result shouldEqual 5
  }

  test("can find path") {
    val triangle = List(List(2), List(3, 4), List(6, 5, 7), List(4, 1, 8, 3))
    val result = Triangle.minimumTotal(triangle)
    result shouldEqual 11
  }
}
