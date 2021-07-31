package array

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class BestTimetoBuyandSellStockTest extends AnyFunSuite {
  test("can find the max profit") {
    val prices = Array(7, 1, 5, 3, 6, 4)
    val result = BestTimetoBuyandSellStock.maxProfit(prices)
    result shouldEqual (5)
  }

  test("can return 0 if not profitable") {
    val prices = Array(7,6,4,3,1)
    val result = BestTimetoBuyandSellStock.maxProfit(prices)
    result shouldEqual (0)
  }
}
