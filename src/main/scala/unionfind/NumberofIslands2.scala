package unionfind

object NumberofIslands2 {
  def numIslands(m: Int, n: Int, points: Array[Array[Int]]): Array[Int] =
    val parent = Array.fill[Int](m * n)(-1)
    var count = 0
    points.map { case Array(x, y, _*) =>
      val nid = x * m + y
      parent(nid) = nid
      count = count + 1
      if x - 1 >= 0 && parent((x - 1) * m + y) != (-1) && UF.union(nid, (x - 1) * m + y, parent) then count = count - 1
      if x + 1 < m && parent((x + 1) * m + y) != (-1) && UF.union(nid, (x + 1) * m + y, parent) then count = count - 1
      if y - 1 >= 0 && parent(x * m + y - 1) != (-1) && UF.union(nid, x * m + y - 1, parent) then count = count - 1
      if y + x < n && parent(x * m + y + 1) != (-1) && UF.union(nid, x * m + y + 1, parent) then count = count - 1
      count
    }
}
