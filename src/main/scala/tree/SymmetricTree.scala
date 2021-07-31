package tree

object SymmetricTree {
  def isSymmetric(root: TreeNode[Int]): Boolean = isSymmeticInternal(root.left, root.right)

  private def isSymmeticInternal(left: Option[TreeNode[Int]], right: Option[TreeNode[Int]]): Boolean = (left, right) match
    case (None, None) => true
    case (Some(_), None) | (None, Some(_)) => false
    case (Some(n1), Some(n2)) => isSymmeticInternal(n1.right, n2.left) && isSymmeticInternal(n1.left, n2.right)
}
