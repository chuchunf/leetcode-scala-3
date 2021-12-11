package tree

object FlattenBinaryTreetoLinkedList {
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
}
