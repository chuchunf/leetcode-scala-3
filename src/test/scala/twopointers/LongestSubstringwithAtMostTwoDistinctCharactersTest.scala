package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class LongestSubstringwithAtMostTwoDistinctCharactersTest extends AnyFunSuite {
  test("can get longest substring") {
    val s = "eceba"
    val result = LongestSubstringwithAtMostTwoDistinctCharacters.lengthOfLongestSubstringTwoDistinct(s)
    result shouldEqual (3)
  }

  test("can get longest substring 2") {
    val s = "ccaabbb"
    val result = LongestSubstringwithAtMostTwoDistinctCharacters.lengthOfLongestSubstringTwoDistinct(s)
    result shouldEqual (5)
  }
}
