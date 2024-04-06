# Heap (priority queue)
The **(binary) heap** is one maximally efficient implementation of an abstract data type **priority queue**.
In fact priority queues are often referred to as "heaps", regardless of how they may be implemented.
- In a heap, the highest (or lowest) priority element is always stored at the root. 
- However, a heap is not a sorted structure; it can be regarded as being **partially ordered**. 

A heap is a useful data structure when it is necessary to repeatedly remove the object with the highest (or lowest) priority, 
or when insertions need to be interspersed with removals of the root node.

Heap can be considered as an alternative data structure of queue/stack that instead of maintain in/out order,
it maintains **an user controlled order** (for example, min and max)

### Implementation
Heap can be implemented as an array with following properties
- parent = Arr[(i-1) / 2]
- left = Arr[(2*i) + 1]
- right = Arr[(2*i) + 2]

### Operation
1. insert: insert an new element
2. delete: remove the root element
3. **heapifiy**: reorder the heap after insertion/deletion to maintain the partial order

### Heapitify
Parent is the smallest/biggest value, when insert or remove, heapitify function called to maintain the partial order of the heap
1. reduce size and move the last element as root
2. start heapifiy process at 0 (root)
3. compare left, right and parent (root)
4. swap with value at largest 
5. recursive heapifty at from largest

### Usages
1. Heap Sort uses Binary Heap to sort an array in O(nLogn) time.
2. Priority queue to get min/max (user defined order) element in O(nLogn) time. 
<br><br>

### 506. Relative Ranks
You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

* The 1st place athlete's rank is "Gold Medal".
* The 2nd place athlete's rank is "Silver Medal".
* The 3rd place athlete's rank is "Bronze Medal".
* For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").

Return an array answer of size n where answer[i] is the rank of the ith athlete.
```
Example 1:
Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/heap/RelativeRanks.scala#L4-L14

### 264. Ugly Number II
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.
```
Example 1:
Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/heap/UglyNumber2.scala#L4-L13

### 215. Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?
```
Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/heap/KthLargestElementinanArray.scala#L4-L7

### 23. Merge K sorted list
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
merging them into one sorted list:
1->1->2->3->4->4->5->6
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/MergeKSortedLists.scala#L22-L37

### 218. The Skyline
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.

The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:

* lefti is the x coordinate of the left edge of the ith building.
* righti is the x coordinate of the right edge of the ith building.
*  heighti is the height of the ith building.

You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.

Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]
```
Example 1:
Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/heap/TheSkylineProblem.scala#L6-L22