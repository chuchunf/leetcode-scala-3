package bst

import tree.TreeNode

object DeleteNodeinaBST {
  def deleteNode(root: TreeNode[Int], key: Int): TreeNode[Int] = deleteNodeInternal(Option(root), key).get

  private def deleteNodeInternal(node: Option[TreeNode[Int]], key: Int): Option[TreeNode[Int]] =
    node match
      case None => return None
      case Some(n) if n.value < key => n.right = deleteNodeInternal(n.right, key)
      case Some(n) if n.value > key => n.left = deleteNodeInternal(n.left, key)
      case Some(n) => (n.left, n.right) match {
        case (None, None) => return None
        case (Some(_), None) => return n.right
        case (None, Some(_)) => return n.left
        case _ => var min = n.right
          while min.get.right.isDefined do min = min.get.right
          n.value = min.get.value
          n.right = deleteNodeInternal(n.right, n.value)
      }
    node
}
