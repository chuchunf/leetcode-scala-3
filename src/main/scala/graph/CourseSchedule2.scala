package graph

import scala.collection.mutable

object CourseSchedule2 {
  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] =
    val nodes = new Array[Node[Int]](numCourses)
    for (i <- 0 until numCourses) nodes(i) = Node(i)
    prerequisites.foreach(p => nodes(p(0)).neighbors.addOne(nodes(p(1))))
    val (visited, cache) = (mutable.HashSet[Int](), mutable.ListBuffer[Int]())
    nodes.foreach(_findOrder(_, visited, cache))
    cache.toArray

  private def _findOrder(node: Node[Int], visited: mutable.HashSet[Int], cache: mutable.ListBuffer[Int]): Unit =
    visited.addOne(node.value)
    node.neighbors.foreach { n => if !visited.contains(n.value) then _findOrder(n, visited, cache) }
    cache.addOne(node.value)
}
