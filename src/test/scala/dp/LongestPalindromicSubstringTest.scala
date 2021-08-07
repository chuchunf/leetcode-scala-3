package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class LongestPalindromicSubstringTest extends AnyFunSuite {
  test("can find the longest palindromic substring") {
    val s = "babad"
    val result = LongestPalindromicSubstring.longestPalindrome(s)
    result shouldEqual ("aba")
  }
}
