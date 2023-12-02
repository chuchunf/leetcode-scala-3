# Counting (Sort)
**Counting** is a simple and effective technique when dealing with numeric arrays,
by counting the number of occurrences of each unique element in the array.

The count is stored in an auxiliary array, and the **counting sort** is done by mapping the count to an index of the auxiliary array

- It is not a comparison-based sorting.
- Its running time complexity is O(n) with space complexity O(k).
- It can be considered as a special kind of hashing (hashmap), key-value maps to index directly (without hashing function)

## Applications
- There are **smaller integers with multiple counts**.
- Linear complexity is the need.

## Related Algorithms
- **Bucket Sort** or bin sort, works by distributing the elements of an array into several buckets.
  Each bucket is then sorted individually. Counting sort stores a single number (the count of items) per bucket.

## Related Data structures
- Array => Counting sort
- Hashmap => Counting

### 383. Ransom Note
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.
```
Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/counting/RansomNote.scala#L6-L10

### 169. Majority Element
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
```
Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```
[Boyer-Moore Majority Vote Algorithm](http://www.cs.utexas.edu/~moore/best-ideas/mjrty/)
* The algorithm depends on there is a majority
* Which can be easier validated with a 2nd pass of counting
  https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/counting/MajorityElement.scala#L4-L9

### 229. Majority Element 2
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
```
Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/counting/MajorityElement2.scala#L4-L12

### 358. Rearrange String k Distance Apart
Given a string s and an integer k, rearrange s such that the same characters are at least distance k from each other. If it is not possible to rearrange the string, return an empty string "".
```
Example 1:
Input: s = "aabbcc", k = 3
Output: "abcabc"
Explanation: The same letters are at least a distance of 3 from each other.

Example 2:
Input: s = "aaabc", k = 3
Output: ""
Explanation: It is not possible to rearrange the string.

Example 3:
Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
Explanation: The same letters are at least a distance of 2 from each other.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/counting/RearrangeStringkDistanceApart.scala#L6-L21

