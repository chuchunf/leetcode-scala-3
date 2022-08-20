package hashmap

import scala.collection.mutable

object BullsandCows {
  def getHint(secret: String, guess: String): String =
    val (scache, gcache) = (mutable.HashMap[Char, Int](), mutable.HashMap[Char, Int]())
    val bull = secret.toCharArray.zip(guess.toCharArray).count {
      case (s, g) if s == g => true
      case (s, g) =>
        scache.update(s, scache.getOrElse(s, 1))
        gcache.update(g, gcache.getOrElse(g, 1))
        false
    }
    val cow = scache.map { case (k, v) => v.min(gcache.getOrElse(k, 0)) }.sum
    s"${bull}A${cow}B"
}
