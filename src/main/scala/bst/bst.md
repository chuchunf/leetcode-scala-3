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