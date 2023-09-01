package backtracking

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class RegularExpressionMatchingTest extends AnyFunSuite {
  test("can not match aa / a") {
    val (s, p) = ("aa", "a")
    val result = RegularExpressionMatching.isMatch(s, p)
    result shouldEqual false
  }

  test("can match aa / a*") {
    val (s, p) = ("aa", "a*")
    val result = RegularExpressionMatching.isMatch(s, p)
    result shouldEqual true
  }

  test("can match ab / .*") {
    val (s, p) = ("ab", ".*")
    val result = RegularExpressionMatching.isMatch(s, p)
    result shouldEqual true
  }

  test("can match aab / c*a*b") {
    val (s, p) = ("aab", "c*a*b")
    val result = RegularExpressionMatching.isMatch(s, p)
    result shouldEqual true
  }

  test("can not match mississippi / mis*is*p*.") {
    val (s, p) = ("mississippi", "mis*is*p*.")
    val result = RegularExpressionMatching.isMatch(s, p)
    result shouldEqual false
  }
}
