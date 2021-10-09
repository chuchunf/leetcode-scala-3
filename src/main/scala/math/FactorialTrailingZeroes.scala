package math

// 172. Factorial Trailing Zeroes
object FactorialTrailingZeroes {
  def trailingZeroes(n: Int): Int = n match
    case 0 => 0
    case num => num / 5 + trailingZeroes(num / 5)
}
