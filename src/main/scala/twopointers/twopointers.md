# Two Pointers
Two pointers is really an easy and effective technique in a sorted sequence, such as array or linked list.
Common scenarios are **find a pair/min/max/equals/closest in a range defined by the two pointers**

- It could be from same direction or matching towards centre
- The technique deals with a **continuous** range 
- Move two pointers independently of each other but depend on condition of the problem
- Identify the condition of moving the pointer is the key to use this technique
  - Longest unique string => find/not-find repeating character 
  - Container with Most water => move the point which is not definitely smaller than current 
  - Trap water fall => the water will flow from the lower part, and we start again when encounter a higher bar.
- Slow fast pointers/Sliding window is kind of variant of this technique

### 3.Longest Substring Without Repeating Characters
\```scala:LengthOfLongestSubString.scala
\```

### 11. Container With Most Water
\```scala:ContainerWithMostWater.scala
\```

### 16. 3Sum Closest
\```scala:ThreeSumClosest.scala
\```

### 209. Minimum Size Sub array Sum
\```scala:MinimumSizeSubarraySum.scala
\```

### 42. Trapping Rain Water
\```scala:TrappingRainWater.scala
\```