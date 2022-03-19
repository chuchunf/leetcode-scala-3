package dfs

object PopulatingNextRightPointersinEachNode {
  def connect(root: Node[Int]): Node[Int] =
    _connect(root.left, root.right)
    root

  private def _connect(node: Option[Node[Int]], next: Option[Node[Int]]): Unit =
    if node.isDefined then {
      node.get.next = next
      _connect(node.get.left, node.get.right)
      _connect(node.get.right, next.get.left)
      _connect(next.get.left, next.get.right)
    }
}

sealed class Node[T](var value: T, var left: Option[Node[T]], var next: Option[Node[T]], var right: Option[Node[T]])