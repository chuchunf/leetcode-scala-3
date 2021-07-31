package bst

import tree.TreeNode

object InsertIntoaBST {
  def insertIntoBST(root: TreeNode[Int], value: Int): TreeNode[Int] =
    value.compareTo(root.value) match
      case 0 => throw IllegalArgumentException(s"value $value already exists in the tree")
      case 1 => root.right match {
        case None => root.right = Option(TreeNode(value))
        case Some(node) => insertIntoBST(node, value)
      }
      case -1 => root.left match {
        case None => root.left = Option(TreeNode(value))
        case Some(node) => insertIntoBST(node, value)
      }
    root
}
