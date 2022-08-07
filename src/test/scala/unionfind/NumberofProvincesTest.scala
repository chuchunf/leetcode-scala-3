package unionfind

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class NumberofProvincesTest extends AnyFunSuite {
  test("can count number of connected provinces") {
    val isConnected = Array(Array(1, 1, 0), Array(1, 1, 0), Array(0, 0, 1))
    val result = NumberofProvinces.findCircleNum(isConnected)
    result shouldEqual 2
  }

  test("can count number of no connected provinces") {
    val isConnected = Array(Array(1, 0, 0), Array(0, 1, 0), Array(0, 0, 1))
    val result = NumberofProvinces.findCircleNum(isConnected)
    result shouldEqual 3
  }
}
