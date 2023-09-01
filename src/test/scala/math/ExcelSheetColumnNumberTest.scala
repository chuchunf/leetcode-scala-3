package math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ExcelSheetColumnNumberTest extends AnyFunSuite {
  test("can get A") {
    val result = ExcelSheetColumnNumber.titleToNumber("A")
    result shouldEqual 1
  }

  test("can get FXSHRXW") {
    val result = ExcelSheetColumnNumber.titleToNumber("FXSHRXW")
    result shouldEqual 2147483647
  }
}
