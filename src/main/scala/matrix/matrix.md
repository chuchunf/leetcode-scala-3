# Matrix
Matrix are 2 or more dimensional arrays, similar to a one-dimensional array, but it can be visualised as a grid (or table) with rows and columns.

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
  def isValidSudoku(board: Array[Array[Char]]): Boolean =
    val (rows, cols, sqrs) = (List.fill(9)(mutable.HashSet[Char]()), List.fill(9)(mutable.HashSet[Char]()), List.fill(9)(mutable.HashSet[Char]()))
    !board.zipWithIndex.exists { case (line, row) =>
      line.zipWithIndex.exists {
        case ('.', _) => false
        case (char, col) => !rows(row).add(char) || !cols(col).add(char) || !sqrs((row / 3) * 3 + col / 3).add(char)
      }
    }
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
        valid.exists { v =>
          if addChar(r, c, board, v, rows, cols, sqrs) && solveNext(r, c, board, rows, cols, sqrs) then true
          else removeChar(r, c, board, rows, cols, sqrs)
        }
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
      case (row, _) if row < 8 => solve(row + 1, 0, board, rows, cols, sqrs)
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
    for (r <- 0 until matrix.length / 2; c <- matrix(0).indices) swap(matrix, r, c, matrix.length - 1 - r, c)
    for (r <- 0 until (matrix.length - 1); c <- (r + 1) until matrix(0).length) swap(matrix, r, c, c, r)

  private def swap(matrix: Array[Array[Int]], r1: Int, c1: Int, r2: Int, c2: Int): Unit =
    val tmp = matrix(r1)(c1)
    matrix(r1)(c1) = matrix(r2)(c2)
    matrix(r2)(c2) = tmp
```

### 59. Spiral Matrix II
```scala
  def generateMatrix(n: Int): Array[Array[Int]] =
    val result = Array.ofDim[Int](n, n)
    var (i, top, bottom, left, right) = (1, 0, n - 1, 0, n - 1)
    while i <= n * n do {
      for (j <- left to right if i <= n * n) { result(top)(j) = i; i = i + 1 }
      top = top + 1
      for (j <- top to bottom if i <= n * n) { result(j)(right) = i; i = i + 1 }
      right = right - 1
      for (j <- right to left by -1 if i <= n * n) { result(bottom)(j) = i; i = i + 1 }
      bottom = bottom - 1
      for (j <- bottom to top by -1 if i <= n * n) { result(j)(left) = i; i = i + 1 }
      left = left + 1
    }
    result
```

### 73. Set Matrix Zero
Use first column and first row to store the zero column; 
and first column and first row need to be handled specially 
```scala
  def setZeroes(matrix: Array[Array[Int]]): Unit =
    var (row0, col0) = (false, false)
    for (r <- matrix.indices; c <- matrix(0).indices)
      if matrix(r)(c) == 0 then {
        matrix(0)(c) = 0
        matrix(r)(0) = 0
        if r == 0 then row0 = true
        if c == 0 then col0 = true
      }
    for (r <- 1 until matrix.length; c <- 1 until matrix(0).length)
      if matrix(0)(c) == 0 || matrix(r)(0) == 0 then matrix(r)(c) = 0
    if row0 then for (r <- matrix.indices) matrix(r)(0) = 0
    if col0 then for (c <- matrix(0).indices) matrix(0)(c) = 0
```

### 74. Search a 2D Matrix
```scala
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean =
    val (rows, cols) = (matrix.length, matrix(0).length)
    var (mini, maxi) = (0, rows * cols - 1)
    while mini <= maxi do
      val midi = mini + (maxi - mini) / 2
      if target > matrix(midi / cols)(midi % cols) then mini = midi + 1
      else if target < matrix(midi / cols)(midi % cols) then maxi = midi - 1
      else return true
    false
```