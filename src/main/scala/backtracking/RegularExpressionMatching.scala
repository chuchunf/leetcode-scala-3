package backtracking

object RegularExpressionMatching {
  def isMatch(s: String, p: String): Boolean = p.toSeq match
    case Seq() => s.isEmpty
    case Seq(head, tail*) =>
      val firstMatch = s.headOption.exists(_ == head || head == '.')
      tail.headOption.filter(_ == '*') match
        case Some(_) => isMatch(s, p.drop(2)) || (firstMatch && isMatch(s.drop(1), p))
        case None => firstMatch && isMatch(s.drop(1), p.drop(1))
}
