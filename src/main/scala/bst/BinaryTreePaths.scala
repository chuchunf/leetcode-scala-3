package bst

import tree.TreeNode

import scala.collection.mutable

object BinaryTreePaths {
  def binaryTreePaths(root: TreeNode[Int]): List[String] =
    val result = mutable.ListBuffer[String]()
    _addToPath(root, "", result)
    result.toList

  private def _addToPath(node: TreeNode[Int], tmp: String, result: mutable.ListBuffer[String]): Unit =
    if node.left.isEmpty && node.right.isEmpty then result.addOne(tmp + node.value)
    if node.left.isDefined then _addToPath(node.left.get, tmp + node.value + "->", result)
    if node.right.isDefined then _addToPath(node.right.get, tmp + node.value + "->", result)
}
