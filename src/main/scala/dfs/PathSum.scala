package dfs

import tree.TreeNode

object PathSum {
  def hasPathSum(root: TreeNode[Int], targetSum: Int): Boolean =
    root.value == targetSum
      || (root.left.isDefined && hasPathSum(root.left.get, targetSum - root.value))
      || (root.right.isDefined && hasPathSum(root.right.get, targetSum - root.value))
}
