package stack

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import stack.MinStack

class DecodeStringTest extends AnyFunSuite {
  test("can decode string") {
    val s = "3[a]2[bc]"
    val result = DecodeString.decodeString(s)
    result shouldEqual "aaabcbc"
  }

  test("can decode nested string") {
    val s = "3[a2[c]]"
    val result = DecodeString.decodeString(s)
    result shouldEqual "accaccacc"
  }

  test("can decode string with literal at last") {
    val s = "2[abc]3[cd]ef"
    val result = DecodeString.decodeString(s)
    result shouldEqual "abcabccdcdcdef"
  }
}
