package tree

object InvertBinaryTree {
  def invertTree(root: TreeNode[Int]): TreeNode[Int] =
    (root.left, root.right) match {
      case (Some(left), Some(right)) =>
        root.left = Option(invertTree(right))
        root.right = Option(invertTree(left))
      case _ =>
    }
    root
}
