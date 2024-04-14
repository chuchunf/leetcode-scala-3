package dp

object CoinChange {
  def coinChange(coins: Array[Int], amount: Int): Int =
    val result = _coinChange(0, coins, amount, Array.tabulate[Int](coins.length + 1, amount + 1)((_, _) => -1))
    if result == Int.MaxValue - 1 then -1 else result

  private def _coinChange(i: Int, coins: Array[Int], amount: Int, cache: Array[Array[Int]]): Int =
    if amount == 0 then 0
    else if i == coins.length then Int.MaxValue - 1
    else if amount < 0 then Int.MaxValue - 1
    else if cache(i)(amount) != -1 then cache(i)(amount)
    else {
      val select = 1 + _coinChange(i, coins, amount - coins(i), cache)
      val pass = _coinChange(i + 1, coins, amount, cache)
      cache(i)(amount) = select.min(pass)
      cache(i)(amount)
    }
}
