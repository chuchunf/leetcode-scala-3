package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class LengthOfLongestSubStringTest extends AnyFunSuite {
  test("can get longest sub string") {
    val s = "abcabcbb"
    val result = LengthOfLongestSubString.lengthOfLongestSubstring(s)
    result shouldEqual (3)
  }

  test("can handle empty string") {
    val s = ""
    val result = LengthOfLongestSubString.lengthOfLongestSubstring(s)
    result shouldEqual (0)
  }
}
