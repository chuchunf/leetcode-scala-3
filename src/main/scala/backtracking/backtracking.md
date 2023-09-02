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

### 22. Generate Parentheses
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/GenerateParentheses.scala#L6-L15

### 40. Combination Sum II
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/CombinationSum2.scala#L6-L17

### 46. Permutations
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/Permutations.scala#L6-L17

### 10. Regular Expression Matching
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/RegularExpressionMatching.scala#L4-L10

### 17. Letter Combinations of a Phone Number
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/LetterCombinationsofaPhoneNumber.scala#L6-L14

### 47. Permutations II
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/Permutations2.scala#L6-L13

### 51. N-Queens
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/NQueens.scala#L6-L19

### 52. N-Queens 2
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/NQueens2.scala#L7-L23

### 77. Combinations
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/Combinations.scala#L6-L15

### 79. Word Search
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/WordSearch.scala#L4-L22

### 93. Restore IP Addresses
https://github.com/chuchunf/leetcode-scala-3/blob/5fdab853b600bb2b90b43c81620596a9695a2aef/src/main/scala/backtracking/RestoreIPAddresses.scala#L6-L16