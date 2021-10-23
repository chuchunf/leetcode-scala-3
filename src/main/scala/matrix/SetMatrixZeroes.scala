package matrix

object SetMatrixZeroes {
  def setZeroes(matrix: Array[Array[Int]]): Unit =
    var (row0, col0) = (false, false)
    for (r <- 0 until matrix.length; c <- 0 until matrix(0).length)
      if matrix(r)(c) == 0 then {
        matrix(0)(c) = 0
        matrix(r)(0) = 0
        if r == 0 then row0 = true
        if c == 0 then col0 = true
      }
    for (r <- 1 until matrix.length; c <- 1 until matrix(0).length)
      if matrix(0)(c) == 0 || matrix(r)(0) == 0 then matrix(r)(c) = 0
    if row0 then for (r <- 0 until matrix.length) matrix(r)(0) = 0
    if col0 then for (c <- 0 until matrix(0).length) matrix(0)(c) = 0
}
