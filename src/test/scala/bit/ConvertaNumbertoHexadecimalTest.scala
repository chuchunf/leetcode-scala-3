package bit

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ConvertaNumbertoHexadecimalTest extends AnyFunSuite {
  test("can convert 0") {
    val result = ConvertaNumbertoHexadecimal.toHex(0)
    result shouldEqual "0"
  }

  test("can convert 26") {
    val result = ConvertaNumbertoHexadecimal.toHex(26)
    result shouldEqual "a1"
  }

  test("can convert -1") {
    val result = ConvertaNumbertoHexadecimal.toHex(-1)
    result shouldEqual "ffffffff"
  }
}
