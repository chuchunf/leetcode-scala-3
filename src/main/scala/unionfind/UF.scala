package unionfind

object UF {
  def union(nid1: Int, nid2: Int, parent: Array[Int]): Boolean =
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
