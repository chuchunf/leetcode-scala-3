package number

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class ReverseIntegerTest extends AnyFunSuite {
  test("can reverse single digit number") {
    ReverseInteger.reverse(1) shouldEqual (1)
  }

  test("can reverse number with more than 1 digit") {
    ReverseInteger.reverse(198) shouldEqual (891)
  }
}
