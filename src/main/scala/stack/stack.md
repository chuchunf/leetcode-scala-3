# Stack
A stack is an abstract data type that serves as a collection of elements, supporting two basic operations, 
Push to add an element and Pop to remove the most recently pushed element out. 
Additionally, a peek operation may give access to the top without modifying the stack
- Stack could be implemented use a linked list or an array
- Stack data structures are used in backtracking problems, elements could be pushed in for later processing
  - Unlike back tracking technique, stack normally holds conditions not actual result
  - Matching parentheses => back track of unmatched pair
  - Stock span => back track to the previous height
  - The shortest unsorted array => back track to the previous unsorted
- Stack has similar usage as hashmap to reduce the O(n) to O(1)
  - Hashmap works when we just need to know existence instead of actual operation of each item
  - Stack works when we only need to know the local optimal value related to the problem

### 155. Min Stack
\```:scala:MinStack.scala
\```

### 20. Valid Parentheses
\```:scala:ValidParentheses.scala
\```

### 901. Online Stock Span
\```:scala:OnlineStockSpan.scala
\```

### 581. Shortest Unsorted Continuous Subarray
\```:scala:ShortestUnsortedContinuousSubarray.scala
\```