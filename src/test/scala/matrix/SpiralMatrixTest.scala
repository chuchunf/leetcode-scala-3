package matrix

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SpiralMatrixTest extends AnyFunSuite {
  test("can transpose matrix") {
    val matrix = Array(Array(1, 2, 3, 4, 5), Array(6, 7, 8, 9, 10), Array(11, 12, 13, 14, 15))
    val result = SpiralMatrix.spiralOrder(matrix)
    result shouldEqual List(1, 2, 3, 4, 5, 10, 15, 14, 13, 12, 11, 6, 7, 8, 9)
  }
}
