package twopointers

object ValidPalindrome2 {
  def validPalindrome(s: String): Boolean = isValidPalindrome(s, 0, s.length - 1) match
    case (false, sp, ep) => isValidPalindrome(s, sp + 1, ep)._1 || isValidPalindrome(s, sp, ep - 1)._1
    case _ => true

  private def isValidPalindrome(str: String, s: Int, e: Int): (Boolean, Int, Int) =
    var (sp, ep) = (s, e)
    while sp < ep do
      (str.charAt(sp), str.charAt(ep)) match
        case (sc, ec) if sc != ec => return (false, sp, ep)
        case (_, _) => sp = sp + 1
          ep = ep - 1
    (true, s, e)
}
