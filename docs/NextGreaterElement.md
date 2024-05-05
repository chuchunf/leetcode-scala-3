# Next Greater Element
Next Greater Element is a series of problem to find next greater number of a given array or integer, 
Monotonic stack is the standard way to solve such problems.
* Next Greater Element I: find next greater number of a given array by index
* Next Greater Element II: find next greater number of a given **circular** array
* Next Greater Element III: find next greater number by re-arrange the digits of given integer

<br>
<details>
<summary><b>Thinking progress</b></summary>

The next greater element asks for the next greater element of array 2 in array 1, 
so it can be reduced to find the next greater element in array 1, then look up the next element from array 2, which could be done via a Hashmap.

To get the next greater element, we need to maintain a list of elements for comparison with current, a list is feasible however we need to loop through the entire list and
result to a N^2 complexity. A stack (a monotonic stack as we maintain the order of the stack) is a better data structure as at any time we only loop it once.

The next greater element II is exactly the same but it is a circular array, so we just need to loop it twice to allow the last element to compare with the list again.

The next greater element III, in fact, is not the same scenario, it requires to re-arrange the digits to find the next greater number.
But it can again be solved with monotonic stack, we check the digits in a reversed order, find the first digit which is greater than next and switch them.
Noted we will need to sort the digits in stack to find the max in order to get the **next** greater number.

</details>
<br>

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
https://github.com/chuchunf/leetcode-scala-3/blob/27ec8d426c9af1122099ba8900b0da7872e30e7b/src/main/scala/monotonicstack/NextGreaterElement3.scala#L4-L15
