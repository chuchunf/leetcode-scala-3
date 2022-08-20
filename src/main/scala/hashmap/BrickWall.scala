package hashmap

import scala.collection.mutable

object BrickWall {
  def leastBricks(wall: List[List[Int]]): Int =
    val cache = mutable.Map[Int, Int]()
    wall.foreach(_.dropRight(1)
      .foldLeft(0) { case (sum, w) =>
        cache.update(sum + w, cache.getOrElse(sum + w, 0) + 1)
        sum + w
      })
    wall.length - (if cache.isEmpty then 0 else cache.values.max)
}
