package bfs

import graph.Node

import scala.collection.mutable

object CloneGraph {
  def cloneGraph(graph: Node[Int]): Node[Int] =
    val queue = mutable.Queue[Node[Int]]()
    val cache = mutable.HashMap[Int, Node[Int]]()
    val root = Node(graph.value)
    queue.enqueue(graph)
    cache(root.value) = root
    while queue.nonEmpty do {
      val node = queue.dequeue()
      val newnode = cache.getOrElse(node.value, Node(node.value))
      cache(node.value) = newnode
      node.neighbors.foreach { n =>
        if !cache.contains(n.value) then {
          cache(n.value) = Node(n.value)
          queue.enqueue(n)
        }
        newnode.neighbors.addOne(cache(n.value))
      }
    }
    root
}
