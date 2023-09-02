# Sort
a collection of common sort algorithms and sort related problems

## Quick Sort
1. Use right most as pivot; 
2. Find a number bigger than the pivot from left;
3. Find a number smaller than the pivot from right;
4. Swap them; 
5. Once done, join the left, pivot and right; 
6. Continue with left and right portion until the sub array contains 0 or 1 element

## Merge Sort
1. Splits the array in half until it cannot be further divided (empty or 1 element)
2. Merge the two sorted arrays into a large sorted array  

### 148. Sort List
merge sort, divide and merge (sort)
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/sort/SortList.scala#L6-L34

### 49. Group Anagrams
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/sort/GroupAnagrams.scala#L6-L9

### 56. Merge Intervals
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/sort/MergeIntervals.scala#L7-L13
