# Stack
A stack is an abstract data type that serves as a collection of elements, supporting two basic operations,
1. **Push** to add an element to the top
2. **Pop** to remove the most recently pushed element out.

Additionally, a peek operation may give access to the top without modifying the stack

## Implementation
- Stack could be implemented using a **linked list** or an array

## Usages
1. Reverse the order of collections
2. Stack data structures are used in **backtracking problems**, elements could be pushed in for later processing.
   Unlike the backtracking technique, the stack normally holds conditions not the actual result
   - Matching parentheses => backtrack of unmatched pair
   - Stock span => backtrack to the previous height
   - The shortest unsorted array => backtrack to the previous unsorted
3. Stack has similar usage as hashmap to **reduce the O(n) to O(1)**.
   Hashmap works when we just need to know the existence instead of the actual operation of each item,
   Stack works when the **natural order of processing is FILO** (Similar usage for Queue for FIFO order)
   - Evaluate Reverse Polish Notation => next element need to be processed is last in
   - Valid Parentheses => next element that needs to be matched is last in
4. Processing Function Calls => convert recursion to iteration

## Tips
* Store the index instead of the actual value as the value could be accessed by index
<br><br>

## Implementation
### 155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:
* MinStack() initializes the stack object. 
* void push(int val) pushes the element val onto the stack. 
* void pop() removes the element on the top of the stack. 
* int top() gets the top element of the stack. 
* int getMin() retrieves the minimum element in the stack.

You must implement a solution with O(1) time complexity for each function.
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/MinStack.scala#L6-L27
<br><br>

## Backtrack previous element
### 20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
* Open brackets must be closed by the same type of brackets.
* Open brackets must be closed in the correct order.
* Every close bracket has a corresponding open bracket of the same type.
```
Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/ValidParentheses.scala#L4-L11

### 901. Online Stock Span
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
```
Example 1:
Input: ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output: [null, 1, 1, 1, 2, 1, 4, 6]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/OnlineStockSpan.scala#L6-L19

### 32. Longest Valid Parentheses
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
```
Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/LongestValidParentheses.scala#L4-L17

### 581. Shortest Unsorted Continuous Subarray 
Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.

Return the shortest such subarray and output its length.
```
Example 1:
Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Example 2:
Input: nums = [1,2,3,4]
Output: 0
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/ShortestUnsortedContinuousSubarray.scala#L4-L14


## Applications
### 150. Evaluate Reverse Polish Notation
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

* The valid operators are '+', '-', '*', and '/'.
* Each operand may be an integer or another expression.
* The division between two integers always truncates toward zero.
* There will not be any division by zero.
* The input represents a valid arithmetic expression in a reverse polish notation.
* The answer and all the intermediate calculations can be represented in a 32-bit integer.
```
Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/EvaluateReversePolishNotation.scala#L4-L13

### 71. Simplify Path
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
```
Example 1:
Input: path = "/home/"
Output: "/home"

Example 2:
Input: path = "/../"
Output: "/"
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/SimplifyPath.scala#L4-L13

### 394. Decode String
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
```
Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/stack/DecodeString.scala#L4-L24