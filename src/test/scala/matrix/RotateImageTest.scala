package matrix

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class RotateImageTest extends AnyFunSuite {
  test("can rotate array of odd number row/col") {
    val matrix = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))
    RotateImage.rotate(matrix)
    matrix shouldEqual Array(Array(7, 4, 1), Array(8, 5, 2), Array(9, 6, 3))
  }

  test("can rotate array of even number row/col") {
    val matrix = Array(Array(5, 1, 9, 11), Array(2, 4, 8, 10), Array(13, 3, 6, 7), Array(15, 14, 12, 16))
    RotateImage.rotate(matrix)
    matrix shouldEqual Array(Array(15, 13, 2, 5), Array(14, 3, 4, 1), Array(12, 6, 8, 9), Array(16, 7, 10, 11))
  }
}
