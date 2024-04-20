package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldEqual

class LongestPalindromicSubsequenceTest extends AnyFunSuite {
  test("can get longest subsequence") {
    val s = "bbbab"
    val result = LongestPalindromicSubsequence.longestPalindromeSubseq(s)
    result shouldEqual 4
  }
}
