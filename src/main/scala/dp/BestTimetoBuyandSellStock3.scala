package dp

object BestTimetoBuyandSellStock3 {
  def maxProfit(prices: Array[Int]): Int = _maxProfit(prices, 0, 4, Array.fill(prices.length, 5)(-1))

  private def _maxProfit(prices: Array[Int], day: Int, txn: Int, cache: Array[Array[Int]]): Int =
    if day == prices.length then 0
    else if txn == 0 then 0
    else {
      if cache(day)(txn) == -1 then {
        val notxn = _maxProfit(prices, day + 1, txn, cache)
        val yestxn = if txn % 2 == 0 then _maxProfit(prices, day + 1, txn - 1, cache) - prices(day)
        else _maxProfit(prices, day + 1, txn - 1, cache) + prices(day)
        cache(day)(txn) = notxn.max(yestxn)
      }
      cache(day)(txn)
    }
}
