package string

object AddStrings {
  def addStrings(num1: String, num2: String): String =
    num1.reverse.toCharArray.zipAll(num2.reverse.toCharArray, '0', '0').reverse
      .foldRight(("", 0)) { case ((n1, n2), (result, carry)) => {
        val sum = carry + (n1 - '0') + (n2 - '0')
        if sum >= 10 then ((sum % 10).toString + result, 1) else (sum.toString + result, 0)
      }} match
        case (result, 1) => "1" + result
        case (result, _) => result
}
