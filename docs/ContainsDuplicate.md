# Contains Duplicate
Contains duplicate is a series of problem to find if there is duplicate (elements with the same value) in the given array
1. Contains Duplicate: at least 1 duplicate exists in the array
2. Contains Duplicate II: at least 2 numbers within the given distance exist in the array 
3. Contains Duplicate III: more general case of 2, at least 2 numbers within given range AND within given distance exist in the array

<br>
<details>
<summary><b>Thinking progress</b></summary>

To detect the occurrence of a value in an array, it is basically a counter, hence Hashmap is an ideal data structure. Considering we only need to
detect the duplication not the number of occurrence, a Hashset serves the purpose.

For Contains Duplicate II, we have an additional constraint that, the duplication is within a given distance. The same idea could be applied,
the only change/improvement is that we need to manage the distance by add and remove element from the set when it enters and leaves the window.

For Contains Duplicate III, in additional to the constraint of distance, we also relax the rule on duplication. The duplication is defined as not 
the exact same value but within a given range. We can continue with the idea above that keep track of enter and exit of an element. However, 
for the duplication, a Hashmap could NOT be used directly. Instead, we could consider **the value range as a bucket and check the existence of bucket not 
the actual value**. NOTE the value of the map should be the mapped value / bucket to check for value range.

Hence, for Contains Duplicate III, it is an extension and combination of both I and II.
</details>
<br>

### 217. Contains Duplicate
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
```
Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false
```
https://github.com/chuchunf/leetcode-scala-3/blob/2bd3c67ebba6560cae2d1180a84826edae2a605c/src/main/scala/counting/ContainsDuplicate.scala#L4-L6

### 219. Contains Duplicate II
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
```
Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/ContainsDuplicate2.scala#L6-L11

### 220. Contains Duplicate III
You are given an integer array nums and two integers indexDiff and valueDiff.

Find a pair of indices (i, j) such that:
```
i != j,
abs(i - j) <= indexDiff.
abs(nums[i] - nums[j]) <= valueDiff, and
```
Return true if such pair exists or false otherwise.
```
Example 1:
Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
Output: true

Example 2:
Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
Output: false
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bucketsort/ContainsDuplicate3.scala#L6-L19

