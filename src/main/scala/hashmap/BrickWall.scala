package hashmap

import scala.collection.mutable

object BrickWall {
  def leastBricks(wall: List[List[Int]]): Int =
    val cache = mutable.Map[Int, Int]()
    wall.foreach(_.dropRight(1).foldLeft(0) { case (sum, w) =>
      cache.updateWith(sum + w) { _ => Option(cache.get(sum + w).getOrElse(0) + 1) }.get
    })
    wall.length - cache.values.max
}
