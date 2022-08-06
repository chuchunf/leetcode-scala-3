package unionfind

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class NumberofIslandsTest extends AnyFunSuite {
  test("can find 1 island") {
    val grid = Array(
      Array('1', '1', '1', '1', '0'),
      Array('1', '1', '0', '1', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '0', '0', '0')
    )
    val result = NumberofIslands.numIslands(grid)
    result shouldEqual 1
  }

  test("can find connected islands") {
    val grid = Array(
      Array('1', '1', '0', '0', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '1', '0', '0'),
      Array('0', '0', '0', '1', '1')
    )
    val result = NumberofIslands.numIslands(grid)
    result shouldEqual 3
  }
}
