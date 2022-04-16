package backtracking

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class LetterCombinationsofaPhoneNumberTest extends AnyFunSuite {
  test("can list all combinations") {
    val result = LetterCombinationsofaPhoneNumber.letterCombinations("23")
    result shouldEqual List("ad", "bd", "cd", "ae", "be", "ce", "af", "bf", "cf")
  }
}
