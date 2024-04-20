package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldEqual

class CoinChange2Test extends AnyFunSuite {
  test("can get the change") {
    val coins = Array(1, 2, 5)
    val amount = 5
    val result = CoinChange2.change(amount, coins)
    result shouldEqual 4
  }

  test("can not get the change") {
    val coins = Array(2)
    val amount = 3
    val result = CoinChange2.change(amount, coins)
    result shouldEqual 0
  }

  test("can get 1 change") {
    val coins = Array(10)
    val amount = 10
    val result = CoinChange2.change(amount, coins)
    result shouldEqual 1  
  }

}
