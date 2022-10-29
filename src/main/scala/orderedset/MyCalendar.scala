package orderedset

import scala.collection.mutable

class MyCalendar {
  private[this] val cache = mutable.TreeMap[Int, Int]()

  def book(start: Int, end: Int): Boolean =
    if cache.minAfter(start).getOrElse((Int.MaxValue, Int.MaxValue))._1 > end
      && cache.maxBefore(start).getOrElse((Int.MinValue, Int.MinValue))._2 < start
    then {
      cache(start) = end
      true
    } else false
}
