package tree

object MaximumDepthofBinaryTree {
  def maxDepth(root: TreeNode[Int]): Int = 1 + ((root.left, root.right) match {
    case (None, None) => 0
    case (Some(n), None) => maxDepth(n)
    case (None, Some(n)) => maxDepth(n)
    case (Some(n1), Some(n2)) => maxDepth(n1).max(maxDepth(n2))
  })
}
