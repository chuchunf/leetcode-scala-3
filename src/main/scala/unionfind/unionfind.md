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

### 200. Number of Islands
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/unionfind/NumberofIslands.scala#L4-L19

### 305. Number of Islands II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/unionfind/NumberofIslands2.scala#L4-L16

### 547. Number of Provinces
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/unionfind/NumberofProvinces.scala#L4-L10