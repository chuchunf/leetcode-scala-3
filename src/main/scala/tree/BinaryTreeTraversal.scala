package tree

import scala.collection.mutable

object BinaryTreeTraversal {
  def inorderTraversal(root: TreeNode[Int]): List[Int] =
    val result = mutable.ListBuffer[Int]()
    inorderinternal(root, result)
    result.toList

  private def inorderinternal(node: TreeNode[Int], cache: mutable.ListBuffer[Int]): Unit =
    if node.left.isDefined then inorderinternal(node.left.get, cache)
    cache.append(node.value)
    if node.right.isDefined then inorderinternal(node.right.get, cache)

  def preorderTraversal(root: TreeNode[Int]): List[Int] =
    val result = mutable.ListBuffer[Int]()
    preorderinternal(root, result)
    result.toList

  private def preorderinternal(node: TreeNode[Int], cache: mutable.ListBuffer[Int]): Unit =
    cache.append(node.value)
    if node.left.isDefined then preorderinternal(node.left.get, cache)
    if node.right.isDefined then preorderinternal(node.right.get, cache)

  def postorderTraversal(root: TreeNode[Int]): List[Int] =
    val result = mutable.ListBuffer[Int]()
    postorderinternal(root, result)
    result.toList

  private def postorderinternal(node: TreeNode[Int], cache: mutable.ListBuffer[Int]): Unit =
    if node.left.isDefined then postorderinternal(node.left.get, cache)
    if node.right.isDefined then postorderinternal(node.right.get, cache)
    cache.append(node.value)

  def levelOrder(root: TreeNode[Int]): List[List[Int]] =
    val result = mutable.ListBuffer[List[Int]]()
    var cache = mutable.ListBuffer[TreeNode[Int]](root)
    while !cache.isEmpty do
      val line = mutable.ListBuffer[Int]()
      val nextcache = mutable.ListBuffer[TreeNode[Int]]()
      cache.foreach(node => {
        line.append(node.value)
        if node.left.isDefined then nextcache.append(node.left.get)
        if node.right.isDefined then nextcache.append(node.right.get)
      })
      cache = nextcache
      result.append(line.toList)
    result.toList

  def zigzagLevelOrder(root: TreeNode[Int]): List[List[Int]] =
    val result = mutable.ListBuffer[List[Int]]()
    var (cache, zigzag) = (mutable.ListBuffer[TreeNode[Int]](root), true)
    while !cache.isEmpty do
      val line = mutable.ListBuffer[Int]()
      val nextcache = mutable.ListBuffer[TreeNode[Int]]()
      if zigzag then cache = cache.reverse
      zigzag = !zigzag
      cache.foreach(node => {
        line.append(node.value)
        if node.left.isDefined then nextcache.append(node.left.get)
        if node.right.isDefined then nextcache.append(node.right.get)
      })
      cache = nextcache
      result.append(line.toList)
    result.toList
}
