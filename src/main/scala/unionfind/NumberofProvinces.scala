package unionfind

object NumberofProvinces {
  def findCircleNum(isConnected: Array[Array[Int]]): Int =
    var result = isConnected.length
    val parent = isConnected.indices.toArray
    for (i <- isConnected.indices; j <- isConnected.indices) {
      if i != j && isConnected(i)(j) == 1 && UF.union(i, j, parent) then result = result - 1
    }
    result
}
