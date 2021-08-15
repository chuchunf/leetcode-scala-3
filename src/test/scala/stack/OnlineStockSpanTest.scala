package stack

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class OnlineStockSpanTest extends AnyFunSuite {
  test("can calculate span with price high to low") {
    val prices = Array(100, 90, 80, 70, 60)
    val result = OnlineStockSpan.calulcateSpan(prices)
    result.length shouldEqual (5)
    result(1) shouldEqual (1)
    result(2) shouldEqual (1)
    result(3) shouldEqual (1)
    result(4) shouldEqual (1)
  }

  test("can calcuate span") {
    val prices = Array(100, 90, 40, 100, 50)
    val result = OnlineStockSpan.calulcateSpan(prices)
    result.length shouldEqual (5)
    result(1) shouldEqual (1)
    result(2) shouldEqual (1)
    result(3) shouldEqual (3)
    result(4) shouldEqual (1)
  }

  test("can handle empty price array") {
    val prices = Array.empty[Int]
    val result = OnlineStockSpan.calulcateSpan(prices)
    result shouldEqual (Array.empty[Int])
  }

  test("can handle array with 1 element") {
    val prices = Array(10)
    val result = OnlineStockSpan.calulcateSpan(prices)
    result shouldEqual (Array(0))
  }
}
