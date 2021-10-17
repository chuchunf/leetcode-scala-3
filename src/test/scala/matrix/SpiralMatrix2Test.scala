package matrix

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SpiralMatrix2Test extends AnyFunSuite {
  test("can handle 1") {
    val result = SpiralMatrix2.generateMatrix(1)
    result.foreach(line => println(line.mkString(" ")))
  }

  test("can handle 2") {
    val result = SpiralMatrix2.generateMatrix(2)
    result.foreach(line => println(line.mkString(" ")))
  }

  test("can handle 3") {
    val result = SpiralMatrix2.generateMatrix(3)
    result.foreach(line => println(line.mkString(" ")))
  }
}

