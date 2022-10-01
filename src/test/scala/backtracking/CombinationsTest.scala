package backtracking

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class CombinationsTest extends AnyFunSuite {
  test("can handle k=1") {
    val result = Combinations.combine(1, 1)
    result.length shouldEqual 1
    result(0).length shouldEqual 1
    result(0)(0) shouldEqual 1
  }

  test("can handle general case") {
    val result = Combinations.combine(4, 2)
    result.length shouldEqual 6
    result(0) shouldEqual List(1, 2)
    result(1) shouldEqual List(1, 3)
    result(2) shouldEqual List(1, 4)
    result(3) shouldEqual List(2, 3)
    result(4) shouldEqual List(2, 4)
    result(5) shouldEqual List(3, 4)
  }
}
