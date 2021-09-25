package counting

import scala.collection.mutable

object RansomNote {
  def canConstruct(ransomNote: String, magazine: String): Boolean =
    val (rmap, mmap) = (countChar(ransomNote), countChar(magazine))
    rmap.find { case (char, count) => count > mmap.get(char).getOrElse(0) }.isEmpty

  private def countChar(s: String): Map[Char, Int] =
    s.foldLeft(mutable.HashMap[Char, Int]()) { case (cache, char) => {
      cache.update(char, cache.get(char).getOrElse(0) + 1)
      cache
    }}.toMap
}
