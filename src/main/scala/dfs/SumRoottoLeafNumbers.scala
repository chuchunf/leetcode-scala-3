package dfs

import tree.TreeNode

object SumRoottoLeafNumbers {
  def sumNumbers(root: TreeNode[Int]): Int = _sumNumbers(root, 0)

  private def _sumNumbers(node: TreeNode[Int], preSum: Int): Int =
    val sum = preSum * 10 + node.value
    val left = if node.left.isDefined then _sumNumbers(node.left.get, sum) else 0
    val right = if node.right.isDefined then _sumNumbers(node.right.get, sum) else 0
    if left == 0 && right == 0 then sum else left + right
}
