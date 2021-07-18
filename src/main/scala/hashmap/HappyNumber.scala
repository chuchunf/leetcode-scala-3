package hashmap

import scala.collection.mutable

object HappyNumber {
  def isHappy(n: Int): Boolean =
    import scala.collection.mutable
    val cache = mutable.Set[Int]()
    isHappyInernal(n, cache)

  private def isHappyInernal(n: Int, cache: mutable.Set[Int]): Boolean = n match
    case num if num == 1 => true
    case num if cache.contains(num) => false
    case num => cache.add(num)
      isHappyInernal(getSum(num), cache)

  private def getSum(n: Int): Int =
    var sum = 0
    var num = n
    while (num != 0) {
      val remain = num % 10
      sum = sum + remain * remain
      num = num / 10
    }
    sum
}