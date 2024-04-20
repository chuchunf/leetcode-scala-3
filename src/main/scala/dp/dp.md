# Dynamic Programming
Dynamic programming refers to simplifying a complicated problem by breaking it down into simpler sub-problems in a recursive manner, in short, **recursion with memorization**

There are two key attributes that a problem must have for dynamic programming to be applicable:**optimal substructure** and **overlapping sub-problems**. 
Note: If an issue can be solved by combining optimal solutions to **non-overlapping** sub-problems, the strategy is called "divide and conquer" instead.
This is why merge sort and quick sort are not classified as dynamic programming problems

- a problem is said to have **an optimal substructure** if an optimal solution can be constructed from optimal solutions of its sub problems. i.e. **final result can be derived from previous sub problems**
- a problem is said to have **overlapping sub problems** if the problem can be broken down into sub-problems which are reused several times or a recursive algorithm for the problem solves the same sub-problem over and over rather than always generating new sub problems. i.e. **sub problems' result could be re-used for next sub-problem**
- Sub-problems are smaller versions of the original problem

Fibonacci sequence is a good example: Fib(n) = fib(n-1) + fib(n-2)
- Bottom-up approach with tabulation, start computing results for the sub-problem. 
Using the sub-problem result solves another sub-problem and finally solves the whole problem.
```scala
Fib[0] = 0; Fib[1] = 1; // initial result => bottom case
for(i = 2; i <= N; i++) Fib[i] = Fib[i-1]+Fib[i-2]; // reuse previous results from bottom to top
```
- The top-down approach with recursion and memorization, breaks the large problem into multiple sub-problems. 
Whenever we solve a sub-problem, cache its result; if the sub-problem solved already just reuse the answer.
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
    2. The key is to find the overlapping sub-problem
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
5. Note the dimension required for memorization, e.g. number of parameters required to determine the result 

### How do recognize a DP problem?
- The problems that seek the maximum or minimum solution given certain constraints 
- The problems that need to find out all the combinations 
- The problem could be resolved recursively 
- The n problem could be derived from children's sub-problems, e.g. n-1, n-2, etc.
<br><br>

## Count number in array or matrix
### 70. Climbing Stairs 
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
```
Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/ClimbingStairs.scala#L4-L6

### 64. Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
```
Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/MinimumPathSum.scala#L4-L12

### 91. Decode Ways
A message containing letters from A-Z can be encoded into numbers using the following mapping:
```
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
```
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

* "AAJF" with the grouping (1 1 10 6)
* "KJF" with the grouping (11 10 6)

Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.
```
Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/DecodeWays.scala#L4-L13

### 55. Jump Game
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
```
Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, 
which makes it impossible to reach the last index.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/JumpGame.scala#L4-L12

### 63. Unique Paths 2
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
```
Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/UniquePaths2.scala#L4-L17

### 120. Triangle
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
```
Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/Triangle.scala#L4-L14

### 174. Dungeon Game
The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).

To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Return the knight's minimum initial health so that he can rescue the princess.

Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
```
Example 1:
Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
Output: 7
Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: 
RIGHT-> RIGHT -> DOWN -> DOWN.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/DungeonGame.scala#L4-L14

### 123. Best Time to Buy and Sell Stock III
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
```
Example 1:
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, 
as you are engaging multiple transactions at the same time. You must sell before buying again.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/BestTimetoBuyandSellStock3.scala#L4-L17
<br><br>

## Knapsack and coin machine etc
### 53. Maximum Subarray
Given an integer array nums, find the subarray with the largest sum, and return its sum.
```
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/MaximumSubarray.scala#L6-L8

### 322. Coin Change
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
```
Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```
https://github.com/chuchunf/leetcode-scala-3/blob/1e545845013c7068d51a9fd45e0b6822858a895a/src/main/scala/dp/CoinChange.scala#L4-L18

### 518. Coin Change II
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.
```
Example 1:
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
```
https://github.com/chuchunf/leetcode-scala-3/blob/1e545845013c7068d51a9fd45e0b6822858a895a/src/main/scala/dp/CoinChange2.scala#L4-L14
<br><br>

## Substring and common string etc
### 5. Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.
```
Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/LongestPalindromicSubstring.scala#L4-L11

### 97. Interleaving String
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m
substrings respectively, such that:

* s = s1 + s2 + ... + sn
* t = t1 + t2 + ... + tm
* |n - m| <= 1
* The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...

Note: a + b is the concatenation of strings a and b.
```
Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/InterleavingString.scala#L4-L22

### 115. Distinct Subsequences
Given two strings s and t, return the number of distinct subsequences of s which equals t.
```
Example 1:
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit

Example 2:
Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dp/DistinctSubsequences.scala#L4-L14
