# Graph
A graph is a non-linear data structure consisting of a finite set of **vertices** (nodes/points), 
with a set of unordered pairs of these vertices for an **undirected graph** or a set of ordered pairs for a **directed graph**.
These pairs are known as **edges** (also called links or lines)

**Graph traversal** refers to the process of visiting (checking and/or updating) each vertex in a graph. 
- Breadth First Search (BFS)
- Depth First Search (DFS)

### The main differences between a graph and a tree
1. There could be cycle in graph but not in tree
2. Graph could be undirected, tree is always directed (from root to children)

### Usages
1. detect a cycle in a directed graph
2. traversal of a graph 
3. find dependency of a graph  

## Related algorithms
- **DFS/BFS**
- **Topological sort**  
  Simply involves running DFS on an entire graph and adding each node to the global ordering of nodes,
  but only after all of a node's children are visited (hence depth first).
  This ensures that parent nodes will be ordered before their child nodes,
  and honors the forward direction of edges in the ordering.
- **Union find**
- Dijkstra
- Floyd-Warshall Algorithm

### 207. Course Schedule
```scala
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean =
    val nodes = new Array[Node[Int]](numCourses)
    for (i <- 0 until numCourses) nodes(i) = Node(i)
    prerequisites.foreach(p => nodes(p(0)).neighbors.addOne(nodes(p(1))))
    !nodes.exists(_canFinish(_, mutable.HashSet[Int]()))

    private def _canFinish(node: Node[Int], visited: mutable.HashSet[Int]): Boolean =
      visited.contains(node.value) || {
        visited.addOne(node.value)
        node.neighbors.exists(_canFinish(_, visited))
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

### 310. Minimum Height Trees
```scala
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
```