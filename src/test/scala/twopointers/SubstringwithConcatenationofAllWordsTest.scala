package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import twopointers.SubstringwithConcatenationofAllWords

class SubstringwithConcatenationofAllWordsTest extends AnyFunSuite {
  test("can substring with all words") {
    val s = "barfoothefoobarman"
    val words = Array("foo","bar")
    val result = SubstringwithConcatenationofAllWords.findSubstring(s, words)
    result shouldEqual List(0, 9)
  }

  test("can not substring with all words") {
    val s = "wordgoodgoodgoodbestword"
    val words = Array("word","good","best","word")
    val result = SubstringwithConcatenationofAllWords.findSubstring(s, words)
    result shouldEqual List.empty[Int]
  }
}
