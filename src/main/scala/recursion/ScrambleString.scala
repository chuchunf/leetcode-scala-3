package recursion

object ScrambleString {
  def isScramble(s1: String, s2: String): Boolean =
    if s1.length != s2.length then false
    else if s1.equals(s2) then true
    else if s1.length <= 2 then s1.equals(s2.reverse)
    else {
      (1 until s1.length).exists { i =>
        (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
          || (isScramble(s1.substring(0, i), s2.substring(i)) && isScramble(s1.substring(i), s2.substring(0, i)))
      }
    }
}
