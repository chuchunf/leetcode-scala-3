package orderedset

import scala.collection.mutable

class MyCalendar2 {
  private[this] val cache = mutable.TreeMap[Int, Int]()

  def book(start: Int, end: Int): Boolean =
    if cache.minAfter(start).getOrElse((Int.MaxValue, Int.MaxValue))._1 <= end then {
      val second = cache.minAfter(cache.minAfter(start).get._1).getOrElse((Int.MaxValue, Int.MaxValue))._1
      if second <= end then false else
        cache(start) = end
        true
    } else if cache.maxBefore(start).getOrElse((Int.MinValue, Int.MinValue))._2 >= start then {
      val second = cache.maxBefore(cache.maxBefore(start).get._1).getOrElse(Int.MaxValue, Int.MaxValue)._2
      if second <= end then false else
        cache(start) = end
        true
    } else {
      cache(start) = end
      true
    }
}
