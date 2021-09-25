package math

object PlusOne {
  def plusOne(digits: Array[Int]): Array[Int] =
    digits.zipWithIndex.foldRight(1) {
      case ((_, _), carry) if carry == 0 => 0
      case ((n, i), _) if n < 9 => digits(i) = n + 1; 0
      case ((n, i), _) if n == 9 => digits(i) = 0; 1
    } match
      case 0 => digits
      case _ => Array(1) ++ digits
}
