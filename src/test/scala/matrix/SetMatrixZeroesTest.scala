package matrix

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SetMatrixZeroesTest extends AnyFunSuite {
  test("can set matrix zero for central zeros") {
    val m = Array(Array(1, 1, 1), Array(1, 0, 1), Array(1, 1, 1))
    SetMatrixZeroes.setZeroes(m)
    m.foreach { line => println(line.mkString(" ")) }
  }

  test("can set matrix zero for edge zeros") {
    val m = Array(Array(0, 1, 2, 0), Array(3, 4, 5, 2), Array(1, 3, 1, 5))
    SetMatrixZeroes.setZeroes(m)
    m.foreach { line => println(line.mkString(" ")) }
  }
}
