package string

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class ZigZagConversionTest extends AnyFunSuite {
  test("can convert zigzag strings") {
    val s = "PAYPALISHIRING"
    val result = ZigZagConversion.convert(s, 3)
    result shouldEqual ("PAHNAPLSIIGYIR")
  }
}
