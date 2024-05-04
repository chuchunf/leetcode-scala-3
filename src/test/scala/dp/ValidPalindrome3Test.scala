package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldEqual

class ValidPalindrome3Test extends AnyFunSuite {
  test("can find valid palindrome") {
    val s = "abcdeca"
    val k = 2
    val result = ValidPalindrome3.isPalindrome(s, k)
    result shouldEqual true
  }
}
