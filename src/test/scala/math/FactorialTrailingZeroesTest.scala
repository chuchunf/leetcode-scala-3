package math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

// 172. Factorial Trailing Zeroes
class FactorialTrailingZeroesTest extends AnyFunSuite {
  test("get for less than 5") {
    val result = FactorialTrailingZeroes.trailingZeroes(4)
    result shouldEqual 0
  }

  test("get for greater than 5") {
    val result = FactorialTrailingZeroes.trailingZeroes(100)
    result shouldEqual 24
  }
}
