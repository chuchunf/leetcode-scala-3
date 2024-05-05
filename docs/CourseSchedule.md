# Course Schedule 

* Course Schedule: given an array of courses with dependency, find if the courses could be finished.
* Course Schedule II: given an array of courses with dependency, find the order of courses to take to finish all courses.
* Course Schedule III: given an array of course with duration and end day, find the max number of course could be taken. 

<br>
<details>
<summary><b>Thinking progress</b></summary>

Course schedule I is a typical graph traversal problem, we can just populate the graph nodes and try to from all the nodes
to see if we could visit all the nodes.

For Course schedule II, we need to find the order instead, so this becomes a backtracking problem, in additional to keep track 
of nodes visited, we also need to keep track of current visited path.

Course schedule III is different from first two, as the course now has no dependency but we need to ensure there is no overlap. 
This is a then a DP problem, in addition, given the end day is known, we know the local optimal value so greedy is better in this case.
A heap/priority queue is required to get the local optimal value.

</details>
<br>

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

### 630. Course Schedule III
There are n different online courses numbered from 1 to n. You are given an array courses where courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.

You will start on the 1st day and you cannot take two or more courses simultaneously.

Return the maximum number of courses that you can take.
```
Example 1:
Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
Output: 3

Example 2:
Input: courses = [[1,2]]
Output: 1
```
https://github.com/chuchunf/leetcode-scala-3/blob/3dfd199a7a293bcdb099064a5284854ef8a38c4d/src/main/scala/greedy/CourseSchedule3.scala#L6-L15
