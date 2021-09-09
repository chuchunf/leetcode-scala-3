package string

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class MinimumWindowSubstringTest extends AnyFunSuite {
  test("can find same string") {
    val s = "a"
    val t = "a"
    val result = MinimumWindowSubstring.minWindow(s, t)
    result shouldEqual ("a")
  }

  test("can not find when t is larger than s") {
    val s = "a"
    val t = "ab"
    val result = MinimumWindowSubstring.minWindow(s, t)
    result shouldEqual ("")
  }

  test("can find the min window") {
    val s = "ADOBECODEBANC"
    val t = "ABC"
    val result = MinimumWindowSubstring.minWindow(s, t)
    result shouldEqual ("BANC")
  }
}
