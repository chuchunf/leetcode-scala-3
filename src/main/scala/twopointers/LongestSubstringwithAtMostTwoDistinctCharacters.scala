package twopointers

import scala.collection.mutable

object LongestSubstringwithAtMostTwoDistinctCharacters {
  def lengthOfLongestSubstringTwoDistinct(s: String): Int =
    val cache = mutable.HashSet[Char]()
    var (max, left, right) = (0, 0, 0)
    while left < s.length do
      while cache.size < 2 && right < s.length do
        cache.add(s.charAt(right))
        right = right + 1
      max = max.max(right - left + 1)
      cache.remove(s.charAt(left))
      left = left + 1
    max
}
