# Graph
Graph algorithms are a set of instructions that traverse (visits nodes of a) graph.

Common operations with graph
1. detect a cycle in a directed graph
2. traversal of a graph 
3. find dependency of a graph => **Topological sort**, 
which simply involves running DFS on an entire graph and adding each node to the global ordering of nodes, 
but only after all of a node's children are visited (hence depth first). 
This ensures that parent nodes will be ordered before their child nodes, 
and honors the forward direction of edges in the ordering.

Some of the most common graph algorithms are:
- Breadth First Search (BFS)
- Depth First Search (DFS)
- Dijkstra 
- Floyd-Warshall Algorithm

### 207. Course Schedule
```scala
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
```

### 210. Course Schedule II
```scala
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
```