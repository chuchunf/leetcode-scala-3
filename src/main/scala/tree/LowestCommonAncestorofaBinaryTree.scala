package tree

object LowestCommonAncestorofaBinaryTree {
  def lowestCommonAncestor(root: TreeNode[Int], p: TreeNode[Int], q: TreeNode[Int]): TreeNode[Int] =
    lowestCommonAncestorInternal(Option(root), Option(p), Option(q)).get

  private def lowestCommonAncestorInternal(root: Option[TreeNode[Int]], p: Option[TreeNode[Int]], q: Option[TreeNode[Int]]): Option[TreeNode[Int]] =
    (root, p, q) match
      case (None, _, _) => None
      case (Some(n1), Some(n2), Some(n3)) if n1.value == n2.value || n1.value == n3.value => root
      case (Some(n), _, _) =>
        val (left, right) = (lowestCommonAncestorInternal(n.left, p, q), lowestCommonAncestorInternal(n.right, p, q))
        (left, right) match
          case (Some(_), None) => left
          case (None, Some(_)) => right
          case (Some(_), Some(_)) => root
          case _ => None
}
