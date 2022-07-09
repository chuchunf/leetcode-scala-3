package backtracking

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class NQueensTest extends AnyFunSuite {
  test("can find 4 queens") {
    val result = NQueens.solveNQueens(4)
    result shouldEqual List(List(".Q..","...Q","Q...","..Q."), List("..Q.","Q...","...Q",".Q.."))
  }
}
