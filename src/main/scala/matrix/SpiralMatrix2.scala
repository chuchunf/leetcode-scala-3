package matrix

object SpiralMatrix2 {
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
}
