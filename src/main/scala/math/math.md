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

### 96. Unique Binary Search Trees
The recursive formula for G(n)<br>
G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
```scala
  def numTrees(n: Int): Int = n match
    case 0 => 1
    case n if n <= 2 => n
    case n => (0 until n).foldRight(0) { case (num, acc) => acc + numTrees(num) * numTrees(n - 1 - num) }
```

### 149. Max Points on a Line
```scala
  def maxPoints(points: Array[Array[Int]]): Int =
  points.foldLeft(0) { case (max, point) =>
    val cache = mutable.HashMap[((Int, Int), (Int, Int)), Int]()
    points.foldLeft(max) {
      case (max2, point2) if point == point2 => max2
      case (max2, point2) =>
        val a = if point2(0) == point(0) then(0, 0) else
          ((point2(1) - point(1)) / (point2(0) - point(0)), (point2(1) - point(1)) % (point2(0) - point(0)))
        val b = if point2(0) == point(0) then(0, 0) else
          ((point2(0) * point(1) - point(0) * point2(1)) / (point2(0) - point(0)), (point2(0) * point(1) + point(0) * point2(1)) % (point2(0) - point(0)))
        cache.update((a, b), cache.get((a, b)).getOrElse(0) + 1)
        max2.max(cache.get((a, b)).get + 1)
    }
  }
```

### 166. Fraction to Recurring Decimal
```scala
  def fractionToDecimal(numerator: Int, denominator: Int): String =
    val sign = if numerator * denominator > 0 then "" else "-"
    var (num, dev) = (numerator.abs.toLong, denominator.abs.toLong)
    val result = StringBuffer("")
    result.append(num / dev)
    num = num % dev
    if num != 0 then {
      result.append(".")
      val cache = mutable.HashMap[Long, Int]()
      cache.put(num, result.length())
      while num != 0
      do
        num = num * 10
      result.append(num / dev)
      num = num % dev
      if !cache.contains(num) then cache.put(num, result.length()) else {
        result.insert(cache.get(num).get, '(')
        result.append(")")
        num = 0
      }
    }
    s"$sign${result.toString}"
```

### 172. Factorial Trailing Zeroes
number of zero is the same as number 5, divided by 5 returns number of 5. E.g. 11/5 => 2, there are 10, 5 => 2 5s. The
function need to be called recursively, for 25 (5*5), 125 (5*5*5)
```scala
  def trailingZeroes(n: Int): Int = n match
    case 0=> 0
    case num => num / 5 + trailingZeroes(num / 5)
```

### 168. Excel Sheet Column Title
```scala
  def convertToTitle(columnNumber: Int): String = columnNumber match
    case 0 => ""
    case num => convertToTitle(columnNumber / 26) + ((columnNumber % 26) + 64).toChar
```