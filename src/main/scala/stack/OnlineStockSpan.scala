package stack

import scala.collection.mutable

object OnlineStockSpan {
  def calulcateSpan(prices: Array[Int]): Array[Int] = prices match
    case Array() => Array()
    case Array(_) => Array(0)
    case _ => val (stack, array) = (new MinStack[Integer](), mutable.ArrayBuffer[Int](0))
      stack.push(0)
      prices.drop(1).zipWithIndex.foreach { case (price, index) => {
        var (span, i) = (1, index + 1)
        while prices(stack.top()) < price do
          span = span + 1
          stack.pop()
        stack.push(i)
        array.append(span)
      }}
      array.toArray
}
