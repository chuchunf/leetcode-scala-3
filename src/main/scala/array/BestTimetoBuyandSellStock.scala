package array

object BestTimetoBuyandSellStock {
  def maxProfit(prices: Array[Int]): Int = prices match
    case Array() => 0
    case Array(head, tail) => if head < tail then tail - head else 0
    case _ => var (maxprofit, minprice) = (0, prices(0))
      prices.drop(1).foreach(price => {
        maxprofit = maxprofit.max(price - minprice)
        minprice = minprice.min(price)
      })
      maxprofit
}
