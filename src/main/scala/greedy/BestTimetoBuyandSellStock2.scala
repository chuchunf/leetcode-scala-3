package greedy

object BestTimetoBuyandSellStock2 {
  def maxProfit(prices: Array[Int]): Int =
    prices.zipWithIndex.foldLeft(0) { case (r, (v, i)) =>
      if (i + 1) < prices.length && v < prices(i + 1) then r + prices(i + 1) - v else r
    }
}
