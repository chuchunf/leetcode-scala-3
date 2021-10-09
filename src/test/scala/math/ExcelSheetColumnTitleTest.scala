package math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ExcelSheetColumnTitleTest extends AnyFunSuite {
  test("can convert to 1 letter") {
    val result = ExcelSheetColumnTitle.convertToTitle(1)
    result shouldEqual ("A")
  }

  test("can convert big number") {
    val result = ExcelSheetColumnTitle.convertToTitle(2147483647)
    result shouldEqual ("FXSHRXW")
  }
}
