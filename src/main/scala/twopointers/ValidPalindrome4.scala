package twopointers

object ValidPalindrome4 {
  def makePalindrome(s: String): Boolean =
    var (b, e, mismatch) = (0, s.length - 1, 0)
    while b < e do {
      if s.charAt(b)!=s.charAt(e) then mismatch = mismatch + 1
      b = b + 1
      e = e - 1
    }
    mismatch <= 2
}
