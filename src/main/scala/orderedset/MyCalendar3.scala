package orderedset

import scala.collection.mutable

class MyCalendar3 {
  private[this] val cache = mutable.TreeMap[Int, Int]()

  def book(startTime: Int, endTime: Int): Int =
    cache(startTime) = cache.getOrElse(startTime, 0) + 1
    cache(endTime) = cache.getOrElse(endTime, 0) - 1
    cache.values.foldLeft(0, 0) { case ((max, ongoing), booking) =>
      val curr = ongoing + booking
      (max.max(curr), curr)
    }._1
}
