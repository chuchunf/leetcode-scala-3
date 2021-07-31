package tree

object BalancedBinaryTree {
  def isBalanced(root: TreeNode[Int]): Boolean = (root.left, root.right) match
    case (Some(left), Some(right)) => isBalanced(left) && isBalanced(right)
    case (Some(_), None) | (None, Some(_)) => false
    case _ => true
}
