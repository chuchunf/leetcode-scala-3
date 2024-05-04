# Valid Palindrome
Palindrome is a word, phrase, or sequence that reads the same backwards as forwards, 
this problem series is around detect Palindrome in a string with different constraints.
1. 125 Valid Palindrome: valid if a string is a Palindrome
2. 2330 Valid Palindrome IV: valid if a string is a Palindrome after changing 1 or 2 characters
3. 680 Valid Palindrome II: valid if a string is a Palindrome after deleting 1 character
4. 1216 Valid Palindrome III: valid if a string is a Palindrome after deleting k characters

<br>
<details>
<summary><b>Thinking progress</b></summary>

The first Valid Palindrome is quite straightforward, just test the definition of Palindrome with **two pointers**

For the Valid Palindrome VI, we are able to change any character, in other word, when we find a mismatch, we could change it to the matching character.
Hence, this problem is the same as to count how many mismatch are there and compare with the number of time we could change, 
following the same **two pointer** approach with a counter.

However, Valid Palindrome II is different from Valid Palindrome VI, we can only skip character, not change it. 
We will have to consider both cases for a mismatch, either skip left or right.

Valid Palindrome III is a more general case of Valid Palindrome II, we can skip k number of characters instead of just 1. 
Considering Valid Palindrome II's recursive approach, we could use **DP**, i.e. recursive with cached result to avoid re-calculation of known result.

</details>
<br>

### 125. Valid Palindrome
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
```
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: s = "race a car"
Output: false
```
https://github.com/chuchunf/leetcode-scala-3/blob/fbb1058c922a34c505b17a2824ef73aaf94035d9/src/main/scala/twopointers/ValidPalindrome.scala#L4-L14

### 2330. Valid Palindrome IV
You are given a 0-indexed string s consisting of only lowercase English letters. In one operation, you can change any character of s to any other character.

Return true if you can make s a palindrome after performing exactly one or two operations, or return false otherwise.
```
Example 1:
Input: s = "abcdba"
Output: true

Example 3:
Input: s = "abcdef"
Output: false
```
https://github.com/chuchunf/leetcode-scala-3/blob/fbb1058c922a34c505b17a2824ef73aaf94035d9/src/main/scala/twopointers/ValidPalindrome4.scala#L4-L15

### 680. Valid Palindrome II
Given a string s, return true if the s can be palindrome after deleting at most one character from it.
```
Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
```
https://github.com/chuchunf/leetcode-scala-3/blob/fbb1058c922a34c505b17a2824ef73aaf94035d9/src/main/scala/twopointers/ValidPalindrome2.scala#L4-L15

### 1216. Valid Palindrome III
Given a string s and an integer k, return true if s is a k-palindrome.

A string is k-palindrome if it can be transformed into a palindrome by removing at most k characters from it.
```
Example 1:
Input: s = "abcdeca", k = 2
Output: true
Explanation: Remove 'b' and 'e' characters.

Example 2:
Input: s = "abbababa", k = 1
Output: true
```
https://github.com/chuchunf/leetcode-scala-3/blob/5697ddae4873117b87cea42335eb52b5b037cb75/src/main/scala/dp/ValidPalindrome3.scala#L6-L18
