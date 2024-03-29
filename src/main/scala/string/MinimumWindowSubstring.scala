package string

import scala.collection.mutable

object MinimumWindowSubstring {
  def minWindow(s: String, t: String): String = (s.length, t.length) match
    case (slen, tlen) if slen == tlen => if s.equals(t) then t else ""
    case (slen, tlen) if slen < tlen => ""
    case _ => val (scache, tcache) = (mutable.HashMap[Char, Int](), mutable.HashMap[Char, Int]())
      s.toCharArray.foreach(schar => scache.update(schar, scache.getOrElse(schar, 0) + 1))
      t.toCharArray.foreach(tchar => tcache.update(tchar, tcache.getOrElse(tchar, 0) + 1))
      tcache.find { case (char, count) => scache.getOrElse(char, 0) < count } match
        case Some(_, _) => ""
        case None => s.substring(findLastPosition(s, scache, tcache), s.length - findLastPosition(s.reverse, scache, tcache))

  private def findLastPosition(s: String, scache: mutable.HashMap[Char, Int], tcache: mutable.HashMap[Char, Int]): Int =
    s.toCharArray.zipWithIndex.find { case (char, index) => 
      if tcache.contains(char) && scache(char) == tcache(char) then true else {
        scache.update(char, scache(char) - 1)
        false
      }
    }.get._2
}
