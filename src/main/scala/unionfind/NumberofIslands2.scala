package unionfind

object NumberofIslands2 {
  def numIslands(m: Int, n: Int, points: Array[Array[Int]]): Array[Int] =
    val parent = Array.fill[Int](m * n)(-1)
    var count = 0
    points.map { case Array(x, y, _*) =>
      val nid = x * m + y
      parent(nid) = nid
      count = count + 1
      if x - 1 >= 0 && parent((x - 1) * m + y) != (-1) && union(nid, (x - 1) * m + y, parent) then count = count - 1
      if x + 1 < m && parent((x + 1) * m + y) != (-1) && union(nid, (x + 1) * m + y, parent) then count = count - 1
      if y - 1 >= 0 && parent(x * m + y - 1) != (-1) && union(nid, x * m + y - 1, parent) then count = count - 1
      if y + x < n && parent(x * m + y + 1) != (-1) && union(nid, x * m + y + 1, parent) then count = count - 1
      count
    }

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
