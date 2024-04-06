# Union Find
Union Find algorithm uses a **disjoint-set** data structure to keeps track of a set of elements partitions (non-overlapping subsets). 
It performs two useful operations on such a data structure:
* Find: Determine which subset a particular element is in. 
This can be used for determining if two elements are in the same subset.
* Union: Join two subsets into a single subset. 
If we find the two subsets belong to same set. 

**NOTE** Union fnd dosen't work on directed graph, 
because a directed graph cannot be represented using the disjoint-set(the data structure on which union-find is performed).

### Implementation of union find
1. use an array with the same size of the number of node
2. initially the array that the value (parent id) equals to index (id) => each node is self-owned 
3. if two elements are connected/belongs to same set, update the value to the parent index
4. find operation => find the parent id of given node recursive **until a self-owned (root) found**
```scala
    if parent(nid) == nid then nid else find(parent(nid), parent)
```
5. union operation => update values of found nodes to the value of parent
```scala
    val (pid1, pid2) = (find(nid1, parent), find(nid2, parent))
    if pid1 != pid2 then parent(pid1) = pid2
```

### Optimization
As the find is a recursive call until it finds the root (self-owned) node, the worst case scenario is O(Logn).
1. union by rank: always attach smaller depth tree under the root of the deeper tree
2. path compression: to flatten the tree when find() is called

The two techniques complement each other. The time complexity of each operation becomes even smaller than O(Logn). 
In fact, amortized time complexity effectively becomes small constant. 

### Usage of union find
* Check whether an undirected graph contains cycle or not (assume no self-loop)
* Check the regions of an undirected graph
<br><br>

### 200. Number of Islands
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
```
Example 1:
Input: grid = [
["1","1","1","1","0"],
["1","1","0","1","0"],
["1","1","0","0","0"],
["0","0","0","0","0"]
]
Output: 1
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/unionfind/NumberofIslands.scala#L4-L19

### 305. Number of Islands II
A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
```
Example:
Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/unionfind/NumberofIslands2.scala#L4-L16

### 547. Number of Provinces
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
```
Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/unionfind/NumberofProvinces.scala#L4-L10