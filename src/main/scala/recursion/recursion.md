# Recursion
Recursion solves problems where the solution depends on solutions to smaller instances of the same problem by using functions that call themselves from within their own code.
- Works with tree/linked list etc. recursive data structures 
- Recursion could be converted to Iteration with **Stack**

### Implement the recursion function 
1. Identify recursion case => a problem could be resolved by re-apply same function
2. Identify exit condition with assumption the recursive function is already available
3. Call the same function with different but smaller problem recursively.

Add **helper function** and with additional variables to keep information
<br><br>

## Related data structure
- Linked List
- Tree
- Graph
<br><br>

## Related algorithm
- Dynamic programming: recursion with **memorized state** to reduce number of recursive calls
- Back tracking: recursion with immediate result to back track when encounter a dead end
<br><br>

## With recursive data structure
### 21. Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
```
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/MergeTwoSortedLists.scala#L6-L19

### 23. Merge K Sorted List
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
```
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
1->4->5,
1->3->4,
2->6
]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/MergeKSortedLists.scala#L7-L19

### 24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
```
Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/SwapNodesinPairs.scala#L6-L20

### 25. Reverse Nodes in K-Group 
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
```
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/ReverseNodesinkGroup.scala#L6-L23

### 87. Scramble String
We can scramble a string s to get a string t using the following algorithm:

* If the length of the string is 1, stop.
* If the length of the string is > 1, do the following:
* Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
* Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
* Apply step 1 recursively on each of the two substrings x and y.

Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
```
Example 1:
Input: s1 = "great", s2 = "rgeat"
Output: true

Example 2:
Input: s1 = "abcde", s2 = "caebd"
Output: false
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/ScrambleString.scala#L4-L13

### 10. Regular Expression Matching
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

* '.' Matches any single character.
* '*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).
```
Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
```
https://github.com/chuchunf/leetcode-scala-3/blob/4be5e022c498c9e65d022a46c7201e8dfd8cb650/src/main/scala/recursion/RegularExpressionMatching.scala#L4-L10
<br><br>

## Without recursive data structure
### 247. Strobogrammatic Number II
Given an integer n, return all the strobogrammatic numbers that are of length n. You may return the answer in any order.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
```
Example 1:
Input: n = 2
Output: ["11","69","88","96"]

Example 2:
Input: n = 1
Output: ["0","1","8"]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/StrobogrammaticNumber2.scala#L4-L8

### 60. Permutation Sequence 
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
```
"123"
"132"
"213"
"231"
"312"
"321"
```
Given n and k, return the kth permutation sequence.
```
Example 1:
Input: n = 3, k = 3
Output: "213"

Example 2:
Input: n = 4, k = 9
Output: "2314"
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/PermutationSequence.scala#L7-L19
