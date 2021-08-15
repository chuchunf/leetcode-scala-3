package array

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class BestTimetoBuyandSellStockTest extends AnyFunSuite {
  test("can find the max profit") {
    val prices = Array(7, 1, 5, 3, 6, 4)
    val result = BestTimetoBuyandSellStock.maxProfit(prices)
    result shouldEqual (5)
  }

  test("can return 0 if not profitable") {
    val prices = Array(7, 6, 4, 3, 1)
    val result = BestTimetoBuyandSellStock.maxProfit(prices)
    result shouldEqual (0)
  }

  test("can return 0 with empty array") {
    val prices = Array.empty[Int]
    val result = BestTimetoBuyandSellStock.maxProfit(prices)
    result shouldEqual (0)
  }

  test("can handle two element array") {
    val prices = Array(7, 6)
    val result = BestTimetoBuyandSellStock.maxProfit(prices)
    result shouldEqual (0)

    val prices2 = Array(7, 8)
    val result2 = BestTimetoBuyandSellStock.maxProfit(prices2)
    result2 shouldEqual (1)
  }
}
