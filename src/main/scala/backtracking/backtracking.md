# Back Tracking
Backtracking is a general algorithm for finding all (or some) solutions to some computational problems, that incrementally builds candidates to the solutions, and abandons each partial candidate as soon as it determines that the candidate cannot possibly be completed to a valid solution, and resume from last good point (“backtracks”)
- Back tracking is a recursion with memorizing of past result (with a collection and indexes passing in recursive calls) 
- most of the problems that are discussed, can be solved using other known algorithms like Dynamic Programming or Greedy Algorithms in logarithmic
- Back tracking is essentially recursive

Tips
- Add a helper recursive function with additional parameter to keep track intermedia states and finally result
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
      case _ => for (n <- 0 until nums.length)
        val remove = nums.remove(n)
        permuteInternal(nums, mutable.ListBuffer[Int]().addAll(tmp).append(remove), result)
        nums.insert(n, remove)
```

### 10. Regular Expression Matching
```scala
  def isMatch(s: String, p: String): Boolean = p.toSeq match
    case Seq() => s.isEmpty
    case Seq(head, tail@_*) =>
      val firstMatch = s.headOption.filter(_ == head || head == '.').nonEmpty
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
    case head :: tail => _letterCombinations(tail, map(head).map { case d => if buffer.isEmpty then List(d) else buffer.map(b => b + d) }.flatten)
```

### 47. Permutations II
```scala
  def permuteUnique(nums: Array[Int]): List[List[Int]] = _permuteUnique(nums, mutable.HashSet[List[Int]]())

  private def _permuteUnique(nums: Array[Int], buffer: mutable.HashSet[List[Int]]): List[List[Int]] = nums match
    case Array() => buffer.toList
    case _ => nums.zipWithIndex.map { case (num, i) =>
      _permuteUnique(nums.take(i) ++ nums.drop(i + 1)
        , if buffer.isEmpty then mutable.HashSet(List(nums(i))) else buffer.map(l => nums(i) :: l))
    }.flatten
      .toList
```