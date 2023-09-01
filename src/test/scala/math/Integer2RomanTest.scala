package math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class Integer2RomanTest extends AnyFunSuite {
  test("can convert 1994") {
    val num = 1994
    val result = Integer2Roman.intToRoman(num)
    result shouldEqual "MCMXCIV"
  }

  test("can convert 3") {
    val num = 3
    val result = Integer2Roman.intToRoman(num)
    result shouldEqual "III"
  }
}
