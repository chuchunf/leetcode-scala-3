package string

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class AddBinaryTest extends AnyFunSuite {
  test("can add 11 and 1") {
    val result = AddBinary.addBinary("11", "1")
    result shouldEqual ("100")
  }

  test("can add 1010 and 1011") {
    val result = AddBinary.addBinary("1010", "1011")
    result shouldEqual ("10101")
  }
}
