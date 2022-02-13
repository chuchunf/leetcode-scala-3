package bst

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class BinarySearchTreeIteratorTest extends AnyFunSuite {
  test("can iterate a BST") {
    val root = new TreeNode[Int](7, Option(TreeNode(3)), Option(new TreeNode[Int](15, Option(TreeNode(9)), Option(TreeNode(20)))))
    val iterator = new BinarySearchTreeIterator(root)
    iterator.next() shouldEqual 3
    iterator.next() shouldEqual 7
    iterator.next() shouldEqual 9
    iterator.next() shouldEqual 15
    iterator.next() shouldEqual 20
    iterator.hasNext() shouldEqual false
  }
}
