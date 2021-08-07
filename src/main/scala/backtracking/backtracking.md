#Back Tracking
Backtracking is a general algorithm for finding all (or some) solutions to some computational problems, that incrementally builds candidates to the solutions, and abandons each partial candidate as soon as it determines that the candidate cannot possibly be completed to a valid solution, and resume from last good point (“backtracks”)
- Back tracking is a recursion with memorizing of past result (with a collection and indexes passing in recursive calls) 
- most of the problems that are discussed, can be solved using other known algorithms like Dynamic Programming or Greedy Algorithms in logarithmic

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