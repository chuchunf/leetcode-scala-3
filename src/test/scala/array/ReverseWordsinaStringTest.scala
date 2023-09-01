package array

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ReverseWordsinaStringTest extends AnyFunSuite {
  test("reverse words in a string") {
    val s = "the sky is blue"
    val result = ReverseWordsinaString.reverseWords(s)
    result shouldEqual "blue is sky the"
  }
}
