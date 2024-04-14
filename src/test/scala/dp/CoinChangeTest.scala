package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class CoinChangeTest extends AnyFunSuite {
  test("can get the min number") {
    val coins = Array(1, 2, 5)
    val amount = 11
    val result = CoinChange.coinChange(coins, amount)
    result shouldEqual 3
  }

  test("can handle negative case") {
    val coins = Array(2)
    val amount = 3
    val result = CoinChange.coinChange(coins, amount)
    result shouldEqual -1
  }

  test("can handle 0 amount") {
    val coins = Array(2)
    val amount = 0
    val result = CoinChange.coinChange(coins, amount)
    result shouldEqual 0
  }
}
