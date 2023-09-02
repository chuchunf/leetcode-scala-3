# Depth first search
**Depth-first search (DFS)** is a **recursive** algorithm for searching a graph or tree data structure. 
The algorithm starts at the root (top) node of a tree and goes as far as it can down a given branch (path), 
then backtracks until it finds an unexplored path, and then explores it.

**Iterative Implementation of DFS is with a Stack**, to keep track of the nodes discovered along branches which helps in backtracking of the graph.
FIFO Stack is used as the most recently discovered nodes should be processed first.

### Usages
1. Topological sort
2. Cycle detection
3. Scheduling problems
4. Path finding 

### 112. Path Sum
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dfs/PathSum.scala#L6-L9

### 116. Populating Next Right Pointers in Each Node
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dfs/PopulatingNextRightPointersinEachNode.scala#L4-L17

### 129. Sum Root to Leaf Numbers
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dfs/SumRoottoLeafNumbers.scala#L6-L12

### 156. Binary Tree upside Down
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dfs/BinaryTreeUpsideDown.scala#L6-L14

### 113. Path Sum II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dfs/PathSum2.scala#L8-L21