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
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/graph/CourseSchedule.scala#L6-L16

### 210. Course Schedule II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/graph/CourseSchedule2.scala#L6-L17

### 310. Minimum Height Trees
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/graph/MinimumHeightTrees.scala#L6-L23