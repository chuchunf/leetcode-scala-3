package matrix

import scala.collection.mutable

object SudokuSolver {
  def solveSudoku(board: Array[Array[Char]]): Unit =
    val (rows, cols, sqrs) = (List.fill(9)(mutable.HashSet[Char]()), List.fill(9)(mutable.HashSet[Char]()), List.fill(9)(mutable.HashSet[Char]()))
    for (r <- 0 until 9; c <- 0 until 9) addChar(r, c, board, board(r)(c), rows, cols, sqrs)
    solve(0, 0, board, rows, cols, sqrs)

  private def solve(r: Int, c: Int, board: Array[Array[Char]], rows: List[mutable.HashSet[Char]], cols: List[mutable.HashSet[Char]], sqrs: List[mutable.HashSet[Char]]): Boolean =
    board(r)(c) match
      case '.' => val valid = mutable.HashSet.from('1' to '9').subtractAll(rows(r)).subtractAll(cols(c)).subtractAll(sqrs((r / 3) * 3 + c / 3))
        valid.find { v =>
          if addChar(r, c, board, v, rows, cols, sqrs) && solveNext(r, c, board, rows, cols, sqrs) then true
          else removeChar(r, c, board, rows, cols, sqrs)
        }.isDefined
      case _ => solveNext(r, c, board, rows, cols, sqrs)

  private def addChar(r: Int, c: Int, board: Array[Array[Char]], v: Char, rows: List[mutable.HashSet[Char]], cols: List[mutable.HashSet[Char]], sqrs: List[mutable.HashSet[Char]]): Boolean =
    board(r)(c) = v
    rows(r).add(v)
    cols(c).add(v)
    sqrs((r / 3) * 3 + c / 3).add(v)
    true

  private def solveNext(r: Int, c: Int, board: Array[Array[Char]], rows: List[mutable.HashSet[Char]], cols: List[mutable.HashSet[Char]], sqrs: List[mutable.HashSet[Char]]): Boolean =
    (r, c) match
      case (row, col) if col < 8 => solve(row, col + 1, board, rows, cols, sqrs)
      case (row, col) if row < 8 => solve(row + 1, 0, board, rows, cols, sqrs)
      case _ => true

  private def removeChar(r: Int, c: Int, board: Array[Array[Char]], rows: List[mutable.HashSet[Char]], cols: List[mutable.HashSet[Char]], sqrs: List[mutable.HashSet[Char]]): Boolean =
    rows(r).remove(board(r)(c))
    cols(c).remove(board(r)(c))
    sqrs((r / 3) * 3 + c / 3).remove(board(r)(c))
    board(r)(c) = '.'
    false
}