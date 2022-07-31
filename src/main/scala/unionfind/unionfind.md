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
2. initially, the node identified the index of the array and the value equals to the index 
3. if two elements are connected/belongs to same set, update the value to the parent index
4. find operation => check if the values of two nodes (by index) are the same
5. union operation => update the value by index to the value of of index of selected parent

### Application of union find
* Check whether an undirected graph contains cycle or not (assume no self-loop)
