package bit

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class GrayCodeTest extends AnyFunSuite {
  test("can handle 2") {
    val result = GrayCode.grayCode(2)
    result shouldEqual List(0, 1, 3, 2)
  }

  test("can handl 3") {
    val result = GrayCode.grayCode(3)
    result shouldEqual List(0, 1, 3, 2, 6, 7, 5, 4)
  }
}
