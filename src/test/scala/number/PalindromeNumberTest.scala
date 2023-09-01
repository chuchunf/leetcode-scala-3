package number

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class PalindromeNumberTest extends AnyFunSuite {
  test("can verify single digit number") {
    PalindromeNumber.isPalindrome(5) shouldEqual true
  }

  test("can verify palindrome number") {
    PalindromeNumber.isPalindrome(919) shouldEqual true
  }

  test("can verify palindrome number - failure") {
    PalindromeNumber.isPalindrome(9191) shouldEqual false
  }
}
