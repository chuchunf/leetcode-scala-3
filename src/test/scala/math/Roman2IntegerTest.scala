package math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class Roman2IntegerTest extends AnyFunSuite {
  test("can convert MCMXCIV") {
    val roman = "MCMXCIV"
    val result = Roman2Integer.romanToInt(roman)
    result shouldEqual 1994
  }

  test("can convert III") {
    val roman = "III"
    val result = Roman2Integer.romanToInt(roman)
    result shouldEqual 3
  }
}
