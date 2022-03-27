package bfs

import tree.TreeNode

import scala.collection.mutable

object BinaryTreeRightSideView {
  def rightSideView(root: TreeNode[Int]): List[Int] =
    val result = mutable.ListBuffer[Int]()
    var queue = mutable.ListBuffer[TreeNode[Int]]().addOne(root)
    while !queue.isEmpty do {
      result.addOne(queue.last.value)
      val tmpqueue = mutable.ListBuffer[TreeNode[Int]]()
      while !queue.isEmpty do {
        val node = queue.remove(0)
        if node.left.isDefined then tmpqueue.addOne(node.left.get)
        if node.right.isDefined then tmpqueue.addOne(node.right.get)
      }
      queue = tmpqueue
    }
    result.toList
}
