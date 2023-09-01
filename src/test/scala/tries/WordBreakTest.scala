package tries

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class WordBreakTest extends AnyFunSuite {
  test("can break word") {
    val s = "leetcode"
    val words = List("leet", "code")
    val result = WordBreak.wordBreak(s, words)
    result shouldEqual true
  }

  test("can not break word") {
    val s = "catsandog"
    val words = List("cats", "dog", "sand", "and", "cat")
    val result = WordBreak.wordBreak(s, words)
    result shouldEqual false
  }
}
