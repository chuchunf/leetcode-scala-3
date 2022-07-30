package graph

import scala.collection.mutable

object CourseSchedule {
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean =
    val nodes = new Array[Node[Int]](numCourses)
    for (i <- 0 until numCourses) nodes(i) = Node(i)
    prerequisites.foreach(p => nodes(p(0)).neighbors.addOne(nodes(p(1))))
    nodes.find(_canFinish(_, mutable.ListBuffer[Int]())).isEmpty

  private def _canFinish(node: Node[Int], visited: mutable.ListBuffer[Int]): Boolean =
    visited.contains(node.value) || {
      visited.addOne(node.value)
      node.neighbors.find(_canFinish(_, visited)).nonEmpty
    }
}
