package string

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class LongestCommonPrefixTest extends AnyFunSuite {
  test("can get the longest common prefix string") {
    val strs = Array("flower", "flow", "flight")
    val result = LongestCommonPrefix.longestCommonPrefix(strs)
    result shouldEqual ("fl")
  }

  test("can return empty string if there is no common prefix") {
    val strs = Array("1flower", "2flow", "3flight")
    val result = LongestCommonPrefix.longestCommonPrefix(strs)
    result shouldEqual ("")
  }
}
