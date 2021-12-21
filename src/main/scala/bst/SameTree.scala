package bst

import tree.TreeNode

object SameTree {
  def isSameTree(p: TreeNode[Int], q: TreeNode[Int]): Boolean = _isSameTree(Option(p), Option(q))

  private def _isSameTree(p: Option[TreeNode[Int]], q: Option[TreeNode[Int]]): Boolean = (p, q) match
    case (None, None) => true
    case (None, Some(_)) | (Some(_), None) => false
    case (Some(rp), Some(rq)) => rp.value == rq.value && _isSameTree(rp.right, rq.right) && _isSameTree(rp.left, rq.left)
}
