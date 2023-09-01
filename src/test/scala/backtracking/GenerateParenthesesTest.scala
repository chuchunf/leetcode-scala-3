package backtracking

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class GenerateParenthesesTest extends AnyFunSuite {
  test("can generate well formed parentheses") {
    val n = 3
    val result = GenerateParentheses.generateParenthesis(3)
    result shouldEqual List("((()))", "(()())", "(())()", "()(())", "()()()")
  }
}
