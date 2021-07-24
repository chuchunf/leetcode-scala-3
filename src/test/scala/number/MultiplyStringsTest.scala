package number

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class MultiplyStringsTest extends AnyFunSuite {
  ignore("can calculate 1 digit mutiple 4 digits") {
    val num1 = "2468"
    val num2 = "3"
    val result = MultiplyStrings.multiply(num1, num2)
    result shouldEqual ("7404")
  }

  test("can calculate 2 digit mutiple 4 digits") {
    val num1 = "2468"
    val num2 = "32"
    val result = MultiplyStrings.multiply(num1, num2)
    result shouldEqual ("78976")
  }
}
