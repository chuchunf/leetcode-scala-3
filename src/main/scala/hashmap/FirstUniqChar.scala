package hashmap

import scala.collection.mutable

object FirstUniqChar {
  def firstUniqChar(s: String): Int =
    val cache = mutable.Map[Char, Int]()
    s.toArray.foreach(c => cache.update(c, cache.get(c).getOrElse(0) + 1))
    s.toArray.find(cache.get(_).get == 1) match
      case Some(result) => s.indexOf(result)
      case _ => -1
}
