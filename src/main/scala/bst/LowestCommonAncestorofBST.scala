package bst

import tree.TreeNode

import scala.annotation.tailrec

object LowestCommonAncestorofBST {
  @tailrec
  def lowestCommonAncestor(root: TreeNode[Int], p: TreeNode[Int], q: TreeNode[Int]): TreeNode[Int] =
    if root.value > p.value && root.value > q.value then lowestCommonAncestor(root.left.get, p, q)
    else if root.value < p.value && root.value < q.value then lowestCommonAncestor(root.right.get, q, q)
    else root
}
