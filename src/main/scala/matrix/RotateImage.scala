package matrix

object RotateImage {
  def rotate(matrix: Array[Array[Int]]): Unit =
    for (r <- 0 until matrix.length / 2; c <- 0 until matrix(0).length) swap(matrix, r, c, matrix.length - 1 - r, c)
    for (r <- 0 until (matrix.length - 1); c <- (r + 1) until matrix(0).length) swap(matrix, r, c, c, r)

  private def swap(matrix: Array[Array[Int]], r1: Int, c1: Int, r2: Int, c2: Int): Unit =
    val tmp = matrix(r1)(c1)
    matrix(r1)(c1) = matrix(r2)(c2)
    matrix(r2)(c2) = tmp
}
