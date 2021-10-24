package dp

object DungeonGame {
  def calculateMinimumHP(dungeon: Array[Array[Int]]): Int =
    val result: Array[Array[Int]] = Array.ofDim[Int](dungeon.length, dungeon(0).length)
    for (row <- (dungeon.length - 1) to 0 by -1; col <- (dungeon(0).length - 1) to 0 by -1) {
      val need = (row, col) match
        case (r, c) if r == dungeon.length - 1 && c == dungeon(0).length - 1 => 1 - dungeon(row)(col)
        case (r, _) if r == dungeon.length - 1 => result(row)(col + 1) - dungeon(row)(col)
        case (_, c) if c == dungeon(0).length - 1 => result(row + 1)(col) - dungeon(row)(col)
        case (_, _) => result(row + 1)(col).min(result(row)(col + 1)) - dungeon(row)(col)
      result(row)(col) = if need <= 0 then 1 else need
    }
    result(0)(0)
}
