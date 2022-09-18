# Depth first search
**Depth-first search (DFS)** is a **recursive** algorithm for searching a graph or tree data structure. 
The algorithm starts at the root (top) node of a tree and goes as far as it can down a given branch (path), 
then backtracks until it finds an unexplored path, and then explores it.

**Iterative Implementation of DFS is with a Stack**, to keep track of the nodes discovered along branches which helps in backtracking of the graph.
FIFO Stack is used as the most recently discovered nodes should be processed first.

## Applications
1. Topological sort
2. Cycle detection
3. Scheduling problems
4. Path finding 

### 112. Path Sum
```scala
  def hasPathSum(root: TreeNode[Int], targetSum: Int): Boolean =
    root.value == targetSum
      || (root.left.isDefined && hasPathSum(root.left.get, targetSum - root.value))
      || (root.right.isDefined && hasPathSum(root.right.get, targetSum - root.value))
```

### 116. Populating Next Right Pointers in Each Node
```scala
  def connect(root: Node[Int]): Node[Int] =
    _connect(root.left, root.right)
    root

  private def _connect(node: Option[Node[Int]], next: Option[Node[Int]]): Unit =
    if node.isDefined then {
      node.get.next = next
      _connect(node.get.left, node.get.right)
      _connect(node.get.right, next.get.left)
      _connect(next.get.left, next.get.right)
    }
```

### 129. Sum Root to Leaf Numbers
```scala
  def sumNumbers(root: TreeNode[Int]): Int = _sumNumbers(root, 0)

  private def _sumNumbers(node: TreeNode[Int], preSum: Int): Int =
    val sum = preSum * 10 + node.value
    val left = if node.left.isDefined then _sumNumbers(node.left.get, sum) else 0
    val right = if node.right.isDefined then _sumNumbers(node.right.get, sum) else 0
    if left == 0 && right == 0 then sum else left + right
```

### 156. Binary Tree upside Down
```scala
  def upsideDownBinaryTree(root: TreeNode[Int]): TreeNode[Int] = (root.left, root.right) match
    case (Some(left), Some(right)) =>
      val result = if left.left.isDefined then upsideDownBinaryTree(left) else left
      left.left = Option(right)
      left.right = Option(root)
      root.left = None
      root.right = None
      result
    case (_, _) => root
```

### 113. Path Sum II
```scala
  def pathSum(root: TreeNode[Int], targetSum: Int): List[List[Int]] =
    val result = mutable.ListBuffer[List[Int]]()
    _pathSum(root, targetSum, mutable.ListBuffer[Int](), result)
    result.toList

  private def _pathSum(root: TreeNode[Int], target: Int, buffer: mutable.ListBuffer[Int], result: mutable.ListBuffer[List[Int]]): Unit =
    buffer.addOne(root.value)
    if root.value == target then {
      result.addOne(buffer.clone().toList)
    } else if root.value < target then {
      if root.left.isDefined then _pathSum(root.left.get, target - root.value, buffer, result)
      if root.right.isDefined then _pathSum(root.right.get, target - root.value, buffer, result)
    }
    buffer.remove(buffer.length - 1)
```