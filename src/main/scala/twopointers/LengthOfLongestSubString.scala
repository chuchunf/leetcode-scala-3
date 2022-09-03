package twopointers

import scala.collection.mutable

object LengthOfLongestSubString {
  def lengthOfLongestSubstring(s: String): Int =
    val cache = mutable.Map[Char, Int]()
    s.zipWithIndex.foldLeft((0, 0)) { case ((max, lp), (char, rp)) =>
      if cache.contains(char) then (max, cache(char) + 1) else {
        cache.update(char, rp)
        (max.max(rp - lp + 1), lp)
      }}._1
}
