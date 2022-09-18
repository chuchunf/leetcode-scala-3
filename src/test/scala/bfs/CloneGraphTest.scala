package bfs

import graph.Node
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class CloneGraphTest extends AnyFunSuite {
  test("can clone graph") {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    node1.neighbors.addOne(node2)
    node1.neighbors.addOne(node4)
    node2.neighbors.addOne(node1)
    node2.neighbors.addOne(node3)
    node3.neighbors.addOne(node2)
    node3.neighbors.addOne(node4)
    node4.neighbors.addOne(node3)
    node4.neighbors.addOne(node1)

    val result = CloneGraph.cloneGraph(node1)
    result.value shouldEqual 1
    val rnode2 = result.neighbors(0)
    rnode2.value shouldEqual 2
    val rnode4 = result.neighbors(1)
    rnode4.value shouldEqual 4
    val rnode3 = rnode2.neighbors(1)
    rnode3.value shouldEqual 3
  }
}
