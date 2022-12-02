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
```scala
  def generateParenthesis(n: Int): List[String] =
    val cache = mutable.ListBuffer[String]()
    generateParenthesisInternal(cache, "", 0, 0, n)
    cache.toList

  private def generateParenthesisInternal(cache: mutable.ListBuffer[String], tmp: String, open: Int, close: Int, max: Int): Unit =
    if open == max && close == max then cache.append(tmp)
    else
      if open < max then generateParenthesisInternal(cache, tmp + "(", open + 1, close, max)
      if close < open then generateParenthesisInternal(cache, tmp + ")", open, close + 1, max)
```

### 40. Combination Sum II
```scala
  def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] =
    val (nums, result) = (candidates.sorted, mutable.ListBuffer[List[Int]]())
    combine(nums, 0, target, mutable.ListBuffer[Int](), result)
    result.toList

  private def combine(nums: Array[Int], i: Int, required: Int, tmp: mutable.ListBuffer[Int], result: mutable.ListBuffer[List[Int]]): Unit =
    required match
      case r if r < 0 =>
      case 0 => result.append(tmp.toList)
      case r if r > 0 => for (n <- i until nums.length)
        if n == i || nums(n) != nums(n - 1) then
          combine(nums, n + 1, required - nums(n), mutable.ListBuffer[Int]().addAll(tmp).append(nums(n)), result)
```

### 46. Permutations
```scala
  def permute(nums: Array[Int]): List[List[Int]] =
    val (result, numsbuffer) = (mutable.ListBuffer[List[Int]](), mutable.ArrayBuffer[Int]().addAll(nums))
    permuteInternal(numsbuffer, mutable.ListBuffer[Int](), result)
    result.toList

  private def permuteInternal(nums: mutable.ArrayBuffer[Int], tmp: mutable.ListBuffer[Int], result: mutable.ListBuffer[List[Int]]): Unit =
    nums match
      case mutable.ArrayBuffer() => result.append(tmp.toList)
      case _ => for (n <- nums.indices)
        val remove = nums.remove(n)
        permuteInternal(nums, mutable.ListBuffer[Int]().addAll(tmp).append(remove), result)
        nums.insert(n, remove)
```

### 10. Regular Expression Matching
```scala
  def isMatch(s: String, p: String): Boolean = p.toSeq match
    case Seq() => s.isEmpty
    case Seq(head, tail@_*) =>
      val firstMatch = s.headOption.exists(_ == head || head == '.')
      tail.headOption.filter(_ == '*') match
        case Some(_) => isMatch(s, p.drop(2)) || (firstMatch && isMatch(s.drop(1), p))
        case None => firstMatch && isMatch(s.drop(1), p.drop(1))
```

### 17. Letter Combinations of a Phone Number
```scala
  private val map = Map('2' -> List("a", "b", "c"), '3' -> List("d", "e", "f"), '4' -> List("g", "h", "i"), '5' -> List("j", "k", "l")
    , '6' -> List("m", "n", "o"), '7' -> List("p", "q", "r", "s"), '8' -> List("t", "u", "v"), '9' -> List("w", "x", "y", "z"))

  def letterCombinations(digits: String): List[String] = _letterCombinations(digits.toList, List.empty[String])

  private def _letterCombinations(digits: List[Char], buffer: List[String]): List[String] = digits match
    case List() => buffer
    case head :: tail => _letterCombinations(tail, map(head).flatMap { d => if buffer.isEmpty then List(d) else buffer.map(b => b + d) })
```

### 47. Permutations II
```scala
  def permuteUnique(nums: Array[Int]): List[List[Int]] = _permuteUnique(nums, mutable.HashSet[List[Int]]())

  private def _permuteUnique(nums: Array[Int], buffer: mutable.HashSet[List[Int]]): List[List[Int]] = nums match
    case Array() => buffer.toList
    case _ => nums.zipWithIndex.flatMap { case (_, i) =>
      _permuteUnique(nums.take(i) ++ nums.drop(i + 1)
        , if buffer.isEmpty then mutable.HashSet(List(nums(i))) else buffer.map(l => nums(i) :: l))
    }.toList
```

