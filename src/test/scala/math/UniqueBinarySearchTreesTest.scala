package math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class UniqueBinarySearchTreesTest extends AnyFunSuite {
  test("can get 3") {
    val result = UniqueBinarySearchTrees.numTrees(3)
    result shouldEqual (5)
  }

  test("can get 4") {
    val result = UniqueBinarySearchTrees.numTrees(4)
    result shouldEqual (14)
  }
}
