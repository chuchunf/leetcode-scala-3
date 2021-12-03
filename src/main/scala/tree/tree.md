# Tree
A tree is an abstract data type representing a hierarchical structure, with a root node and subtrees of linked children nodes.
- Given its hierarchical structure, it works naturally with recursion 
- It is like a 2d linked listed so share some similarities
- A temp node could be used to hold a particular node while transformation
- Instead of change the value of the node, pointing to another node works naturally with recursion 
- A helper function to take two nodes and/or a container to store results

### 144. Binary Tree Preorder Traversal
```scala
  def preorderTraversal(root: TreeNode[Int]): List[Int] =
    val result = mutable.ListBuffer[Int]()
    preorderinternal(root, result)
    result.toList

  private def preorderinternal(node: TreeNode[Int], cache: mutable.ListBuffer[Int]): Unit =
    cache.append(node.value)
    if node.left.isDefined then preorderinternal(node.left.get, cache)
    if node.right.isDefined then preorderinternal(node.right.get, cache)
```

### 94. Binary Tree Inorder Traversal
```scala
  def inorderTraversal(root: TreeNode[Int]): List[Int] =
    val result = mutable.ListBuffer[Int]()
    inorderinternal(root, result)
    result.toList

  private def inorderinternal(node: TreeNode[Int], cache: mutable.ListBuffer[Int]): Unit =
    if node.left.isDefined then inorderinternal(node.left.get, cache)
    cache.append(node.value)
    if node.right.isDefined then inorderinternal(node.right.get, cache)
```

### 145. Binary Tree Postorder Traversal
```scala
  def postorderTraversal(root: TreeNode[Int]): List[Int] =
    val result = mutable.ListBuffer[Int]()
    postorderinternal(root, result)
    result.toList

  private def postorderinternal(node: TreeNode[Int], cache: mutable.ListBuffer[Int]): Unit =
    if node.left.isDefined then postorderinternal(node.left.get, cache)
    if node.right.isDefined then postorderinternal(node.right.get, cache)
    cache.append(node.value)
```

### 102. Binary Tree Level Order Traversal
```scala
  def levelOrder(root: TreeNode[Int]): List[List[Int]] =
    val result = mutable.ListBuffer[List[Int]]()
    var cache = mutable.ListBuffer[TreeNode[Int]](root)
    while !cache.isEmpty do
      val line = mutable.ListBuffer[Int]()
      val nextcache = mutable.ListBuffer[TreeNode[Int]]()
      cache.foreach(node => {
        line.append(node.value)
        if node.left.isDefined then nextcache.append(node.left.get)
        if node.right.isDefined then nextcache.append(node.right.get)
      })
      cache = nextcache
      result.append(line.toList)
    result.toList
```

### 103. Binary Tree Zigzag Level Order Traversal
```scala
  def zigzagLevelOrder(root: TreeNode[Int]): List[List[Int]] =
    val result = mutable.ListBuffer[List[Int]]()
    var (cache, zigzag) = (mutable.ListBuffer[TreeNode[Int]](root), true)
    while !cache.isEmpty do
      val line = mutable.ListBuffer[Int]()
      val nextcache = mutable.ListBuffer[TreeNode[Int]]()
      if zigzag then cache = cache.reverse
      zigzag = !zigzag
      cache.foreach(node => {
        line.append(node.value)
        if node.left.isDefined then nextcache.append(node.left.get)
        if node.right.isDefined then nextcache.append(node.right.get)
      })
      cache = nextcache
      result.append(line.toList)
    result.toList
```

### 110. Balanced Binary Tree
```scala
  def isBalanced(root: TreeNode[Int]): Boolean = (root.left, root.right) match
    case (Some(left), Some(right)) => isBalanced(left) && isBalanced(right)
    case (Some(_), None) | (None, Some(_)) => false
    case _ => true
```

### 101. Symmetric Tree
```scala
  def isSymmetric(root: TreeNode[Int]): Boolean = isSymmeticInternal(root.left, root.right)

  private def isSymmeticInternal(left: Option[TreeNode[Int]], right: Option[TreeNode[Int]]): Boolean = (left, right) match
    case (None, None) => true
    case (Some(_), None) | (None, Some(_)) => false
    case (Some(n1), Some(n2)) => isSymmeticInternal(n1.right, n2.left) && isSymmeticInternal(n1.left, n2.right)
```

### 104. Maximum Depth of Binary Tree
```scala
  def maxDepth(root: TreeNode[Int]): Int = 1 + ((root.left, root.right) match {
    case (None, None) => 0
    case (Some(n), None) => maxDepth(n)
    case (None, Some(n)) => maxDepth(n)
    case (Some(n1), Some(n2)) => maxDepth(n1).max(maxDepth(n2))
  })
```

### 226. Invert Binary Tree
```scala
  def invertTree(root: TreeNode[Int]): TreeNode[Int] =
    (root.left, root.right) match {
      case (Some(left), Some(right)) =>
        root.left = Option(invertTree(right))
        root.right = Option(invertTree(left))
      case _ =>
    }
    root
```

### 236. Lowest Common Ancestor of a Binary Tree
```scala
  def lowestCommonAncestor(root: TreeNode[Int], p: TreeNode[Int], q: TreeNode[Int]): TreeNode[Int] =
    lowestCommonAncestorInternal(Option(root), Option(p), Option(q)).get

  private def lowestCommonAncestorInternal(root: Option[TreeNode[Int]], p: Option[TreeNode[Int]], q: Option[TreeNode[Int]]): Option[TreeNode[Int]] =
    (root, p, q) match
      case (None, _, _) => None
      case (Some(n1), Some(n2), Some(n3)) if n1.value == n2.value || n1.value == n3.value => root
      case (Some(n), _, _) =>
        val (left, right) = (lowestCommonAncestorInternal(n.left, p, q), lowestCommonAncestorInternal(n.right, p, q))
        (left, right) match
          case (Some(_), None) => left
          case (None, Some(_)) => right
          case (Some(_), Some(_)) => root
          case _ => None
```
