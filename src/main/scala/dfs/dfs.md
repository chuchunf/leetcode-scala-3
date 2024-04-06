# Depth first search
**Depth-first search (DFS)** is a **recursive** algorithm for searching a graph or tree data structure. 
The algorithm starts at the root (top) node of a tree and goes as far as it can down a given branch (path), 
then backtracks until it finds an unexplored path, and then explores it.

**Iterative Implementation of DFS is with a Stack**, to keep track of the nodes discovered along branches which helps in backtracking of the graph.
FIFO Stack is used as the most recently discovered nodes should be processed first.

### Usages
1. Topological sort
2. Cycle detection
3. Scheduling problems
4. Path finding 
<br><br>

## Recursion 
### 112. Path Sum 
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

```
Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dfs/PathSum.scala#L6-L9

### 116. Populating Next Right Pointers in Each Node 
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
```
struct Node {
    int val;
    Node *left;
    Node *right;
    Node *next;
}
```
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
```
Example 1:
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate 
each next pointer to point to its next right node, just like in Figure B. 
The serialized output is in level order as connected by the next pointers, with '#' signifying 
the end of each level.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dfs/PopulatingNextRightPointersinEachNode.scala#L4-L17

### 129. Sum Root to Leaf Numbers
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
```
Example 1:
Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dfs/SumRoottoLeafNumbers.scala#L6-L12

### 156. Binary Tree upside Down
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
```
Example 1:
Input: [1,2,3,4,5]
    1
   / \
  2   3
 / \
4   5
Output: return the root of the binary tree [4,5,2,#,#,3,1]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dfs/BinaryTreeUpsideDown.scala#L6-L14
<br><br>

## Back tracking
### 113. Path Sum II
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
```
Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/dfs/PathSum2.scala#L8-L21