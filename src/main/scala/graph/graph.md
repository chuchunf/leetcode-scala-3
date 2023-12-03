# Graph
A graph is a non-linear data structure consisting of a finite set of **vertices** (nodes/points), 
with a set of unordered pairs of these vertices for an **undirected graph** or a set of ordered pairs for a **directed graph**.
These pairs are known as **edges** (also called links or lines)

**Graph traversal** refers to the process of visiting (checking and/or updating) each vertex in a graph. 
- Breadth First Search (BFS)
- Depth First Search (DFS)

### The main differences between a graph and a tree
1. There could be cycle in graph but not in tree
2. Graph could be undirected, tree is always directed (from root to children)

### Usages
1. detect a cycle in a directed graph
2. traversal of a graph 
3. find dependency of a graph  

## Related algorithms
- **DFS/BFS**
- **Topological sort**  
  Simply involves running DFS on an entire graph and adding each node to the global ordering of nodes,
  but only after all of a node's children are visited (hence depth first).
  This ensures that parent nodes will be ordered before their child nodes,
  and honors the forward direction of edges in the ordering.
- **Union find**
- Dijkstra
- Floyd-Warshall Algorithm

### 207. Course Schedule
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
```
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, 
and to take course 0 you should also have finished course 1. So it is impossible.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/graph/CourseSchedule.scala#L6-L16

### 210. Course Schedule II
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
```
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. 
So the correct course order is [0,1].

Example 2:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/graph/CourseSchedule2.scala#L6-L17

### 310. Minimum Height Trees
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/graph/MinimumHeightTrees.scala#L6-L23