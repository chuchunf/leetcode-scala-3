package string

object AddBinary {
  def addBinary(a: String, b: String): String =
    a.reverse.zipAll(b.reverse, '0', '0').reverse
      .foldRight(("", 0)) { case ((s1, s2), (result, carry)) =>
        val sum = carry + (s1 - '0') + (s2 - '0')
        if sum >= 2 then ((sum % 2).toString + result, 1) else (sum.toString + result, 0)
      } match
      case (result, 1) => "1" + result
      case (result, _) => result
}
