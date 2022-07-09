package backtracking

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class NQueens2Test extends AnyFunSuite {
  test("can find n-queens for 1") {
    NQueens2.totalNQueens(1) shouldEqual 1
  }

  test("can find n-queens for 2") {
    NQueens2.totalNQueens(2) shouldEqual 0
  }

  test("can find n-queens for 4") {
    NQueens2.totalNQueens(4) shouldEqual 2
  }
}
