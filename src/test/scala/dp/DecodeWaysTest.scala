package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class DecodeWaysTest extends AnyFunSuite {
  test("can decode two ways") {
    val s = "223"
    val result = DecodeWays.numDecodings(s)
    result shouldEqual (3)
  }
}
