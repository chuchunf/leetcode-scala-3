package math

object Integer2Roman {
  def intToRoman(num: Int): String =
    List((1000, "M"), (900, "CM"), (500, "D"), (400, "CD"), (100, "C"), (90, "XC"), (50, "L"), (40, "XL"), (10, "X"), (9, "IX"), (5, "V"), (4, "IV"), (1, "I"))
      .find { case (int, _) => num >= int }
      .map { case (int, roman) => if num == int then roman else roman + intToRoman(num - int) }
      .get
}
