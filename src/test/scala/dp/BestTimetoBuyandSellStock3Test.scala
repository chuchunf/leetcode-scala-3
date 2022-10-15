package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class BestTimetoBuyandSellStock3Test extends AnyFunSuite {
  test("can not find best time") {
    val prices = Array(7, 6, 4, 3, 1)
    val result = BestTimetoBuyandSellStock3.maxProfit(prices)
    result shouldEqual 0
  }

  test("can find best time") {
    val prices = Array(3, 3, 5, 0, 0, 3, 1, 4)
    val result = BestTimetoBuyandSellStock3.maxProfit(prices)
    result shouldEqual 6
  }
}
