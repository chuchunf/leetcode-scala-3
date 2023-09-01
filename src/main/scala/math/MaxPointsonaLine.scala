package math

import scala.collection.mutable

object MaxPointsonaLine {
  def maxPoints(points: Array[Array[Int]]): Int =
    points.foldLeft(0) { case (max, point) =>
      val cache = mutable.HashMap[((Int, Int), (Int, Int)), Int]()
      points.foldLeft(max) {
        case (max2, point2) if point sameElements point2 => max2
        case (max2, point2) =>
          val a = if point2(0) == point(0) then (0, 0) else
            ((point2(1) - point(1)) / (point2(0) - point(0)), (point2(1) - point(1)) % (point2(0) - point(0)))
          val b = if point2(0) == point(0) then (0, 0) else
            ((point2(0) * point(1) - point(0) * point2(1)) / (point2(0) - point(0)), (point2(0) * point(1) + point(0) * point2(1)) % (point2(0) - point(0)))
          cache.update((a, b), cache.getOrElse((a, b), 0) + 1)
          max2.max(cache((a, b)) + 1)
      }
    }
}
