package dp

import scala.collection.mutable

object ValidPalindrome3 {
  def isPalindrome(s: String, k: Int): Boolean =
    _isPalindrome(0, s.length - 1, s, k, k, Array.tabulate[Option[Boolean]](s.length + 1, s.length + 1)((_, _) => None))

  private def _isPalindrome(i: Int, j: Int, s: String, left: Int, k: Int, cache: Array[Array[Option[Boolean]]]): Boolean =
    if i == j then true
    else if (i + 1) == j then k >= 1 || s.charAt(i) == s.charAt(j)
    else if i > j || left < 0 then false
    else if cache(i)(j).isDefined then cache(i)(j).get
    else {
      cache(i)(j) = Option(if s.charAt(i) == s.charAt(j) then _isPalindrome(i + 1, j - 1, s, left, k, cache)
      else _isPalindrome(i + 1, j, s, left - 1, k, cache) || _isPalindrome(i, j - 1, s, left - 1, k, cache))
      cache(i)(j).get
    }
}
