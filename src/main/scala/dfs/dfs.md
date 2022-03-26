# Depth first search

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