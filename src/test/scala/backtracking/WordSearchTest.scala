package backtracking

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class WordSearchTest extends AnyFunSuite {
  test("can find word") {
    val board = Array(Array('A', 'B', 'C', 'E'), Array('S', 'F', 'C', 'S'), Array('A', 'D', 'E', 'E'))
    val result = WordSearch.exist(board, "SEE")
    result shouldEqual true
  }

  test("can not find word") {
    val board = Array(Array('A', 'B', 'C', 'E'), Array('S', 'F', 'C', 'S'), Array('A', 'D', 'E', 'E'))
    val result = WordSearch.exist(board, "ABCB")
    result shouldEqual false
  }
}
