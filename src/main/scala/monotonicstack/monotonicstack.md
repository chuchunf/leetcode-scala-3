# Monotonic Stack
A monotonic stack is a stack whose elements are monotonically increasing or decreasing, 
normally used to track the **maximum or minimum** element in a data set.

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
The monotonic stack mainly solves the previous/next smaller/larger problem.
* Next greater: monotonic decreasing stack, pop the stack if the value (of top of the stack) is smaller than current => the next greater of top of the stack is the current index
* Previous greater: same as above in reversed order

## Relationship with other data structures
1. **Stack**: Monotonic stack is a stack with a property that the elements are monotonically increasing or decreasing. 
2. **Priority Queue**: Monotonic stack maintains the monotonicity by **dequeuing** elements when a new element e is enqueued, while a priority queue maintains the monotonicity by **heapifying** when a new element enqueued
3. **Monotonic Queue**: Both maintains the monotonicity but one based on Queue (FIFO), another based on Stack (FILO)

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

### 316. Remove Duplicate Letters
Given a string s, remove duplicate letters so that every letter appears once and only once. 
You must make sure your result is the smallest in lexicographical order among all possible results.
```
Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"
```
to be added

### 456. 132 Pattern
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.
```
Example 1:
Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.

Example 2:
Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
```
to be added

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
