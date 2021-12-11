package tree

object ConstructBinaryTreefromPreorderandInorder {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode[Int] = _buildTree(preorder, inorder).get

  private def _buildTree(preorder: Array[Int], inorder: Array[Int]): Option[TreeNode[Int]] = preorder match
    case Array() => None
    case _ => val root = new TreeNode(preorder(0), None, None)
      val (lin, rin) = (inorder.slice(0, inorder.indexOf(preorder(0))), inorder.slice(inorder.indexOf(preorder(0)) + 1, inorder.length))
      val (lpr, rpr) = (preorder.slice(1, 1 + lin.length), preorder.slice(1 + lin.length, preorder.length))
      root.left = _buildTree(lpr, lin)
      root.right = _buildTree(rpr, rin)
      Option(root)
}
