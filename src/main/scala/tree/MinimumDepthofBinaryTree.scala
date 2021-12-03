package tree

object MinimumDepthofBinaryTree {
  def minDepth(root: TreeNode[Int]): Int = (root.left, root.right) match
    case (Some(lnode), Some(rnode)) => 1 + minDepth(lnode).min(minDepth(rnode))
    case _ => 1
}
