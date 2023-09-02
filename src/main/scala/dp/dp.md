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

## Top down recursion
### Brute force recursion without memorization first
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

### Add memorization to recursion
1. Create a memorization structure based on the parameters above (both index and constraint variable)
2. Since these variables are changing, we could reuse them only if we encounter the same scenarios again
3. Make it the first parameters of the recursive function
4. Return directly if the result is available

### How do recognize a DP problem?
- The problems that seek the maximum or minimum solution given certain constraints 
- The problems that need to find out all the combinations 
- The problem could be resolved recursively 
- The n problem could be derived from children's subproblems, e.g. n-1, n-2, etc.

### 70. Climbing Stairs
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/ClimbingStairs.scala#L4-L6

### 64. Minimum Path Sum
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/MinimumPathSum.scala#L4-L12

### 53. Maximum Subarray
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/MaximumSubarray.scala#L6-L8

### 5. Longest Palindromic Substring
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/LongestPalindromicSubstring.scala#L4-L11

### 91. Decode Ways
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/DecodeWays.scala#L4-L13

### 174. Dungeon Game
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/DungeonGame.scala#L4-L14

### 55. Jump Game
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/JumpGame.scala#L4-L12

### 63. Unique Paths 2
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/UniquePaths2.scala#L4-L17

### 97. Interleaving String
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/InterleavingString.scala#L4-L22

### 115. Distinct Subsequences
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/DistinctSubsequences.scala#L4-L14

### 120. Triangle
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/Triangle.scala#L4-L14

### 123. Best Time to Buy and Sell Stock III
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/BestTimetoBuyandSellStock3.scala#L4-L17