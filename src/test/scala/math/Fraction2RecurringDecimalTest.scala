package math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class Fraction2RecurringDecimalTest extends AnyFunSuite {
  test("can handle large numerator") {
    val result = Fraction2RecurringDecimal.fractionToDecimal(2, 1)
    result shouldEqual ("2")
  }

  test("can handle smarl numerator") {
    val result = Fraction2RecurringDecimal.fractionToDecimal(1, 2)
    result shouldEqual ("0.5")
  }

  test("can handle repeating") {
    val result = Fraction2RecurringDecimal.fractionToDecimal(2, 3)
    result shouldEqual ("0.(6)")
  }
}
