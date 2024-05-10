# Best Time to Buy and Sell Stock

Same as title, this problem series is to find out the best time to buy and sell stock for max profit.

* Best Time to Buy and Sell Stock: find the max profit with a single buy and sell
* Best Time to Buy and Sell Stock II: find the max profit with unlimited number of transaction
* Best Time to Buy and Sell Stock III: find the max profit (buy then sell) with at most two transactions.
* Best Time to Buy and Sell Stock IV: more general case, find the max profit with at most k transactions.

<br>
<details>
<summary><b>Thinking progress</b></summary>

To find the max profit with a single buy and sell, the brute-force approach will be loop through all combination and
find the max.
But consider we must buy first before sell, the question is to find the current max price until ith element, compare
with price of ith to find current profit. So we just need two variables, one to keep the current max price and another
to keep the current max profit, a single pass could find the max profit.

For, Best Time to Buy and Sell Stock II, as we are not limited by the number of transaction and we could buy and sell at
the same day, the best strategy is just buy and sell whenever the transaction is profitable, hence a greedy approach.

Next step, we are limited by the transaction to be 2, considering at each day, we could either choose to buy/sell or do
nothing, this is a typical DP case. We need to keep track of the profit of current day, then compare with path is more
profitable, buy/sell or do nothing.

The last question is a more general case of question 3, we will need keep the number of transaction as another variable
and handle the same way as question 3

</details>
<br>

### 121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to
sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

```
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
```

https://github.com/chuchunf/leetcode-scala-3/blob/266e54bf7a1705a4aa17987f8182d9e375eaa2e3/src/main/scala/array/BestTimetoBuyandSellStock.scala#L4-L12

### 122. Best Time to Buy and Sell Stock II

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

```
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
```

https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/greedy/BestTimetoBuyandSellStock2.scala#L4-L7

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

### 188. Best Time to Buy and Sell Stock IV

You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and
sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

```
Example 1:
Input: k = 2, prices = [2,4,1]
Output: 2

Example 2:
Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
```

TODO