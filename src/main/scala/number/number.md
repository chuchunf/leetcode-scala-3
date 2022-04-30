# Number
* Make use of %10 and /10 => reverse integer 
* Math tricks
  * Factorial Trailing Zeroes => count number of 5
  * Add digits => if dividable by 9 then 9 other reminder of divided by 9
  * Multiply Strings => virtual multiplication

### 7. Reverse Integer
```scala
  def reverse(x: Int): Int =
    var (org, result) = (x, 0)
    while org > 0 do
      result = result * 10
      result = result + org % 10
      org = org / 10
    result
```

### 9. Palindrome Number
```scala
  def isPalindrome(x: Int): Boolean =
    var (org, result) = (x, 0)
    while org > result do
      result = result * 10
    result = result + org % 10
    org = org / 10
    org == result || org == result / 10
```

### 43. Multiply Strings
```scala
  def multiply(num1: String, num2: String): String =
    val cache = (0 to num2.length - 1).map(_ => new mutable.ArrayBuffer[Char]()).toArray
    num2.reverse.toArray.zipWithIndex.foreach { case (n2, index) => {
      var (line, carry) = (cache(index), 0)
      (0 until index).foreach(_ => line.append('0'))
      num1.reverse.toArray.foreach(n1 => {
        val mul = (n1 - '0') * (n2 - '0') + carry
        line.append((mul % 10 + '0').toChar)
        carry = mul / 10
      })
    }}

    cache.reduce((l1, l2) => {
      val len = l1.length.max(l2.length)
      val result = mutable.ArrayBuffer[Char]()
      var carry = 0
      for (i <- 0 until len) {
        val sum = carry + (if i < l1.length then l1(i) - '0' else 0) + (if i < l2.length then l2(i) - '0' else 0)
        result.append((sum % 10 + '0').toChar)
        carry = sum / 10
      }
      result
    }).mkString.reverse
```