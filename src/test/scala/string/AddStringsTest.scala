package string

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class AddStringsTest extends AnyFunSuite {
  test("can add strings") {
    val num1 = "111"
    val num2 = "222"
    val result = AddStrings.addStrings(num1, num2)
    result shouldEqual ("333")
  }

  test("can add strings with diff length") {
    val num1 = "111"
    val num2 = "2222"
    val result = AddStrings.addStrings(num1, num2)
    result shouldEqual ("2333")
  }

  test("can add strings with carry") {
    val num1 = "1111"
    val num2 = "2229"
    val result = AddStrings.addStrings(num1, num2)
    result shouldEqual ("3340")
  }

  test("can add strings with additional digits") {
    val num1 = "1111"
    val num2 = "9000"
    val result = AddStrings.addStrings(num1, num2)
    result shouldEqual ("10111")
  }
}
