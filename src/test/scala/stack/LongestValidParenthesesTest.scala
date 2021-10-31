package stack

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import stack.MinStack

class LongestValidParenthesesTest extends AnyFunSuite {
  test("can find longest valid parenteses") {
    val result = LongestValidParentheses.longestValidParentheses("(()")
    result shouldEqual (2)
  }

  test("can find longest valid parenteses with 1st invalid char") {
    val result = LongestValidParentheses.longestValidParentheses(")()())")
    result shouldEqual (4)
  }
}
