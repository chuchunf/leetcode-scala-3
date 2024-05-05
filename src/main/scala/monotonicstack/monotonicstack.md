# Monotonic Stack
A monotonic stack is a stack whose elements are monotonically increasing or decreasing, 
It is commonly used to track the **maximum or minimum** element in a data set.

## implementation 
* The index is stored in the stack and forms a mono-sequence, either increasing or decreasing
* Pop the smaller/bigger elements from the stack before pushing a new element 
```scala
  while !stk.isEmpty && arr(stk.top) <= arr(i) do 
    stk.pop
    {logic}
  stk.push(i)
```
* Apply logic accordingly given the property of Monotonic stack

## Applications
The monotonic stack commonly solves the previous/next smaller/larger problem.
* Next greater: monotonic decreasing stack, pop the stack if the value (of top of the stack) is smaller than current => the next greater of top of the stack is the current index
* Previous greater: same as above in reversed order

## Relationship with other data structures
1. **Stack**: Monotonic stack is a stack with a property that the elements are monotonically increasing or decreasing. 
2. **Priority Queue**: Monotonic stack maintains the monotonicity by **dequeuing** elements when a new element e is enqueued, while a priority queue maintains the monotonicity by **heapifying** when a new element enqueued
3. **Monotonic Queue**: Both maintains the monotonicity but one based on Queue (FIFO), another based on Stack (FILO)
<br><br>

### 496. Next Greater Element I
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
```
Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
```
https://github.com/chuchunf/leetcode-scala-3/blob/6c7f452d855f00ae43efec08f9661798e3d0e901/src/main/scala/monotonicstack/NextGreaterElement.scala#L4-L13

### 503. Next Greater Element II
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
```
Example 1:
Input: nums = [1,2,1]
Output: [2,-1,2]

Example 2:
Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
```
https://github.com/chuchunf/leetcode-scala-3/blob/23bd0fa0f6e97e8839a53385efb0b53d9a37c086/src/main/scala/monotonicstack/NextGreaterElement2.scala#L4-L12

### 556. Next Greater Element III
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
```
Example 1:
Input: n = 12
Output: 21

Example 2:
Input: n = 21
Output: -1
```
TODO

### 84. Largest Rectangle in Histogram
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
```
Example 1: 
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4
```
https://github.com/chuchunf/leetcode-scala-3/blob/6c7f452d855f00ae43efec08f9661798e3d0e901/src/main/scala/monotonicstack/LargestRectangleinHistogram.scala#L6-L17
