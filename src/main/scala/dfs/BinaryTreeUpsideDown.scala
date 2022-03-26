package dfs

import tree.TreeNode

object BinaryTreeUpsideDown {
  def upsideDownBinaryTree(root: TreeNode[Int]): TreeNode[Int] = (root.left, root.right) match
    case (Some(left), Some(right)) =>
      val result = if left.left.isDefined then upsideDownBinaryTree(left) else left
      left.left = Option(right)
      left.right = Option(root)
      root.left = None
      root.right = None
      result
    case (_, _) => root
}
