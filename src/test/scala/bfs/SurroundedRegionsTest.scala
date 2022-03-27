package bfs

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SurroundedRegionsTest extends AnyFunSuite {
  test("can flat surrounded regions") {
    val board = Array(
      Array('X', 'X', 'X', 'X'),
      Array('X', 'O', 'O', 'X'),
      Array('X', 'X', 'O', 'X'),
      Array('X', 'O', 'X', 'X')
    )
    SurroundedRegions.solve(board)
    board(0).toList shouldEqual List('X', 'X', 'X', 'X')
    board(1).toList shouldEqual List('X', 'X', 'X', 'X')
    board(2).toList shouldEqual List('X', 'X', 'X', 'X')
    board(3).toList shouldEqual List('X', 'O', 'X', 'X')
  }

  test("can not flat surrounded regions") {
    val board = Array(
      Array('X', 'X'),
      Array('X', 'X'),
    )
    SurroundedRegions.solve(board)
    board(0).toList shouldEqual List('X', 'X')
    board(1).toList shouldEqual List('X', 'X')
  }
}
