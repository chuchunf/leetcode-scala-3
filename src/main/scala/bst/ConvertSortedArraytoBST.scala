package bst

import tree.TreeNode

object ConvertSortedArraytoBST {
  def sortedArrayToBST(nums: Array[Int]): TreeNode[Int] = nums.length match
    case 1 => TreeNode[Int](nums(0))
    case 2 => new TreeNode[Int](nums(0), None, Option(TreeNode[Int](nums(1))))
    case len => val mid = len / 2
      new TreeNode[Int](nums(mid), Option(sortedArrayToBST(nums.slice(0, mid))), Option(sortedArrayToBST(nums.slice(mid + 1, nums.length))))
}
