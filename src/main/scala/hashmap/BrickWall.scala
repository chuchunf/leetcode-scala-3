package hashmap

import scala.collection.mutable

object BrickWall {
  def leastBricks(wall: List[List[Int]]): Int =
    val cache = mutable.Map[Int, Int]()
    wall.foreach(_.dropRight(1).foldLeft(0) { case (sum, w) => {
      cache.update(sum + w, cache.get(sum + w).getOrElse(0) + 1)
      sum + w
    }})
    wall.length - cache.foldLeft(0) { case (max, (_, v)) => { max.max(v) }}
}
