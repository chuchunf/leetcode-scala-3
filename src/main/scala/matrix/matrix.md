# Matrix


### 54. Spiral Matrix
```scala
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] =
    val result = mutable.ListBuffer[Int]()
    val size = matrix.length * matrix(0).length
    var (left, right, top, bottom) = (0, matrix(0).length - 1, 0, matrix.length - 1)
    while (result.length < size)
      for (i <- left to right) if (result.length < size) result.append(matrix(top)(i)) // left to right, same top
      top = top + 1
      for (j <- top to bottom) if (result.length < size) result.append(matrix(j)(right)) // top to bottom, same right
      right = right - 1
      for (i <- right to left by -1) if (result.length < size) result.append(matrix(bottom)(i)) // right to left, same bottom
      bottom = bottom - 1
      for (j <- bottom to top by -1) if (result.length < size) result.append(matrix(j)(left)) // bottom to top, same left
      left = left + 1
    result.toList
```

### 36. Valid Sudoku
```scala
    val (rows, cols, sqrs) = (List.fill(9)(mutable.HashSet[Char]()), List.fill(9)(mutable.HashSet[Char]()), List.fill(9)(mutable.HashSet[Char]()))
    board.zipWithIndex.find { case (line, row) =>
      line.zipWithIndex.find {
        case ('.', _) => false
        case (char, col) => !rows(row).add(char) || !cols(col).add(char) || !sqrs((row / 3) * 3 + col / 3).add(char)
      }.isDefined
    }.isEmpty
```

### 37. Sudoku Solver
```scala
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
```

### 48. Rotate Image
```scala
  def rotate(matrix: Array[Array[Int]]): Unit =
    for (r <- 0 until matrix.length / 2; c <- 0 until matrix(0).length) swap(matrix, r, c, matrix.length - 1 - r, c)
    for (r <- 0 until (matrix.length - 1); c <- (r + 1) until matrix(0).length) swap(matrix, r, c, c, r)

  private def swap(matrix: Array[Array[Int]], r1: Int, c1: Int, r2: Int, c2: Int): Unit =
    val tmp = matrix(r1)(c1)
    matrix(r1)(c1) = matrix(r2)(c2)
    matrix(r2)(c2) = tmp
```