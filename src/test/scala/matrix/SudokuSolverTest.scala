package matrix

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SudokuSolverTest extends AnyFunSuite {
  test("can solve sudoku") {
    val board = Array(
      Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    SudokuSolver.solveSudoku(board)
    board shouldEqual (Array(
      Array('5', '3', '4', '6', '7', '8', '9', '1', '2'),
      Array('6', '7', '2', '1', '9', '5', '3', '4', '8'),
      Array('1', '9', '8', '3', '4', '2', '5', '6', '7'),
      Array('8', '5', '9', '7', '6', '1', '4', '2', '3'),
      Array('4', '2', '6', '8', '5', '3', '7', '9', '1'),
      Array('7', '1', '3', '9', '2', '4', '8', '5', '6'),
      Array('9', '6', '1', '5', '3', '7', '2', '8', '4'),
      Array('2', '8', '7', '4', '1', '9', '6', '3', '5'),
      Array('3', '4', '5', '2', '8', '6', '1', '7', '9')
    ))
  }
}
