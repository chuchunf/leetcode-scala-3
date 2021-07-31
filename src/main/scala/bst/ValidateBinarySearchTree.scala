package bst

import tree.TreeNode

object ValidateBinarySearchTree {
  def isValidBST(root: TreeNode[Int]): Boolean = (root.left, root.right) match
    case (Some(left), Some(right)) => left.value < root.value && root.value < right.value && isValidBST(left) && isValidBST(right)
    case (Some(_), None) | (None, Some(_)) => false
    case (None, None) => true
}
