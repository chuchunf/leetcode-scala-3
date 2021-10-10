package bit

import scala.collection.mutable

object RepeatedDNASequences {
  def findRepeatedDnaSequences(s: String): List[String] =
    val map = Map('A' -> 0, 'C' -> 1, 'G' -> 2, 'T' -> 3)
    val cache = mutable.HashSet[Int]()
    var seq = 0
    (0 until s.length).filter { case index =>
      seq = (seq << 2 | map(s.charAt(index))) & 0x000fffff
      index >= 9 && !cache.add(seq)
    }.map(i => s.substring(i - 9, i + 1))
      .toList
}
