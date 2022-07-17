package greedy

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class BestTimetoBuyandSellStock2Test extends AnyFunSuite {
  test("can find best price") {
    val prices = Array(7, 1, 5, 3, 6, 4)
    val result = BestTimetoBuyandSellStock2.maxProfit(prices)
    result shouldEqual 7
  }

  test("can find best price with incremental order") {
    val prices = Array(1, 2, 3, 4, 5)
    val result = BestTimetoBuyandSellStock2.maxProfit(prices)
    result shouldEqual 4
  }

  test("can find best price with decremental order") {
    val prices = Array(7, 6, 4, 3, 1)
    val result = BestTimetoBuyandSellStock2.maxProfit(prices)
    result shouldEqual 0
  }
}
