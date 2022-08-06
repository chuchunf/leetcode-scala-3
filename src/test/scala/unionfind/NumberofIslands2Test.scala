package unionfind

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class NumberofIslands2Test extends AnyFunSuite {
  test("can detect islands") {
    val points = Array(Array(0, 0), Array(0, 2), Array(0, 1), Array(2, 2))
    val result = NumberofIslands2.numIslands(3, 3, points)
    result shouldEqual Array(1, 2, 1, 2)
  }

  test("can detect connected islands") {
    val points = Array(Array(0, 0), Array(0, 1), Array(1, 2), Array(2, 1))
    val result = NumberofIslands2.numIslands(3, 3, points)
    result shouldEqual Array(1, 1, 2, 3)
  }
}
