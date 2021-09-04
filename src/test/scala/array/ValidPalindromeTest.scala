package array

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ValidPalindromeTest extends AnyFunSuite {
  test("can validate palindrome") {
    val s = "A man, a plan, a canal: Panama"
    val result = ValidPalindrome.isPalindrome(s)
    result shouldEqual (true)
  }

  test("can validate non palindrome") {
    val s = "race a car"
    val result = ValidPalindrome.isPalindrome(s)
    result shouldEqual (false)
  }
}
