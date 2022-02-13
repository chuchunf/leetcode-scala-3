package bst

import tree.TreeNode

import scala.collection.mutable

class BinarySearchTreeIterator(_root: TreeNode[Int]) {
  val _list = mutable.Stack[TreeNode[Int]]()
  private var _current = Option(_root)
  while _current.isDefined do {
    _list.push(_current.get)
    _current = _current.get.left
  }

  def next(): Int =
    val node = _list.pop()
    var curr = node.right
    while curr.isDefined do {
      _list.push(curr.get)
      curr = curr.get.left
    }
    node.value

  def hasNext(): Boolean = _list.nonEmpty
}
