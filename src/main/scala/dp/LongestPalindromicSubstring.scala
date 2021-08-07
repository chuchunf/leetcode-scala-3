package dp

object LongestPalindromicSubstring {
  def longestPalindrome(s: String): String =
    val cache = Array.ofDim[Boolean](s.length, s.length)
    var result = ""
    for (i <- s.length - 1 to 0 by -1; j <- i until s.length) {
      cache(i)(j) = s.charAt(i) == s.charAt(j) && (j - i < 3 || cache(i + 1)(j - 1))
      if cache(i)(j) && j - i + 1 > result.length then result = s.substring(i, j + 1)
    }
    result
}


