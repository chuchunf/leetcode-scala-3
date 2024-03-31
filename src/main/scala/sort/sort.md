# Sort
a collection of common sort algorithms and sort related problems

## Quick Sort
1. Use right most as pivot; 
2. Find a number bigger than the pivot from left;
3. Find a number smaller than the pivot from right;
4. Swap them; 
5. Once done, join the left, pivot and right; 
6. Continue with left and right portion until the sub array contains 0 or 1 element
<br><br>

## Merge Sort
1. Splits the array in half until it cannot be further divided (empty or 1 element)
2. Merge the two sorted arrays into a large sorted array  
<br><br>

### 148. Sort List => merge sort
Given the head of a linked list, return the list after sorting it in ascending order.
```
Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
```
merge sort, divide and merge (sort)
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/sort/SortList.scala#L6-L34

### 49. Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
```
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/sort/GroupAnagrams.scala#L6-L9

### 56. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
```
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/sort/MergeIntervals.scala#L7-L13
