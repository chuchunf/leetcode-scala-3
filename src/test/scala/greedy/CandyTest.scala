package greedy

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class CandyTest extends AnyFunSuite {
  test("can get from normal list") {
    val ratings = Array(1, 2, 2)
    val result = Candy.candy(ratings)
    result shouldEqual 4
  }

  test("can get from backtrack list") {
    val ratings = Array(1, 0, 2)
    val result = Candy.candy(ratings)
    result shouldEqual 5
  }
}