### 51. N-Queens
```scala
  def solveNQueens(n: Int): List[List[String]] =
    val result = mutable.ListBuffer[List[String]]()
    _solveNQueens(0, n, mutable.ListBuffer[Int](), result)
    result.toList

  private def _solveNQueens(current: Int, n: Int, buffer: mutable.ListBuffer[Int], result: mutable.ListBuffer[List[String]]): Unit = current match
    case num if num == n => result.addOne(buffer.foldLeft(mutable.ListBuffer[String]()) { case (b, i) => b.addOne(".".repeat(n).updated(i, 'Q')) }.toList)
    case _ => for (i <- 0 until n if !buffer.contains(i) && !buffer.zipWithIndex.foldLeft(false) { case (r, (v, idx)) => r || (i - (current - idx)) == v || (i + (current - idx)) == v }) {
      buffer.addOne(i)
      _solveNQueens(current + 1, n, buffer, result)
      buffer.remove(buffer.length - 1)
    }
```

### 52. N-Queens 2
```scala
  def totalNQueens(n: Int): Int =
    val (cols, dia1, dia2) = (mutable.HashSet[Int](), mutable.HashSet[Int](), mutable.HashSet[Int]())
    val result = AtomicInteger(0)
    _totalNQueens(0, n, cols, dia1, dia2, result)
    result.intValue()

  private def _totalNQueens(row: Int, n: Int, cols: mutable.HashSet[Int], dia1: mutable.HashSet[Int], dia2: mutable.HashSet[Int], result: AtomicInteger): Unit = row match
    case num if num == n => result.incrementAndGet()
    case _ => for (i <- 0 until n if !cols.contains(i) && !dia1.contains(i - row) && !dia2.contains(i + row)) {
      cols.addOne(i)
      dia1.addOne(i - row)
      dia2.addOne(i + row)
      _totalNQueens(row + 1, n, cols, dia1, dia2, result)
      cols.remove(i)
      dia1.remove(i - row)
      dia2.remove(i + row)
    }
```

### 77. Combinations
```scala
  def combine(n: Int, k: Int): List[List[Int]] =
    val result = mutable.ListBuffer[List[Int]]()
    for (i <- 1 to n) _combine(i, n, k, mutable.ListBuffer[Int](), result)
    result.toList

  private def _combine(i: Int, n: Int, k: Int, buffer: mutable.ListBuffer[Int], result: mutable.ListBuffer[List[Int]]): Unit =
    buffer.addOne(i)
    if buffer.length == k then result.addOne(buffer.clone.toList)
    else if buffer.length < k then for (j <- i + 1 to n) _combine(j, n, k, buffer, result)
    buffer.remove(buffer.length - 1)
```

### 79. Word Search
```scala
  def exist(board: Array[Array[Char]], word: String): Boolean =
    board.zipWithIndex.exists { case (line, i) =>
      line.zipWithIndex.exists { case (_, j) => _exist(board, i, j, word, 0) }
    }

  private def _exist(board: Array[Array[Char]], i: Int, j: Int, word: String, l: Int): Boolean =
    if l > word.length then false
    else if l == word.length then true else {
      if word.charAt(l) == board(i)(j) then {
        val tmp = board(i)(j)
        board(i)(j) = '.'
        val result = (if (i - 1) >= 0 && board(i - 1)(j) != '.' then _exist(board, i - 1, j, word, l + 1) else false)
          || (if (i + 1) < board.length && board(i + 1)(j) != '.' then _exist(board, i + 1, j, word, l + 1) else false)
          || (if (j - 1) >= 0 && board(i)(j - 1) != '.' then _exist(board, i, j - 1, word, l + 1) else false)
          || (if (j + 1) < board(0).length && board(i)(j + 1) != '.' then _exist(board, i, j + 1, word, l + 1) else false)
        board(i)(j) = tmp
        result
      } else false
    }
```

### 93. Restore IP Addresses
```scala
  def restoreIpAddresses(s: String): List[String] =
    val result = mutable.ListBuffer[String]()
    _restoreIPAddresses(s, 0, 0, "", result)
    result.toList

  private def _restoreIPAddresses(s: String, i: Int, dots: Int, buffer: String, result: mutable.ListBuffer[String]): Unit = dots match
    case 3 => if s.substring(i).toInt < 256 && (s.substring(i).equals("0") || !s.substring(i).startsWith("0")) then result.addOne(buffer + s.substring(i))
    case _ => for (j <- (i + 1) to (i + 3)) {
      if j < s.length && s.substring(i, j).toInt < 256 && (s.substring(i, j).equals("0") || !s.substring(i, j).startsWith("0")) then
        _restoreIPAddresses(s, j, dots + 1, buffer + s.substring(i, j) + ".", result)
    }
```