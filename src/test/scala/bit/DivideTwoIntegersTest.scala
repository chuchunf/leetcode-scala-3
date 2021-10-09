package bit

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class DivideTwoIntegersTest extends AnyFunSuite {
  test("can divide 10 by 3") {
    val result = DivideTwoIntegers.divide(10, 3)
    result shouldEqual (3)
  }

  test("can divide 100 by 3") {
    val result = DivideTwoIntegers.divide(100, 3)
    result shouldEqual (33)
  }
}
