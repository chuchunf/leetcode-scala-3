package dp

object CoinChange2 {
  def change(amount: Int, coins: Array[Int]): Int =
    _change(0, amount, coins, Array.tabulate[Int](coins.length + 1, amount + 1)((_, _) => -1))

  private def _change(i: Int, amount: Int, coins: Array[Int], cache: Array[Array[Int]]): Int =
    if amount == 0 then 1
    else if amount < 0 || i >= coins.length then 0
    else if cache(i)(amount) != -1 then cache(i)(amount)
    else {
      cache(i)(amount) = _change(i + 1, amount, coins, cache) + _change(i, amount - coins(i), coins, cache)
      cache(i)(amount)
    }
}
