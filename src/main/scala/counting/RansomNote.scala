package counting

import scala.collection.mutable

object RansomNote {
  def canConstruct(ransomNote: String, magazine: String): Boolean =
    val (rmap, mmap) = (mutable.HashMap[Char, Int](), mutable.HashMap[Char, Int]())
    ransomNote.foreach(char => rmap.update(char, rmap.getOrElse(char, 0) + 1))
    magazine.foreach(char => mmap.update(char, mmap.getOrElse(char, 0) + 1))
    !rmap.exists { case (char, count) => count > mmap.getOrElse(char, 0) }
}
