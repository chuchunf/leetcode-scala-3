# Stack
A stack is an abstract data type that serves as a collection of elements, supporting two basic operations,
1. **Push** to add an element to the top
2. **Pop** to remove the most recently pushed element out.

Additionally, a peek operation may give access to the top without modifying the stack

## Implementation
- Stack could be implemented using a **linked list** or an array

## Applications
1. Stack data structures are used in **backtracking problems**, elements could be pushed in for later processing.
   Unlike the backtracking technique, the stack normally holds conditions not the actual result
   - Matching parentheses => backtrack of unmatched pair
   - Stock span => backtrack to the previous height
   - The shortest unsorted array => backtrack to the previous unsorted
2. Stack has similar usage as hashmap to **reduce the O(n) to O(1)**.
   Hashmap works when we just need to know the existence instead of the actual operation of each item,
   Stack works when the **natural order of processing is FILO**
   - Evaluate Reverse Polish Notation => next element need to be processed is last in
   - Valid Parentheses => next element that needs to be matched is last in
3. Reverse of element order
4. Processing Function Calls => convert recursion to iteration

## Tips
1. Store the index instead of the actual value

### 155. Min Stack
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/MinStack.scala#L6-L27

### 20. Valid Parentheses
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/ValidParentheses.scala#L4-L11

### 901. Online Stock Span
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/OnlineStockSpan.scala#L6-L19

### 581. Shortest Unsorted Continuous Subarray
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/ShortestUnsortedContinuousSubarray.scala#L4-L14

### 150. Evaluate Reverse Polish Notation
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/EvaluateReversePolishNotation.scala#L4-L13

### 32. Longest Valid Parentheses
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/LongestValidParentheses.scala#L4-L17

### 71. Simplify Path
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/SimplifyPath.scala#L4-L13

### 394. Decode String
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/DecodeString.scala#L4-L24