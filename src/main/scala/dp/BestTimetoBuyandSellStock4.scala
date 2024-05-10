package dp

object BestTimetoBuyandSellStock4 {
  def maxProfit(k: Int, prices: Array[Int]): Int =
    _maxProfit(0, 0, true, k * 2, k * 2, prices, Array.fill(prices.length, k * 2 + 1)(-1))

  private def _maxProfit(i: Int, profit: Int, d: Boolean, left: Int, k: Int, prices: Array[Int], cache: Array[Array[Int]]): Int =
    if left <= 0 then profit
    else if i >= prices.length then profit
    else if cache(i)(left) != -1 then cache(i)(left)
    else {
      cache(i)(left) = if d then {
        val buy = profit - prices(i) + _maxProfit(i + 1, profit, !d, left - 1, k, prices, cache)
        val next = profit + _maxProfit(i + 1, profit, d, left, k, prices, cache)
        profit + buy.max(next)
      } else {
        val sell = profit + prices(i) + _maxProfit(i + 1, profit, !d, left - 1, k, prices, cache)
        val next = profit + _maxProfit(i + 1, profit, d, left, k, prices, cache)
        profit + sell.max(next)
      }
      cache(i)(left)
    }
}
