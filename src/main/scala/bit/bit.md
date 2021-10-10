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

### 78. Subsets
Bit manipulation for array less than 32, back tracking could also be used.
Explanation, assume for array of (1, 2), there will be 4 combinations, expressed as bit:

|Index| Bit | Element selected by index|
|---|---|---|
|0 | 0000 0000 | () |
|1 | 0000 0001 | (1) |
|2 | 0000 0010 | (2) |
|3 | 0000 0011 | (1,2) |
```scala
  def subsets(nums: Array[Int]): List[List[Int]] =
    (0 until 1 << nums.length).collect[List[Int]] { case i1 =>
      nums.zipWithIndex
        .filter { case (_, i2) => (i1 & (1 << i2)) != 0 }
        .map(_._1)
        .toList
    }.toList
```

### 89. Gray Code
Recursive pattern, array of n consist array of (n-1) and reverse of array (n-1) with nth bit toggle to 1 

|Number| n-1 part | reverse of n-1 part with nth bit toggled | result |
|---|---|---|---|
|1 |  |  | 0 1 |
|2 | 00 01 | 11 10 | 0 1 3 2 |
|2 | 000 001 011 010 | 110 111 101 100 | 0 1 3 2 6 7 5 4 |
```scala
  def grayCode(n: Int): List[Int] = n match
    case 1 => List(0, 1)
    case num => grayCode(num - 1) ::: grayCode(num - 1).reverse.map(_ | (1 << (num - 1)))
```

### 136. Single Number
```scala
  def singleNumber(nums: Array[Int]): Int = nums.reduceLeft { case (acc, num) => acc ^ num }
```

### 137. Single Number 2
A Hashmap could be used to count the number of occurrence of any number in the array.
Since additional data structure is not allow, a single Int is used as the result holder, check all 32 bits for all the number in the array.
Then set the bit back to the holder for all the 32 bits to get the final result.
```scala
  def singleNumber(nums: Array[Int]): Int =
    (0 to 31).foldLeft(0) { case (result, shift) =>
      nums.foldLeft(0) { case (count, num) =>
        if ((num >> shift) & 1) == 1 then (count + 1) % 3 else count
      } << shift | result
    }
```

### 187. Repeated DNA
```scala
  def findRepeatedDnaSequences(s: String): List[String] =
    val map = Map('A' -> 0, 'C' -> 1, 'G' -> 2, 'T' -> 3)
    val cache = mutable.HashSet[Int]()
    var seq = 0
    (0 until s.length).filter { case index =>
      seq = (seq << 2 | map(s.charAt(index))) & 0x000fffff
      index >= 9 && !cache.add(seq)
    }.map(i => s.substring(i - 9, i + 1))
      .toList
```

### 190. Reverse Bits
```scala
  def reverseBits(x: Int): Int = (0 to 31).foldLeft(0) { case (result, index) => (result << 1) | (x >> index & 1) }
```

### 191. Number of 1 Bits
```scala
  def hammingWeight(n: Int): Int = (0 to 31).count(i => ((n >>> i) & 1) == 1)
```