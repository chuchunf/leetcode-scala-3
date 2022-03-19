Depth first search

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