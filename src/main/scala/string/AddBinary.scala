package string

object AddBinary {
  def addBinary(a: String, b: String): String =
    a.reverse.zipAll(b.reverse, '0', '0').reverse
      .foldRight(("", 0)) { case ((s1, s2), (result, carry)) =>
        val sum = carry + (s1 - '0') + (s2 - '0')
        (s"${sum % 2}$result", sum / 2)
      } match
      case (result, 1) => "1" + result
      case (result, _) => result
}
