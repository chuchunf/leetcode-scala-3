package hashmap

import scala.collection.mutable

object IsomorphicStrings {
  def isIsomorphic(s: String, t: String): Boolean =
    val (smap, tmap) = (mutable.Map[Char, Char](), mutable.Map[Char, Char]())
    s.toCharArray.zip(t.toCharArray).find { case (schar, tchar) => {
      (smap.get(schar), tmap.get(tchar)) match
        case (Some(_), None) | (None, Some(_)) => true
        case (Some(char1), Some(char2)) => char1 != tchar || char2 != schar
        case (None, None) => smap.put(schar, tchar)
          tmap.put(tchar, schar)
          false
    }}.isEmpty
}
