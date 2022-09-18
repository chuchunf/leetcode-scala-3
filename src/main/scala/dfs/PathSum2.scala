package dfs

import tree.TreeNode

import scala.collection.mutable

object PathSum2 {
  def pathSum(root: TreeNode[Int], targetSum: Int): List[List[Int]] =
    val result = mutable.ListBuffer[List[Int]]()
    _pathSum(root, targetSum, mutable.ListBuffer[Int](), result)
    result.toList

  private def _pathSum(root: TreeNode[Int], target: Int, buffer: mutable.ListBuffer[Int], result: mutable.ListBuffer[List[Int]]): Unit =
    buffer.addOne(root.value)
    if root.value == target then {
      result.addOne(buffer.clone().toList)
    } else if root.value < target then {
      if root.left.isDefined then _pathSum(root.left.get, target - root.value, buffer, result)
      if root.right.isDefined then _pathSum(root.right.get, target - root.value, buffer, result)
    }
    buffer.remove(buffer.length - 1)
}
