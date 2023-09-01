package graph

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MinimumHeightTreesTest extends AnyFunSuite {
  test("can get MHT") {
    val edges = Array(Array(1, 0), Array(1, 2), Array(1, 3))
    val result = MinimumHeightTrees.findMinHeightTrees(4, edges)
    result shouldEqual List(1)
  }

  test("can get MHT 2") {
    val edges = Array(Array(3, 0), Array(3, 1), Array(3, 2), Array(3, 4), Array(5, 4))
    val result = MinimumHeightTrees.findMinHeightTrees(6, edges)
    result shouldEqual List(3, 4)
  }
}
