package bfs

import scala.collection.mutable

object SurroundedRegions {
  def solve(board: Array[Array[Char]]): Unit =
    val q = mutable.Queue[(Int, Int)]()
    board.zipWithIndex.foreach { case (line, x) =>
      line.zipWithIndex.foreach { case (char, y) =>
        if char == 'O' && (x == 0 || y == 0 || x == board.length - 1 || y == board(0).length - 1) then q.addOne((x, y))
      }
    }
    while !q.isEmpty do {
      val (x, y) = q.remove(0)
      board(x)(y) = '.'
      if (x - 1) >= 0 && board(x - 1)(y) == 'O' then q.addOne((x - 1, y))
      if (x + 1) < board.length && board(x + 1)(y) == 'O' then q.addOne(x + 1, y)
      if (y - 1) >= 0 && board(x)(y - 1) == 'O' then q.addOne((x, y - 1))
      if (y + 1) < board(0).length && board(x)(y + 1) == 'O' then q.addOne(x, y + 1)
    }
    board.zipWithIndex.foreach { case (line, x) =>
      line.zipWithIndex.foreach { case (char, y) =>
        if char == 'O' then board(x)(y) = 'X'
        if char == '.' then board(x)(y) = 'O'
      }
    }
}
