package hashmap

object FirstUniqChar {
  def firstUniqChar(s: String): Int =
    import scala.collection.mutable
    val cache = mutable.Map[Char, Int]()

    s.toArray.foreach(c => cache.update(c, cache.get(c).getOrElse(0) + 1))
    s.toArray.find(cache.get(_).getOrElse(0) == 1) match
      case Some(result) => s.indexOf(result)
      case _ => throw new IllegalArgumentException("no character is unique in the given string")
}
