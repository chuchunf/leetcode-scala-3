package tries

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class WordSearch2Test extends AnyFunSuite {
  test("can search all words") {
    val board = Array(Array('o', 'a', 'a', 'n'), Array('e', 't', 'a', 'e'), Array('i', 'h', 'k', 'r'), Array('i', 'f', 'l', 'v'))
    val words = Array("oath", "pea", "eat", "rain")
    val result = WordSearch2.findWords(board, words)
    result shouldEqual (List("oath", "eat"))
  }

  test("can find any words") {
    val board = Array(Array('a', 'b'), Array('c', 'd'))
    val words = Array("abcb")
    val result = WordSearch2.findWords(board, words)
    result shouldEqual (List.empty[String])
  }
}
