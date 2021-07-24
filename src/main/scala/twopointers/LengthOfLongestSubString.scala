package twopointers

import scala.collection.mutable

object LengthOfLongestSubString {
  def lengthOfLongestSubstring(s: String): Int =
    val cache = mutable.Map[Char, Int]()
    var (max, leftp) = (0, 0)
    s.toCharArray.zipWithIndex.foreach { case (char, rightp) => {
      if cache.contains(char) then leftp = leftp.max(cache.get(char).get + 1)
      cache.update(char, rightp)
      max = max.max(rightp - leftp + 1)
    }}
    max
}
