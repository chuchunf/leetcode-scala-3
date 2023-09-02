# Binary Search
**Binary search** / half-interval search / logarithmic search finds the position of a target value within a **sorted** data structure.
1. It compares the target value to the middle element of the array. 
2. If they are not equal, the half in which the target cannot lie is eliminated 
3. And the search continues on the remaining half, 
4. And repeats the process.

**Binary Search should be considered for searching** for an index or element. 
If the collection is unordered, sort it first before applying Binary Search.

Binary search could be implemented iteratively or recursively.

### Tips
- calculate mid by low + (high-low)/2 to prevent overflow
- starting with low=1, high=length-1, repeat while low <= high 
- depending on comparison with target, low = mid + 1 or high = mid - 1
- consider all possible cases for partially sorted arrays

## Related data structures
1. Binary search tree (BST)
2. Array

### 69. Sqrt(x)
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/binarysearch/Sqrt.scala#L4-L11

### 34. Find First and Last Position of Element in Sorted Array
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/binarysearch/FindFirstAndLastPositionInSortedArray.scala#L4-L14

### 33. Search in Rotated Sorted Array
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/binarysearch/SearchinRotatedSortedArray.scala#L4-L15

### 81. Search in Rotated Sorted Array II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/binarysearch/SearchinRotatedSortedArray2.scala#L4-L14

### 153. Find Minimum in Rotated Sorted Array
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/binarysearch/FindMinimuminRotatedSortedArray.scala#L4-L11

### 154. Find Minimum in Rotated Sorted Array II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/binarysearch/FindMinimuminRotatedSortedArray2.scala#L4-L14

### 35. Search Insert Position
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/binarysearch/SearchInsertPosition.scala#L4-L12

### 278. First Bad Version
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/binarysearch/FirstBadVersion.scala#L8-L15

### 4. Median of Two Sorted Arrays
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/binarysearch/MedianofTwoSortedArrays.scala#L7-L25

### 162. Find Peak Element
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/binarysearch/FindPeakElement.scala#L4-L13

### 275. H-Index II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/binarysearch/HIndex2.scala#L4-L10
