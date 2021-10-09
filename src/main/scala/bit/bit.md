# Bit operations and tricks
| Operation | Example |
| ------ | ------------ |
| Get nth bit of i | (i >> n) & 1 |
| Get last 4 bit of i | i & 15 |
| Set nth bit to 1 | i &#124; (1 << n) |
| Set nth bit to 0 | i & ~(1 << n) |
| Toggle th bit | i ^ (1 << n) |
| Get least significant bit | i & -i |
| Multiply by 2^n | i << n |
| Divide by 2^n | i >> n |
| Mod by 2^n | i & (1<<n-1) |
| Is even | (i & 1) == 0 |
| Is power of 2 | (i != 0) && (i & (i - 1)) == 0 |

### 405. Convert a Number to Hexadecimal
```scala
  def toHex(num: Int): String = num match
    case 0 => "0"
    case n => "0123456789abcdef".charAt(n & 15).toString + (if n >>> 4 != 0 then toHex(n >>> 4) else "")
```

### 29. Divide Two Integers
```scala
  def divide(dividend: Int, divisor: Int): Int =
    val sign = if (divisor ^ dividend) >= 0 then 1 else -1
    var (dvd, dvs, result, count) = (dividend.abs, divisor.abs, 0, 0)
    while dvd > dvs do
      while dvd > (dvs << count) do count = count + 1
      result = result + (1 << (count - 1))
      dvd = dvd - (dvs << (count - 1))
      count = 0
    result * sign
```