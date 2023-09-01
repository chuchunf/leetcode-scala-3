package hashmap

import scala.annotation.tailrec

object HappyNumber {
  def isHappy(n: Int): Boolean = isHappyInernal(n, Set.empty[Int])

  @tailrec
  private def isHappyInernal(n: Int, cache: Set[Int]): Boolean = n match
    case num if num == 1 => true
    case num if cache.contains(num) => false
    case num => isHappyInernal(num.toString.map(c => (c - '0') * (c - '0')).sum, cache + num)
}