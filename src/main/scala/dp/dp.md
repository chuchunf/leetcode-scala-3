# Dynamic Programming
Dynamic programming refers to simplifying a complicated problem by breaking it down into simpler sub-problems in a recursive manner, in short, **recursion with memorization**

There are two key attributes that a problem must have for dynamic programming to be applicable:**optimal substructure** and **overlapping sub-problems**. 
Note: If an issue can be solved by combining optimal solutions to **non-overlapping** sub-problems, the strategy is called "divide and conquer" instead.
This is why merge sort and quick sort are not classified as dynamic programming problems

- a problem is said to have **an optimal substructure** if an optimal solution can be constructed from optimal solutions of its sub problems. i.e. **final result can be derived from previous sub problems**
- a problem is said to have **overlapping sub problems** if the problem can be broken down into subproblems which are reused several times or a recursive algorithm for the problem solves the same subproblem over and over rather than always generating new sub problems. i.e. **sub problems' result could be re-used for next subproblem**
- Subproblems are smaller versions of the original problem

Fibonacci sequence is a good example: Fib(n) = fib(n-1) + fib(n-2)
- Bottom-up approach with tabulation, start computing results for the subproblem. 
Using the subproblem result solves another subproblem and finally solves the whole problem.
```scala
Fib[0] = 0; Fib[1] = 1; // initial result => bottom case
for(i = 2; i <= N; i++) Fib[i] = Fib[i-1]+Fib[i-2]; // reuse previous results from bottom to top
```
- The top-down approach with recursion and memorization, breaks the large problem into multiple sub-problems. 
Whenever we solve a subproblem, cache its result; if the subproblem solved already just reuse the answer.
```scala
int Fibonacci(int N) {
  if(result[N] == -1) { // if not available in cache, compute it
    if(N <= 1) result[N] = N;
    else result[N] = Fibonacci(N-1) + Fibonacci(N-2); // recursive call which will eventually bottom up
  }
  result[N]; // if available, just return
}
```
In both cases, we will only compute each fib(n) once.

### Top down recursion thinking process

#### Brute force recursion without memorization first
1. The expected result => use what the question asked for as a return result
2. Think of how to derive f(n) from f(n-1), f(n-2), etc.
    1. Doesn’t have to be n depending on n-1 directly, etc. could be n, m depending on n-1, m+1 could sum of multiple, etc. DP works as long as we could derive n from others 
    2. The key is to find the overlapping subproblem
3. Consider parameters from a base case => recursion exit condition
    1. Data set (if there are) => arrays/matrix,
    2. Index to current element (if there are dataset) OR control variable (i.e. n in Fibonacci)
    3. Constraint variable => additional conditions to be considered and modified accordingly for the recursive call
    4. Temp variable => additional data point to pass in recursion
4. Condition to derive f(n) from f(n-1), f(n-2), etc. 
    1. Assume the function is already working, and we are at the last step (It returns the expected result !!!)
    2. The constraint variable correctly reflected due to recursion call)
    3. From the last case, what is the possible decision to be made? (to take or not to take, etc.)
    4. From the condition given, how do we decide? (with the assumption we have a recursive function that could return the result correctly for another step) => naturally derive the dependency 
5. From above, call recursively and return the answer
    1. Special cases first
    2. Get the result based on condition, modify constraint variable and make recursive calls.
    3. NOTE: the constraint variable and index will be changed in the recursive call

#### Add memorization to recursion
1. Create a memorization structure based on the parameters above (both index and constraint variable)
2. Since these variables are changing, we could reuse them only if we encounter the same scenarios again
3. Make it the first parameters of the recursive function
4. Return directly if the result is available

#### How do recognize a DP problem?
- The problems that seek the maximum or minimum solution given certain constraints 
- The problems that need to find out all the combinations 
- The problem could be resolved recursively 
- The n problem could be derived from children's subproblems, e.g. n-1, n-2, etc.

### 70. Climbing Stairs
```scala
  def climbStairs(n: Int): Int = n match
    case n if n <= 2 => n
    case _ => (2 until n).foldLeft((1, 2)) { case ((n_2, n_1), _) => (n_1, n_2 + n_1) }._2
```

### 64. Minimum Path Sum
```scala
  def minPathSum(grid: Array[Array[Int]]): Int =
   for (i <- grid.indices; j <- grid(0).indices) {
      (i, j) match
        case (0, 0) => grid(i)(j) = grid(i)(j)
        case (0, _) => grid(i)(j) = grid(i)(j) + grid(i)(j - 1)
        case (_, 0) => grid(i)(j) = grid(i)(j) + grid(i - 1)(j)
        case _ => grid(i)(j) = grid(i)(j) + grid(i - 1)(j).min(grid(i)(j - 1))
    }
    grid.last.last
```

### 53. Maximum Subarray
```scala
  def maxSubArray(nums: Array[Int]): Int =
    for (i <- 1 until nums.length) nums(i) = nums(i).max(nums(i) + nums(i - 1))
    nums.reduceLeft(Ordering[Int].max)
```

### 5. Longest Palindromic Substring
```scala
  def longestPalindrome(s: String): String =
    val cache = Array.ofDim[Boolean](s.length, s.length)
    var result = ""
    for (i <- s.length - 1 to 0 by -1; j <- i until s.length) {
      cache(i)(j) = s.charAt(i) == s.charAt(j) && (j - i < 3 || cache(i + 1)(j - 1))
      if cache(i)(j) && j - i + 1 > result.length then result = s.substring(i, j + 1)
    }
    result
```

