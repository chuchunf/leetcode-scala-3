package stack

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class ValidParenthesesTest extends AnyFunSuite {
  test("can match parentheses ()") {
    val str="()"
    val result = ValidParentheses.isValid(str)
    result shouldEqual (true)
  }
}
