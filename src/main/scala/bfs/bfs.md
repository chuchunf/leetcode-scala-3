# Breadth First Search
BFS is a traversing algorithm which starts from a selected node and traverse the graph layer-wise thus exploring the neighbour nodes (nodes which are directly connected to source node). 
Then move towards the next-level neighbour nodes. 
- A **queue** is used to enable the layer-wise traverse iteratively by keeping track of the child nodes that were encountered but not yet explored
- A recursive implementation could simply continue with the queue built at parent level

(Plain) Depth-first search, which explores the node branch as far as possible,
may get lost in an infinite branch and never make it to the solution node.

### Usages
1. Find the shortest path in tree or graph
2. Cycle detection in undirected graph
3. Path finding

### 127. Word Ladder
```scala
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bfs/WordLadder.scala#L6-L20

### 130. Surrounded Regions
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bfs/SurroundedRegions.scala#L6-L26

### 199. Binary Tree Right Side View
  https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bfs/BinaryTreeRightSideView.scala#L8-L21

### 133. Clone Graph
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bfs/CloneGraph.scala#L8-L26
