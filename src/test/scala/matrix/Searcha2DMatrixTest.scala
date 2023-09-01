package matrix

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class Searcha2DMatrixTest extends AnyFunSuite {
  test("can find target in 2d matrix") {
    val matrix = Array(Array(1, 3, 5, 7), Array(10, 11, 16, 20), Array(23, 30, 34, 60))
    val result = Searcha2DMatrix.searchMatrix(matrix, 3)
    result shouldEqual true
  }

  test("can not find target in 2d matrix") {
    val matrix = Array(Array(1, 3, 5, 7), Array(10, 11, 16, 20), Array(23, 30, 34, 60))
    val result = Searcha2DMatrix.searchMatrix(matrix, 13)
    println(s"result=$result")
    result shouldEqual false
  }
}
