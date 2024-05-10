package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldEqual

class BestTimetoBuyandSellStock4Test extends AnyFunSuite {
  test("can get max profit") {
    val prices = Array(2, 4, 1)
    val k = 2
    val result = BestTimetoBuyandSellStock4.maxProfit(k, prices)
    result shouldEqual 2
  }

  test("can get max profit 2") {
    val prices = Array(3, 2, 6, 5, 0, 3)
    val k = 2
    val result = BestTimetoBuyandSellStock4.maxProfit(k, prices)
    result shouldEqual 7
  }
}
