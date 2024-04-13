package twopointers

object ValidPalindrome {
  def isPalindrome(s: String): Boolean =
    var (lp, rp) = (0, s.length - 1)
    while lp < rp do
      (s.charAt(lp), s.charAt(rp)) match
        case (lc, _) if !lc.isLetterOrDigit => lp = lp + 1
        case (_, rc) if !rc.isLetterOrDigit => rp = rp - 1
        case (lc, rc) if lc.toLower != rc.toLower => return false
        case (_, _) =>
          lp = lp + 1
          rp = rp - 1
    true
}
