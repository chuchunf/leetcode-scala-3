package unionfind

object NumberofIslands {
  def numIslands(grid: Array[Array[Char]]): Int =
    val parent = Array.fill[Int](grid.length * grid(0).length)(-1)
    var count = 0
    for (i <- grid.indices; j <- grid(0).indices) {
      if grid(i)(j) == '1' then {
        parent(i * grid(0).length + j) = i * grid(0).length + j
        count = count + 1
      }
    }
    for (i <- grid.indices; j <- grid(0).indices) {
      if grid(i)(j) == '1' then {
        if j + 1 < grid(0).length && grid(i)(j + 1) == '1' && UF.union(i * grid(0).length + j, i * grid(0).length + j + 1, parent) then count = count - 1
        if i + 1 < grid.length && grid(i + 1)(j) == '1' && UF.union(i * grid(0).length + j, (i + 1) * grid(0).length + j, parent) then count = count - 1
      }
    }
    count
}
