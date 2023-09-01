package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class ImplementstrStrTest extends AnyFunSuite {
  test("can find hello/ll") {
    val haystack = "hello"
    val needle = "ll"
    val result = ImplementstrStr.strStr(haystack, needle)
    result shouldEqual 2
  }

  test("can not find aaaaa bba") {
    val haystack = "aaaaa"
    val needle = "bba"
    val result = ImplementstrStr.strStr(haystack, needle)
    result shouldEqual -1
  }
}
