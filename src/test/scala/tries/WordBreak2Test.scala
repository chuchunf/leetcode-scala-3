package tries

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class WordBreak2Test extends AnyFunSuite {
  test("can break the words") {
    val s = "catsanddog"
    val words = List("cat","cats","and","sand","dog")
    val result = WordBreak2.wordBreak(s, words)
    result shouldEqual (List("cat sand dog", "cats and dog"))
  }

  test("can not break the words") {
    val s = "catsandog"
    val words = List("cats","dog","sand","and","cat")
    val result = WordBreak2.wordBreak(s, words)
    result shouldEqual (List.empty[String])
  }
}
