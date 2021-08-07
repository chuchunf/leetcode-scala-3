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
\```scala:ClimbingStairs.scala
\```

### 64. Minimum Path Sum
\```scala:MinimumPathSum.scala
\```

### 53. Maximum Subarray
\```scala:MaximumSubarray.scala
\```

### 5. Longest Palindromic Substring
\```scala:LongestPalindromicSubstring.scala
\```

### 91. Decode Ways
\```scala:DecodeWays.scala
\```

