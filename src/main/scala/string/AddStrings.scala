package string

object AddStrings {
  def addStrings(num1: String, num2: String): String =
    num1.reverse.zipAll(num2.reverse, '0', '0').reverse
      .foldRight(("", 0)) { case ((n1, n2), (result, carry)) =>
        val sum = carry + (n1 - '0') + (n2 - '0')
        (s"${sum % 10}$result", sum / 10)
      } match
      case (result, 1) => "1" + result
      case (result, _) => result
}
