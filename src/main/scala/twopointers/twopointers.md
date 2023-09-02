# Two Pointers
Two-pointers algorithm is an easy and effective technique for a **sorted sequence**, such as an array or a linked list.
Common scenarios are **find the min/max/equals/closest** in a **range defined by the two pointers**

- It could be from the same direction or matching towards the centre
- The technique deals with a **continuous** range
- Move two pointers **independently**, each depends on the condition of the problem

**Identifying the condition of moving the pointer** is the key to use this technique
- Longest unique string => find/not-find repeating character
- Container with Most water => move the point which is not smaller than current
- Trap water fall => the water will flow from the lower part, and we start again when encountering a higher bar.

### Related Algorithms
- **Slow fast pointers** is a variant of this technique, for which two pointers move at a different speed.
- **Sliding windows** can be implemented with a single pointer and a variable for window size. Typically, all the elements within the window will be used (e.g. sum of the window)

### 3. Longest Substring Without Repeating Characters
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/LengthOfLongestSubString.scala#L6-L12

### 11. Container With Most Water
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/ContainerWithMostWater.scala#L4-L10

### 16. 3Sum Closest
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/ThreeSumClosest.scala#L4-L15

### 209. Minimum Size Sub array Sum
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/MinimumSizeSubarraySum.scala#L4-L21

### 42. Trapping Rain Water
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/TrappingRainWater.scala#L4-L19

### 15. 3Sum
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/ThreeSum.scala#L6-L23

### 28. Implement strStr()
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/ImplementstrStr.scala#L4-L9

### 75. Sort Colors
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/SortColors.scala#L4-L18

### 80. Remove Duplicates from Sorted Array II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/RemoveDuplicatesfromSortedArrayII.scala#L4-L18

### 167. Two Sum II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/TwoSumII.scala#L4-L9

### 159. Longest Substring with At Most Two Distinct Characters
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/LongestSubstringwithAtMostTwoDistinctCharacters.scala#L6-L16

### 228. Summary Ranges
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/SummaryRanges.scala#L6-L14

### 443. String Compression
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/StringCompression.scala#L4-L14

### 219. Contains Duplicate II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/twopointers/ContainsDuplicate2.scala#L6-L11
