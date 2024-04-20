package dp

object LongestPalindromicSubsequence {
  def longestPalindromeSubseq(s: String): Int =
    _longestPalindromeSubseq(0, s.length - 1, s, Array.tabulate[Int](s.length + 1, s.length + 1)((_, _) => -1))

  private def _longestPalindromeSubseq(b: Int, e: Int, s: String, cache: Array[Array[Int]]): Int =
    if b > e then 0
    else if b == e then 1
    else if cache(b)(e) != -1 then cache(b)(e)
    else {
      cache(b)(e) = if s.charAt(b) == s.charAt(e) then 2 + _longestPalindromeSubseq(b + 1, e - 1, s, cache)
      else _longestPalindromeSubseq(b + 1, e, s, cache).max(_longestPalindromeSubseq(b, e - 1, s, cache))
      cache(b)(e)
    }
}
