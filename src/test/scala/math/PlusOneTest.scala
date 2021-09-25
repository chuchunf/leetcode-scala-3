package math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class PlusOneTest extends AnyFunSuite {
  test("can plus 1") {
    val digits = Array(1, 2, 3)
    val result = PlusOne.plusOne(digits)
    result shouldEqual (Array(1, 2, 4))
  }

  test("can plus 1 with 9") {
    val digits = Array(1, 2, 9)
    val result = PlusOne.plusOne(digits)
    result shouldEqual (Array(1, 3, 0))
  }

  test("can plus 1 with 999") {
    val digits = Array(9, 9, 9)
    val result = PlusOne.plusOne(digits)
    result shouldEqual (Array(1, 0, 0, 0))
  }
}
