package backtracking

object WordSearch {
  def exist(board: Array[Array[Char]], word: String): Boolean =
    board.zipWithIndex.exists { case (line, i) =>
      line.zipWithIndex.exists { case (_, j) => _exist(board, i, j, word, 0) }
    }

  private def _exist(board: Array[Array[Char]], i: Int, j: Int, word: String, l: Int): Boolean =
    if l > word.length then false
    else if l == word.length then true else {
      if word.charAt(l) == board(i)(j) then {
        val tmp = board(i)(j)
        board(i)(j) = '.'
        val result = (if (i - 1) >= 0 && board(i - 1)(j) != '.' then _exist(board, i - 1, j, word, l + 1) else false)
          || (if (i + 1) < board.length && board(i + 1)(j) != '.' then _exist(board, i + 1, j, word, l + 1) else false)
          || (if (j - 1) >= 0 && board(i)(j - 1) != '.' then _exist(board, i, j - 1, word, l + 1) else false)
          || (if (j + 1) < board(0).length && board(i)(j + 1) != '.' then _exist(board, i, j + 1, word, l + 1) else false)
        board(i)(j) = tmp
        result
      } else false
    }
}
