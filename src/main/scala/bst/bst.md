# Binary Search Tree
Binary Search Tree is a node-based binary tree data structure which has the following properties:
- The left subtree of a node contains only nodes with keys lesser than the node’s key.
- The right subtree of a node contains only nodes with keys greater than the node’s key.
- The left and right subtree each must also be a binary search tree.

### 98. Validate Binary Search Tree
```scala
  def isValidBST(root: TreeNode[Int]): Boolean = (root.left, root.right) match
    case (Some(left), Some(right)) => left.value < root.value && root.value < right.value && isValidBST(left) && isValidBST(right)
    case (Some(_), None) | (None, Some(_)) => false
    case (None, None) => true
```

### 450. Delete Node in a BST
```scala
  def deleteNode(root: TreeNode[Int], key: Int): TreeNode[Int] = deleteNodeInternal(Option(root), key).get

  private def deleteNodeInternal(node: Option[TreeNode[Int]], key: Int): Option[TreeNode[Int]] =
    node match
      case None => return None
      case Some(n) if n.value < key => n.right = deleteNodeInternal(n.right, key)
      case Some(n) if n.value > key => n.left = deleteNodeInternal(n.left, key)
      case Some(n) => (n.left, n.right) match {
        case (None, None) => return None
        case (Some(_), None) => return n.right
        case (None, Some(_)) => return n.left
        case _ => var min = n.right
          while min.get.right.isDefined do min = min.get.right
          n.value = min.get.value
          n.right = deleteNodeInternal(n.right, n.value)
      }
    node
```

### 701. Insert into a Binary Search Tree
```scala
  def insertIntoBST(root: TreeNode[Int], value: Int): TreeNode[Int] =
    value.compareTo(root.value) match
      case 0 => throw IllegalArgumentException(s"value $value already exists in the tree")
      case 1 => root.right match {
        case None => root.right = Option(TreeNode(value))
        case Some(node) => insertIntoBST(node, value)
      }
      case -1 => root.left match {
        case None => root.left = Option(TreeNode(value))
        case Some(node) => insertIntoBST(node, value)
      }
    root
```

### 100. Same Tree
```scala
  def isSameTree(p: TreeNode[Int], q: TreeNode[Int]): Boolean = _isSameTree(Option(p), Option(q))

  private def _isSameTree(p: Option[TreeNode[Int]], q: Option[TreeNode[Int]]): Boolean = (p, q) match
    case (None, None) => true
    case (None, Some(_)) | (Some(_), None) => false
    case (Some(rp), Some(rq)) => rp.value == rq.value && _isSameTree(rp.right, rq.right) && _isSameTree(rp.left, rq.left)
```

### 108. Convert Sorted Array to Binary Search Tree
```scala
  def sortedArrayToBST(nums: Array[Int]): TreeNode[Int] = nums.length match
    case 1 => TreeNode[Int](nums(0))
    case 2 => new TreeNode[Int](nums(0), None, Option(TreeNode[Int](nums(1))))
    case len => val mid = len / 2
      new TreeNode[Int](nums(mid), Option(sortedArrayToBST(nums.slice(0, mid))), Option(sortedArrayToBST(nums.slice(mid + 1, nums.length))))
```
### 99. Recover Binary Search Tree
For a valid BST, the in order search will be sorted
```scala
  private var (first, second, prev): (Option[TreeNode[Int]], Option[TreeNode[Int]], Option[TreeNode[Int]]) = (None, None, None)

  def recoverTree(root: TreeNode[Int]): Unit =
    _traverse(root)
    val (firstElm, secondElm) = (first.get, second.get)
    val tmp = firstElm.value
    firstElm.value = secondElm.value
    secondElm.value = tmp

  private def _traverse(root: TreeNode[Int]): Unit =
    if root.left.isDefined then _traverse(root.left.get)
    if first.isEmpty && (prev.isDefined && prev.get.value > root.value) then first = Option(prev.get)
    if first.isDefined && (prev.isDefined && prev.get.value > root.value) then second = Option(root)
    prev = Option(root)
    if root.right.isDefined then _traverse(root.right.get)
```

### 173. Binary Search Tree Iterator
```scala
class BinarySearchTreeIterator(_root: TreeNode[Int]) {
  val _list = mutable.Stack[TreeNode[Int]]()
  private var _current = Option(_root)
  while _current.isDefined do {
    _list.push(_current.get)
    _current = _current.get.left
  }

  def next(): Int =
    val node = _list.pop()
    var curr = node.right
    while curr.isDefined do {
      _list.push(curr.get)
      curr = curr.get.left
    }
    node.value

  def hasNext(): Boolean = _list.nonEmpty
}
```

### 235. Lowest Common Ancestor of a Binary Search Tree
```scala
  def lowestCommonAncestor(root: TreeNode[Int], p: TreeNode[Int], q: TreeNode[Int]): TreeNode[Int] =
    if root.value > p.value && root.value > q.value then lowestCommonAncestor(root.left.get, p, q)
    else if root.value < p.value && root.value < q.value then lowestCommonAncestor(root.right.get, q, q)
    else root
```
