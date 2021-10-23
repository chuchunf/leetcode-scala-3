package matrix

object Searcha2DMatrix {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean =
    val (rows, cols) = (matrix.length, matrix(0).length)
    var (mini, maxi) = (0, rows * cols - 1)
    while mini <= maxi do
      val midi = mini + (maxi - mini) / 2
      if target > matrix(midi / cols)(midi % cols) then mini = midi + 1
      else if target < matrix(midi / cols)(midi % cols) then maxi = midi - 1
      else return true
    false
}
