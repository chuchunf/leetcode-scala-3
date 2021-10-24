# Dynamic Programming
Dynamic Programming is a recursion algorithm which memorize and reuse previous calculation.
It could be done either from top-down or bottom-up.

When to use DP
- **Optimal substructure** => problem can be obtained by the combination of optimal solutions to its sub-problems. Such optimal substructures are usually described by means of recursion.  
  - § Fib(n) = Fib(n-1) + Fib(n-2)
- **Overlapping sub problems** => e.g. to calculate fib(6), fib(2) called 5 times 
  - § Fib(2) called 5 times in the process to resolve Fib(6)
- The final state could be reached/resolved/constructed from sub-state 

The key is to find the problem and its sub-problem
  - Fab => sub (0, 1 cases) => overlapping f(n) = f(n-2) + f(n-1)
  - Unique path => sub (row 0 and column 0 case) => overlapping f(m,n)=f(m-1,n)+f(m,n-1)
  - Min sum => sub(row 0 and column 0 case) => overlapping f(m,n) = `f(m,n) + min(f(m-1,n), f(m, n-1))

### 70. Climbing Stairs
```scala
  def climbStairs(n: Int): Int = n match
    case n if n <= 2 => n
    case _ => (2 until n).foldLeft((1, 2)) { case ((n_2, n_1), _) => (n_1, n_2 + n_1) }._2
```

### 64. Minimum Path Sum
```scala
  def minPathSum(grid: Array[Array[Int]]): Int =
    for (i <- 0 until grid.length; j <- 0 until grid(0).length) {
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