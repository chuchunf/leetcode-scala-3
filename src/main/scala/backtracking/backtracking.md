# Back Tracking
Backtracking is a general algorithm for finding/searching existence of **all (or some) solutions** of problems, by **exploring all potential candidates**.

Backtracking incrementally builds candidates to the solutions, 
abandons each partial candidate as soon as it determines that the candidate is not a valid solution, 
and resume from last good point (hence **“backtracks”**)
- Backtracking is essentially **recursive with memorizing of past result** (with a collection and indexes passing in recursive calls) 
- Backtracking normally requires a **helper recursive function** with additional parameters to keep track intermedia states and finally result
- Backtracking helper function process all the intermedia states as parameters, so it normally returns none

### Using N Queens as an example
```scala
private def _solveNQueens(current: Int, n: Int, buffer: mutable.ListBuffer[Int], result: mutable.ListBuffer[List[String]]): Unit
```
- **current** is the recursive value
- **n** is the target value to stop the recursion 
- **buffer** keep track of current partial result as of **current**
- **result** to store all solutions identified
- **no returns** as all states are managed via parameters during recursive calls

As all recursive functions, the helper function contains two parts, first part breaks the recursion when we identify a successful solution
```scala
case num if num == n => result.addOne(buffer.foldLeft(mutable.ListBuffer[String]()) { case (b, i) => b.addOne(".".repeat(n).updated(i, 'Q')) }.toList)
```
Otherwise, **identify all possible next candidates and call the helper function recursively**
```scala
    case _ => for (i <- 0 until n if !buffer.contains(i) && !buffer.zipWithIndex.foldLeft(false) { case (r, (v, idx)) => r || (i - (current - idx)) == v || (i + (current - idx)) == v }) {
      buffer.addOne(i)
      _solveNQueens(current + 1, n, buffer, result)
      buffer.remove(buffer.length - 1)
    }
```
**NOTE important** the partial result need to be rolled back after the resursive call
```scala
      buffer.remove(buffer.length - 1)
```

### Tips
- Use any/some intermedia state variables as long as they keep the partial states 
- Change a cell value to indicate visited state and revert it after recursive call
<br><br>

### 22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
```
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
```
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/GenerateParentheses.scala#L6-L15

### 40. Combination Sum II
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
```
Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
```
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/CombinationSum2.scala#L6-L17

### 46. Permutations
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
```
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
```
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/Permutations.scala#L6-L17

### 17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
```
Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
```
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/LetterCombinationsofaPhoneNumber.scala#L6-L14

### 47. Permutations II
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
```
Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
[1,2,1],
[2,1,1]]
```
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/Permutations2.scala#L6-L13

### 77. Combinations
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.
```
Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
```
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/Combinations.scala#L6-L15

### 79. Word Search
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
```
Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
```
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/WordSearch.scala#L4-L22

### 93. Restore IP Addresses
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
```
Example 1:
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
```
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/RestoreIPAddresses.scala#L6-L16

### 51. N-Queens
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
```
Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
```
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/NQueens.scala#L6-L19

### 52. N-Queens 2
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.
```
Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
```
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/NQueens2.scala#L7-L23
