package unionfind

object NumberofProvinces {
  def findCircleNum(isConnected: Array[Array[Int]]): Int =
    var result = isConnected.length
    val parent = (0 until isConnected.length).toArray
    for (i <- 0 until isConnected.length; j <- 0 until isConnected.length) {
      if i != j && isConnected(i)(j) == 1 && UF.union(i, j, parent) then result = result - 1
    }
    result
}
