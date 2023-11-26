# Recursion
Recursion solves problems where the solution depends on solutions to smaller instances of the same problem by using functions that call themselves from within their own code.
- Works with tree/linked list etc. recursive data structures 
- Recursion could be converted to Iteration with **Stack**

### Implement the recursion function 
1. Identify recursion case => a problem could be resolved by re-apply same function
2. Identify exit condition with assumption the recursive function is already available
3. Call the same function with different but smaller problem recursively.

Add **helper function** and with additional variables to keep information

## Related data structure
- Linked List
- Tree

## Related algorithm
- Dynamic programming: recursion with **memorized state** to reduce number of recursive calls
- Back tracking: recursion with immediate result to back track when encounter a dead end

### 21. Merge Two Sorted Lists
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/MergeTwoSortedLists.scala#L6-L19

### 24. Swap Nodes in Pairs
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/SwapNodesinPairs.scala#L6-L20

### 25. Reverse Nodes in K-Group
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/ReverseNodesinkGroup.scala#L6-L23

### 60. Permutation Sequence
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/PermutationSequence.scala#L7-L19

### 23. Merge K Sorted List
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/MergeKSortedLists.scala#L7-L19

### 247. Strobogrammatic Number II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/StrobogrammaticNumber2.scala#L4-L8

### 87. Scramble String
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/recursion/ScrambleString.scala#L4-L13