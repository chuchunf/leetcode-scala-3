package greedy

import scala.annotation.tailrec

// 44. Wildcard Matching
object WildcardMatching {
  @tailrec
  def isMatch(s: String, p: String): Boolean =
    if s.isEmpty && p.isEmpty then true
    else if s.isEmpty || p.isEmpty then false
    else p(0) match
      case '?' => isMatch(s.substring(1), p.substring(1))
      case '*' => var curr = 0
        while curr < s.length && s(0) == s(curr) do curr = curr + 1
        isMatch(s.substring(curr), p.substring(1))
      case _ => if p(0) == s(0) then isMatch(s.substring(1), p.substring(1)) else false
}
