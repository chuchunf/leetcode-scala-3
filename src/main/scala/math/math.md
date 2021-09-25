# Math

### 12. Integer to Roman
```scala
  def intToRoman(num: Int): String =
    List((1000, "M"), (900, "CM"), (500, "D"), (400, "CD"), (100, "C"), (90, "XC"), (50, "L"), (40, "XL"), (10, "X"), (9, "IX"), (5, "V"), (4, "IV"), (1, "I"))
      .find { case (int, _) => num >= int }
      .map { case (int, roman) => if num == int then roman else roman + intToRoman(num - int) }
      .get
```

### 13. Roman to Integer
```scala
  def romanToInt(s: String): Int =
    List((1000, "M"), (900, "CM"), (500, "D"), (400, "CD"), (100, "C"), (90, "XC"), (50, "L"), (40, "XL"), (10, "X"), (9, "IX"), (5, "V"), (4, "IV"), (1, "I"))
      .find { case (_, roman) => s.startsWith(roman) }
      .map { case (int, roman) => if s.equals(roman) then int else int + romanToInt(s.drop(roman.length)) }
      .get
```

### 66. Plus One
```scala
  def plusOne(digits: Array[Int]): Array[Int] =
    digits.zipWithIndex.foldRight(1) {
      case ((_, _), carry) if carry == 0 => 0
      case ((n, i), _) if n < 9 => digits(i) = n + 1; 0
      case ((n, i), _) if n == 9 => digits(i) = 0; 1
    } match
      case 0 => digits
      case _ => Array(1) ++ digits
```

### 50. Pow(x, n)
```scala
  def myPow(x: Double, n: Int): Double = (x, n) match
    case (in, pow) if pow == 1 => in
    case (in, pow) if pow < 0 => myPow(1 / in, -pow)
    case (in, pow) if pow % 2 == 0 => myPow(in * in, pow / 2)
    case (in, pow) => in * myPow(in * in, (pow - 1) / 2)
```