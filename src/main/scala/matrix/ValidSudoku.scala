package matrix

import scala.collection.mutable

object ValidSudoku {
  def isValidSudoku(board: Array[Array[Char]]): Boolean =
    val (rows, cols, sqrs) = (List.fill(9)(mutable.HashSet[Char]()), List.fill(9)(mutable.HashSet[Char]()), List.fill(9)(mutable.HashSet[Char]()))
    board.zipWithIndex.find { case (line, row) =>
      line.zipWithIndex.find {
        case ('.', _) => false
        case (char, col) => !rows(row).add(char) || !cols(col).add(char) || !sqrs((row / 3) * 3 + col / 3).add(char)
      }.isDefined
    }.isEmpty
}
