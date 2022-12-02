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
```scala
  def numIslands(grid: Array[Array[Char]]): Int =
    val parent = Array.fill[Int](grid.length * grid(0).length)(-1)
    var count = 0
    for (i <- grid.indices; j <- grid(0).indices) {
      if grid(i)(j) == '1' then {
        parent(i * grid(0).length + j) = i * grid(0).length + j
        count = count + 1
      }
    }
    for (i <- grid.indices; j <- grid(0).indices) {
      if grid(i)(j) == '1' then {
        if j + 1 < grid(0).length && grid(i)(j + 1) == '1' && UF.union(i * grid(0).length + j, i * grid(0).length + j + 1, parent) then count = count - 1
        if i + 1 < grid.length && grid(i + 1)(j) == '1' && UF.union(i * grid(0).length + j, (i + 1) * grid(0).length + j, parent) then count = count - 1
      }
    }
    count
```

### 305. Number of Islands II
```scala
  def numIslands(m: Int, n: Int, points: Array[Array[Int]]): Array[Int] =
    val parent = Array.fill[Int](m * n)(-1)
    var count = 0
    points.map { case Array(x, y, _*) =>
      val nid = x * m + y
      parent(nid) = nid
      count = count + 1
      if x - 1 >= 0 && parent((x - 1) * m + y) != (-1) && UF.union(nid, (x - 1) * m + y, parent) then count = count - 1
      if x + 1 < m && parent((x + 1) * m + y) != (-1) && UF.union(nid, (x + 1) * m + y, parent) then count = count - 1
      if y - 1 >= 0 && parent(x * m + y - 1) != (-1) && UF.union(nid, x * m + y - 1, parent) then count = count - 1
      if y + x < n && parent(x * m + y + 1) != (-1) && UF.union(nid, x * m + y + 1, parent) then count = count - 1
      count
    }
```

### 547. Number of Provinces
```scala
  def findCircleNum(isConnected: Array[Array[Int]]): Int =
    var result = isConnected.length
    val parent = isConnected.indices.toArray
    for (i <- isConnected.indices; j <- isConnected.indices) {
      if i != j && isConnected(i)(j) == 1 && UF.union(i, j, parent) then result = result - 1
    }
    result
```