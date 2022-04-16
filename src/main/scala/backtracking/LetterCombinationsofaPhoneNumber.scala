package backtracking

object LetterCombinationsofaPhoneNumber {
  private val map = Map('2' -> List("a", "b", "c"), '3' -> List("d", "e", "f"), '4' -> List("g", "h", "i"), '5' -> List("j", "k", "l")
    , '6' -> List("m", "n", "o"), '7' -> List("p", "q", "r", "s"), '8' -> List("t", "u", "v"), '9' -> List("w", "x", "y", "z"))

  def letterCombinations(digits: String): List[String] = _letterCombinations(digits.toList, List.empty[String])

  private def _letterCombinations(digits: List[Char], buffer: List[String]): List[String] = digits match
    case List() => buffer
    case head :: tail => _letterCombinations(tail, map(head).map { case d => if buffer.isEmpty then List(d) else buffer.map(b => b + d) }.flatten)
}
