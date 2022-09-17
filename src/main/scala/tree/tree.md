# Tree
A tree is an abstract data type representing a hierarchical structure, with a root node and subtrees of linked children nodes.
- Children nodes must be connected to exactly one parent, except for the root node, which has no parent.
- These constraints mean there are no cycles or loops.
- Each child can be treated like the root node of its own subtree => **recursion**

Tree and linked list
- It is like a 2d linked list so share some similarities
- Given its hierarchical structure, it works naturally with **recursion**

## Tips
- A **temp helper node** could be used to hold a particular node while transformation
- A **helper function** to take two nodes and/or a container to store results
- Instead of changing the value of the node, pointing to another node works naturally with recursion

## Common travels operations
- pre-order => root, left then right
- in order => left, root then right
- post order => left, right then root
- line order => line by line horizontally (with a list cache of the next level of nodes)
- zig zag order

## Other operations
- invert binary tree

## Common properties
- is a balanced tree
- is a symmetric tree
- max depth
- min depth

## Construction of tree
- Construct binary tree from in order and post order
- Construct binary tree from pre order and in order

## Type of trees
1. Binary trees, which constrain the number of children for each parent to exactly two.
2. Balanced trees, a binary tree in which the height of the left and right subtree of any node differ by not more than 1.
3. Binary search trees, a binary tree in which the left subtree contains key values less than the root, while the right subtree contains key values greater than the root
4. AVL trees, a self-balancing binary search tree

## Related Algorithms
1. Recursion
2. Depth-first search
3. Width-first search

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
    while cache.nonEmpty do
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
    while cache.nonEmpty do
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

### 111. Minimum Depth of Binary Tree
```scala
  def minDepth(root: TreeNode[Int]): Int = (root.left, root.right) match
    case (Some(lnode), Some(rnode)) => 1 + minDepth(lnode).min(minDepth(rnode))
    case _ => 1
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

### 114. Flatten Binary Tree to Linked List
```scala
  def flatten(root: TreeNode[Int]): Unit = (root.left, root.right) match
    case (None, None) =>
    case (None, Some(rnode)) => flatten(rnode)
    case (Some(lnode), None) => flatten(lnode)
      root.right = Option(lnode)
      root.left = None
    case (Some(lnode), Some(rnode)) =>
      flatten(rnode)
      flatten(lnode)
      root.right = Option(lnode)
      root.left = None
      var end = lnode
      while end.right.isDefined do end = end.right.get
      end.right = Option(rnode)
```

### 105. Construct Binary Tree from Preorder and Inorder Traversal
```scala
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode[Int] = _buildTree(preorder, inorder).get

  private def _buildTree(preorder: Array[Int], inorder: Array[Int]): Option[TreeNode[Int]] = preorder match
    case Array() => None
    case _ => val root = new TreeNode(preorder(0), None, None)
      val (lin, rin) = (inorder.slice(0, inorder.indexOf(preorder(0))), inorder.slice(inorder.indexOf(preorder(0)) + 1, inorder.length))
      val (lpr, rpr) = (preorder.slice(1, 1 + lin.length), preorder.slice(1 + lin.length, preorder.length))
      root.left = _buildTree(lpr, lin)
      root.right = _buildTree(rpr, rin)
      Option(root)
```

### 106. Construct Binary Tree from Inorder and Postorder Traversal
```scala
  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode[Int] = _buildTree(inorder, postorder).get

  private def _buildTree(inorder: Array[Int], postorder: Array[Int]): Option[TreeNode[Int]] = postorder match
    case Array() => None
    case _ => val root = new TreeNode(postorder.last, None, None)
      val (lin, rin) = (inorder.slice(0, inorder.indexOf(postorder.last)), inorder.slice(inorder.indexOf(postorder.last) + 1, postorder.length))
      val (lpr, rpr) = (postorder.slice(0, inorder.indexOf(postorder.last)), postorder.slice(inorder.indexOf(postorder.last), postorder.length - 1))
      root.left = _buildTree(lin, lpr)
      root.right = _buildTree(rin, rpr)
      Option(root)
```