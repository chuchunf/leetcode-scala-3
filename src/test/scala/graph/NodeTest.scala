package graph

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

import scala.collection.mutable

class NodeTest extends AnyFunSuite {
  test("can create node directly") {
    val n = new Node(1, mutable.ListBuffer[Node[Int]]())
    n.value shouldEqual 1
  }

  test("can create via object") {
    val n = Node(1)
    n.value shouldEqual 1
  }

  test("can check equality") {
    val n1 = new Node(1, mutable.ListBuffer[Node[Int]]())
    val n2 = Node(1)
    n1 shouldEqual n2
  }

  test("can create graph") {
    val data = Array(Array(2, 4), Array(1, 3), Array(2, 4), Array(1, 3))
    val node = Node.array2Node(data)
    node.value shouldEqual 0
    node.neighbors.length shouldEqual 2
    node.neighbors(0).value shouldEqual 1
    node.neighbors(1).value shouldEqual 3
  }

  test("can print a graph") {
    val data = Array(Array(2, 4), Array(1, 3), Array(2, 4), Array(1, 3))
    val node = Node.array2Node(data)
    println(node.toString)
  }

  test("can check deep equal") {
    val data = Array(Array(2, 4), Array(1, 3), Array(2, 4), Array(1, 3))
    val node1 = Node.array2Node(data)
    val node2 = Node.array2Node(data)
    node1.deepEquals(node2) shouldEqual true
  }
}
