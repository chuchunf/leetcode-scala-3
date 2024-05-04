package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldEqual

class ValidPalindrome4Test extends AnyFunSuite {
  test("can validate palindrome") {
    val s = "abcdba"
    val result = ValidPalindrome4.makePalindrome(s)
    result shouldEqual true
  }

  test("can invalidate palindrome") {
    val s = "abcdef"
    val result = ValidPalindrome4.makePalindrome(s)
    result shouldEqual false
  }
}
