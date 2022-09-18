package graph

import scala.collection.mutable

object MinimumHeightTrees {
  def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] =
    val nodes = new Array[Node[Int]](n)
    for (i <- 0 until n) nodes(i) = Node(i)
    edges.foreach { p =>
      nodes(p(0)).neighbors.addOne(nodes(p(1)))
      nodes(p(1)).neighbors.addOne(nodes(p(0)))
    }
    val temp = nodes.foldLeft(mutable.HashMap[Int, mutable.HashSet[Int]]()) { case (result, node) =>
      result.getOrElseUpdate(_findMHT(node, mutable.HashSet[Int]()), mutable.HashSet[Int](node.value)).addOne(node.value)
      result
    }
    temp(temp.keys.min).toList

  private def _findMHT(node: Node[Int], visited: mutable.HashSet[Int]): Int =
    if visited.contains(node.value) then 0 else {
      visited.addOne(node.value)
      1 + node.neighbors.map(_findMHT(_, visited)).max
    }
}
