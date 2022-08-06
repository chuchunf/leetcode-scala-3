package unionfind

object NumberofIslands {
  def numIslands(grid: Array[Array[Char]]): Int =
    val parent = Array.fill[Int](grid.length * grid(0).length)(-1)
    var count = 0
    for (i <- 0 until grid.length; j <- 0 until grid(0).length) {
      if grid(i)(j) == '1' then {
        parent(i * grid(0).length + j) = i * grid(0).length + j
        count = count + 1
      }
    }
    for (i <- 0 until grid.length; j <- 0 until grid(0).length) {
      if grid(i)(j) == '1' then {
        if j + 1 < grid(0).length && grid(i)(j + 1) == '1' && union(i * grid(0).length + j, i * grid(0).length + j + 1, parent) then count = count - 1
        if i + 1 < grid.length && grid(i + 1)(j) == '1' && union(i * grid(0).length + j, (i + 1) * grid(0).length + j, parent) then count = count - 1
      }
    }
    count

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
