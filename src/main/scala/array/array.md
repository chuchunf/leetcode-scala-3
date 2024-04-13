# Array
**Array** is a container that can hold a fixed number of items sequentially and these items should be of the same type.
The elements of the array could be accessed by index.
The simplest type of data structure is a linear array, also called a one-dimensional array.
A **matrix** can be represented as a two-dimensional

## Related Data Structures
* Convert from/to other 1d data structures such as **linked list, queue, or stack**
* implementation of 2d and high dimensional data structure such as **matrix**
* implementation of **hashmap, hashset, queue, stack, and string**
* implementation of **heap (priority queue)**
* implementation of dynamic memory allocation, memory pool, and control table (jumper)

## Related Algorithms
* Binary search
* Two pointers / Sliding windows
* Recursion
* Dynamic programming
* Prefix sum

## Common approaches
* sort could simplify the 1d data structure
* if 1 pass could not solve a problem, try multiple passes and collect more information during each pass
<br><br>

## In-place manipulation
In place manipulation of array without any additional space
### 26. Remove Duplicates from Sorted Array => easy => in place
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
```
Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
```
https://github.com/chuchunf/leetcode-scala-3/blob/92b3d76a55d80580bf31904e16207bce7fdc6c89/src/main/scala/array/RemoveDuplicatesfromSortedArray.scala#L4-L10

### 283. Move Zeroes
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
```
Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
```
https://github.com/chuchunf/leetcode-scala-3/blob/266e54bf7a1705a4aa17987f8182d9e375eaa2e3/src/main/scala/array/MoveZeroes.scala#L4-L13
<br><br>

## Swap or reverse
Swap elements with index within the same or different arrays, revere is also a swap operation.
### 88. Merge Sorted Array 
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.
```
Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
```
https://github.com/chuchunf/leetcode-scala-3/blob/266e54bf7a1705a4aa17987f8182d9e375eaa2e3/src/main/scala/array/MergeSortedArray.scala#L4-L13

### 151. Reverse Words in a String
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
```
Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
```
https://github.com/chuchunf/leetcode-scala-3/blob/266e54bf7a1705a4aa17987f8182d9e375eaa2e3/src/main/scala/array/ReverseWordsinaString.scala#L6-L43

### 189. Rotate Array
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
```
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
```
Rotation could be archived via reverse
https://github.com/chuchunf/leetcode-scala-3/blob/266e54bf7a1705a4aa17987f8182d9e375eaa2e3/src/main/scala/array/RotateArray.scala#L4-L16
<br><br>

## Others
### 121. Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
```
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
```
https://github.com/chuchunf/leetcode-scala-3/blob/266e54bf7a1705a4aa17987f8182d9e375eaa2e3/src/main/scala/array/BestTimetoBuyandSellStock.scala#L4-L12

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
https://github.com/chuchunf/leetcode-scala-3/blob/266e54bf7a1705a4aa17987f8182d9e375eaa2e3/src/main/scala/array/Subsets.scala#L6-L14

### 945. Minimum Increment to Make Array Unique 
You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

Return the minimum number of moves to make every value in nums unique.

The test cases are generated so that the answer fits in a 32-bit integer.
```
Example 1:
Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].

Example 2:
Input: nums = [3,2,1,2,1,7]
Output: 6
```
https://github.com/chuchunf/leetcode-scala-3/blob/266e54bf7a1705a4aa17987f8182d9e375eaa2e3/src/main/scala/array/MinimumIncrementtoMakeArrayUnique.scala#L4-L16
