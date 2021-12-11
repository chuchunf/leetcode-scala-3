package tree

object ConstructBinaryTreefromInorderandPostorder {
  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode[Int] = _buildTree(inorder, postorder).get

  private def _buildTree(inorder: Array[Int], postorder: Array[Int]): Option[TreeNode[Int]] = postorder match
    case Array() => None
    case _ => val root = new TreeNode(postorder.last, None, None)
      val (lin, rin) = (inorder.slice(0, inorder.indexOf(postorder.last)), inorder.slice(inorder.indexOf(postorder.last) + 1, postorder.length))
      val (lpr, rpr) = (postorder.slice(0, inorder.indexOf(postorder.last)), postorder.slice(inorder.indexOf(postorder.last), postorder.length - 1))
      root.left = _buildTree(lin, lpr)
      root.right = _buildTree(rin, rpr)
      Option(root)
}