### 91. Decode Ways
```scala
    val cache = Array.fill[Int](if s.length < 2 then 2 else s.length)(0)
    cache(0) = 1
    cache(1) = if s.charAt(0) == '0' then 1 else 2
    for (i <- 2 until s.length) {
      val (first, second) = (s.substring(i, i + 1).toInt, s.substring(i - 1, i + 1).toInt)
      if first >= 1 && first <= 9 then cache(i) = cache(i) + cache(i - 1)
      if second > 10 && second <= 26 then cache(i) = cache(i) + cache(i - 2)
    }
    cache(s.length - 1)
```

### 174. Dungeon Game
```scala
  def calculateMinimumHP(dungeon: Array[Array[Int]]): Int =
    val result: Array[Array[Int]] = Array.ofDim[Int](dungeon.length, dungeon(0).length)
    for (row <- (dungeon.length - 1) to 0 by -1; col <- (dungeon(0).length - 1) to 0 by -1) {
      val need = (row, col) match
        case (r, c) if r == dungeon.length - 1 && c == dungeon(0).length - 1 => 1 - dungeon(row)(col)
        case (r, _) if r == dungeon.length - 1 => result(row)(col + 1) - dungeon(row)(col)
        case (_, c) if c == dungeon(0).length - 1 => result(row + 1)(col) - dungeon(row)(col)
        case (_, _) => result(row + 1)(col).min(result(row)(col + 1)) - dungeon(row)(col)
      result(row)(col) = if need <= 0 then 1 else need
    }
    result(0)(0)
```

### 55. Jump Game
```scala
  def canJump(nums: Array[Int]): Boolean = _canJump(0, nums.length, nums, Array.ofDim[Option[Boolean]](nums.length))

  def _canJump(current: Int, n: Int, nums: Array[Int], cache: Array[Option[Boolean]]): Boolean =
    if cache(current) != null then cache(current).get
    else if nums(current) + current > n then true
    else (1 to nums(current)).foldLeft(false) { case (result, i) =>
      val iresult = _canJump(current + i, n, nums, cache)
      cache(current + i) = Some(iresult)
      result || iresult
    }
```

### 63. Unique Paths 2
```scala
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int =
    _uniquePaths(0, 0, obstacleGrid, Array.fill[Option[Int]](obstacleGrid.length, obstacleGrid(0).length)(None))

  private def _uniquePaths(c: Int, r: Int, grid: Array[Array[Int]], cache: Array[Array[Option[Int]]]): Int =
    if cache(c)(r).nonEmpty then cache(c)(r).get
    else if grid(c)(r) == 1 then 0
    else if c == grid.length - 1 && r == grid(0).length - 1 then 1
    else {
      val result = if c == grid.length - 1 then _uniquePaths(c, r + 1, grid, cache)
      else if r == grid(0).length - 1 then _uniquePaths(c + 1, r, grid, cache)
      else _uniquePaths(c, r + 1, grid, cache) + _uniquePaths(c + 1, r, grid, cache)
      cache(c)(r) = Some(result)
      result
    }
```

### 97. Interleaving String
```scala
  def isInterleave(s1: String, s2: String, s3: String): Boolean =
    val cache = Array.ofDim[Option[Boolean]](s1.length + 1, s2.length + 1, s3.length + 1)
    _isInterleave(s1, 0, s2, 0, s3, 0, cache, true)

  private def _isInterleave(s1: String, l1: Int, s2: String, l2: Int, s3: String, l3: Int, cache: Array[Array[Array[Option[Boolean]]]], order: Boolean): Boolean =
    if l1 == s1.length && l2 == s2.length && l3 == s3.length then true
    else if (l1 == s1.length && l3 < s3.length) || (l1 < s1.length && l3 == s3.length) then false
    else {
      val cached = if order then cache(l1)(l2)(l3) else cache(l2)(l1)(l3)
      if cached != null then cached.get else {
        val result = (l1 + 1 to s1.length).exists { i =>
          if s1.substring(l1, i).equals(s3.substring(l3, l3 + (i - l1))) then
            _isInterleave(s2, l2, s1, i, s3, l3 + (i - l1), cache, !order)
          else false
        }
        if order then cache(l1)(l2)(l3) = Some(result) else cache(l2)(l1)(l3) = Some(result)
        result
      }
    }
```

### 115. Distinct Subsequences
```scala
  def numDistinct(s: String, t: String): Int = _numDistinct(s, 0, t, 0, Array.fill(s.length, t.length)(-1))

  private def _numDistinct(s: String, i: Int, t: String, j: Int, cache: Array[Array[Int]]): Int =
    if j >= t.length then 1
    else if i >= s.length || (s.length - i) < (t.length - j) then 0 else {
      if cache(i)(j) == -1 then
        cache(i)(j) = s.drop(i).zipWithIndex.map { case (char, k) =>
          if char == t(j) then _numDistinct(s, i + k + 1, t, j + 1, cache) else 0
        }.sum
      cache(i)(j)
    }
```

### 120. Triangle
```scala
  def minimumTotal(triangle: List[List[Int]]): Int =
    _minimumTotal(0, 0, triangle, Array.fill(triangle.length, triangle.last.length)(-1))

  private def _minimumTotal(level: Int, i: Int, triangle: List[List[Int]], cache: Array[Array[Int]]): Int =
    if level == triangle.size then 0
    else {
      if cache(level)(i) == -1 then
        cache(level)(i) = triangle(level)(i)
          + _minimumTotal(level + 1, i, triangle, cache).min(_minimumTotal(level + 1, i + 1, triangle, cache))
      cache(level)(i)
    }
```