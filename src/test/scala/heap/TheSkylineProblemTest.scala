package heap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class TheSkylineProblemTest extends AnyFunSuite {
  test("can find the sky line") {
    val buildings = Array(Array(0, 2, 3), Array(2, 5, 3))
    val result = TheSkylineProblem.getSkyline(buildings)
    result shouldEqual (List(List(0, 3), List(5, 0)))
  }
}
