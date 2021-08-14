package hashmap

import scala.collection.mutable

object BullsandCows {
  def getHint(secret: String, guess: String): String =
    val (scache, gcache) = (mutable.HashMap[Char, Int](), mutable.HashMap[Char, Int]())
    val bull = secret.toCharArray.zip(guess.toCharArray).foldLeft(0) {
      case (bull, (s, g)) if s == g => bull + 1
      case (bull, (s, g)) =>
        scache.update(s, scache.get(s).getOrElse(1))
        gcache.update(g, gcache.get(g).getOrElse(1))
        bull
    }
    val cow = scache.foldLeft(0) { case (cow, (k, v)) => cow + v.min(gcache.get(k).getOrElse(0)) }
    s"${bull}A${cow}B"
}
