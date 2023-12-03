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

### 405. Convert a Number to Hexadecimal // conversion // easy
Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

Note: You are not allowed to use any built-in library method to directly solve this problem.
```
Example 1:
Input: num = 26
Output: "1a"

Example 2:
Input: num = -1
Output: "ffffffff"
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/ConvertaNumbertoHexadecimal.scala#L4-L6

### 29. Divide Two Integers //   // Medium 
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.
```
Example 1:
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.

Example 2:
Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/DivideTwoIntegers.scala#L4-L12

### 78. Subsets
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
```
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
```
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
An n-bit gray code sequence is a sequence of 2n integers where:

Every integer is in the inclusive range [0, 2n - 1],
The first integer is 0,
An integer appears no more than once in the sequence,
The binary representation of every pair of adjacent integers differs by exactly one bit, and
The binary representation of the first and last integers differs by exactly one bit.
Given an integer n, return any valid n-bit gray code sequence.
```
Example 1:
Input: n = 2
Output: [0,1,3,2]
Explanation:
The binary representation of [0,1,3,2] is [00,01,11,10].
- 00 and 01 differ by one bit
- 01 and 11 differ by one bit
- 11 and 10 differ by one bit
- 10 and 00 differ by one bit
  [0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
- 00 and 10 differ by one bit
- 10 and 11 differ by one bit
- 11 and 01 differ by one bit
- 01 and 00 differ by one bit
```
Recursive pattern, array of n consist array of (n-1) and reverse of array (n-1) with nth bit toggle to 1 

|Number| n-1 part | reverse of n-1 part with nth bit toggled | result |
|---|---|---|---|
|1 |  |  | 0 1 |
|2 | 00 01 | 11 10 | 0 1 3 2 |
|2 | 000 001 011 010 | 110 111 101 100 | 0 1 3 2 6 7 5 4 |
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/GrayCode.scala#L4-L6

### 136. Single Number
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
```
Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/SingleNumber.scala#L5-L5

### 137. Single Number 2
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.
```
Example 1:
Input: nums = [2,2,3,2]
Output: 3

Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99
```
A Hashmap could be used to count the number of occurrence of any number in the array.
Since additional data structure is not allow, a single Int is used as the result holder, check all 32 bits for all the number in the array.
Then set the bit back to the holder for all the 32 bits to get the final result.
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/SingleNumber2.scala#L4-L9

### 187. Repeated DNA
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence. When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
```
Example 1:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/RepeatedDNASequences.scala#L6-L14

### 190. Reverse Bits
Reverse bits of a given 32 bits unsigned integer.
```
Example 1:
Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, 
so return 964176192 which its binary representation is 00111001011110000010100101000000.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/ReverseBits.scala#L4-L4

### 191. Number of 1 Bits
Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
```
Example 1:
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

Example 2:
Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bit/Numberof1Bits.scala#L4-L4