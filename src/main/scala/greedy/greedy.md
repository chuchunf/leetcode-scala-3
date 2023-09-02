# Greedy

A greedy algorithm is a simple, intuitive algorithm that is used in optimization problems. 
The algorithm makes the **optimal choice at each step** as it attempts to find the overall optimal way to solve the entire problem. 
However, in many problems, a greedy strategy does not produce an optimal solution, 
because it makes decisions based only on the information it has at any one step, without regard to the overall problem.

Only if both of the properties below are true, a greedy algorithm can be used to solve the problem.
- Greedy choice property: A global (overall) optimal solution can be reached by choosing the optimal choice at each step. 
- Optimal substructure: A problem has an optimal substructure if an optimal solution to the entire problem contains the optimal solutions to the sub-problems. => local optimal is global optimal 

In short, a greedy algorithm works **if and only if the optimal solution at each step is also the optimal solution as a whole**

If a Greedy Algorithm can solve a problem, then it generally becomes the best method to solve that problem as the Greedy algorithms are in general more efficient than other techniques like Dynamic Programming. 
But Greedy algorithms cannot always be applied. For example, the Fractional Knapsack problem can be solved using Greedy, but 0-1 Knapsack cannot be solved using Greedy.
An efficient solution is to use the Greedy approach. The basic idea of the greedy approach is to calculate the ratio value/weight for each item and sort the item on basis of this ratio. 
Then take the item with the highest ratio and add them until we can’t add the next item as a whole and at the end add the next item as much as we can. Which will always be the optimal solution to this problem.

### 122. Best Time to Buy and Sell Stock II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/greedy/BestTimetoBuyandSellStock2.scala#L4-L7

### 134. Gas Station
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/greedy/GasStation.scala#L4-L14

### 179. Largest Number
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/greedy/LargestNumber.scala#L5-L7

### 44. Wildcard Matching
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/greedy/WildcardMatching.scala#L8-L16

### 135. Candy
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/greedy/Candy.scala#L5-L19