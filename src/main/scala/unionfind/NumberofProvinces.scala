package unionfind

object NumberofProvinces {
  def findCircleNum(isConnected: Array[Array[Int]]): Int =
    var result = isConnected.length
    val parent = (0 until isConnected.length).toArray
    for (i <- 0 until isConnected.length; j <- 0 until isConnected.length) {
      if i != j && isConnected(i)(j) == 1 && union(i, j, parent) then result = result - 1
    }
    result

  private def union(nid1: Int, nid2: Int, parent: Array[Int]): Boolean =
    val (pid1, pid2) = (find(nid1, parent), find(nid2, parent))
    pid1 != pid2 && {
      parent(pid1) = pid2
      true
    }

  private def find(nid: Int, parent: Array[Int]): Int =
    if parent(nid) == nid then nid else {
      parent(nid) = find(parent(nid), parent)
      parent(nid)
    }
}
