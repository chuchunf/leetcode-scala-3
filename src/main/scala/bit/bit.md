# Bit operations and tricks
| Operation | Example                        |
| ------ |--------------------------------|
| Get nth bit of i | (i >> n) & **1**               |
| Get last 4 bit of i | i & **15**                     |
| Set nth bit to 1 | i &#124; (1 << n)              |
| Set nth bit to 0 | i & ~(1 << n)                  |
| Toggle th bit | i ^ (1 << n)                   |
| Get least significant bit | i & -i                         |
| Multiply by 2^n | i << n                         |
| Divide by 2^n | i >> n                         |
| Mod by 2^n | i & (1<<n-1)                   |
| Is even | (i & 1) == 0                   |
| Is power of 2 | (i != 0) && (i & (i - 1)) == 0 |

### 405. Convert a Number to Hexadecimal
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/ConvertaNumbertoHexadecimal.scala#L4-L6

### 29. Divide Two Integers
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/DivideTwoIntegers.scala#L4-L12

### 78. Subsets
Bit manipulation for array less than 32, back tracking could also be used.
Explanation, assume for array of (1, 2), there will be 4 combinations, expressed as bit:

|Index| Bit | Element selected by index|
|---|---|---|
|0 | 0000 0000 | () |
|1 | 0000 0001 | (1) |
|2 | 0000 0010 | (2) |
|3 | 0000 0011 | (1,2) |
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/Subsets.scala#L6-L12

### 89. Gray Code
Recursive pattern, array of n consist array of (n-1) and reverse of array (n-1) with nth bit toggle to 1 

|Number| n-1 part | reverse of n-1 part with nth bit toggled | result |
|---|---|---|---|
|1 |  |  | 0 1 |
|2 | 00 01 | 11 10 | 0 1 3 2 |
|2 | 000 001 011 010 | 110 111 101 100 | 0 1 3 2 6 7 5 4 |
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/GrayCode.scala#L4-L6

### 136. Single Number
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/SingleNumber.scala#L5-L5

### 137. Single Number 2
A Hashmap could be used to count the number of occurrence of any number in the array.
Since additional data structure is not allow, a single Int is used as the result holder, check all 32 bits for all the number in the array.
Then set the bit back to the holder for all the 32 bits to get the final result.
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/SingleNumber2.scala#L4-L9

### 187. Repeated DNA
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/RepeatedDNASequences.scala#L6-L14

### 190. Reverse Bits
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/ReverseBits.scala#L4-L4

### 191. Number of 1 Bits
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/Numberof1Bits.scala#L4-L4