package bst

import tree.TreeNode

object RecoverBinarySearchTree {
  private var (first, second, prev): (Option[TreeNode[Int]], Option[TreeNode[Int]], Option[TreeNode[Int]]) = (None, None, None)

  def recoverTree(root: TreeNode[Int]): Unit =
    _traverse(root)
    val (firstElm, secondElm) = (first.get, second.get)
    val tmp = firstElm.value
    firstElm.value = secondElm.value
    secondElm.value = tmp

  private def _traverse(root: TreeNode[Int]): Unit =
    if root.left.isDefined then _traverse(root.left.get)
    if first.isEmpty && (prev.isDefined && prev.get.value > root.value) then first = Option(prev.get)
    if first.isDefined && (prev.isDefined && prev.get.value > root.value) then second = Option(root)
    prev = Option(root)
    if root.right.isDefined then _traverse(root.right.get)
}
