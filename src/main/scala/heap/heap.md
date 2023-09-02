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

### 506. Relative Ranks
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/heap/RelativeRanks.scala#L4-L14

### 264. Ugly Number II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/heap/UglyNumber2.scala#L4-L13

### 215. Kth Largest Element in an Array
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/heap/KthLargestElementinanArray.scala#L4-L7

### 23. Merge K sorted list
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/MergeKSortedLists.scala#L22-L37

### 218. The Skyline
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/heap/TheSkylineProblem.scala#L6-L22