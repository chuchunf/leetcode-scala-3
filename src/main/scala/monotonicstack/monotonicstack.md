# Monotonic Stack
A monotonic stack is a stack whose elements are monotonically increasing or decreasing, 
normally used to track the **maximum or minimum** element in a data set.

## implementation 
* The index is stored in the stack and forms a mono-sequence, either increasing or decreasing
* Pop the smaller/bigger elements from the stack before pushing a new element 
```scala
  while !stk.isEmpty && arr(stk.top) <= arr(i) do 
    stk.pop
    {logic}
  stk.push(i)
```
* Apply logic accordingly given the property of Monotonic stack

## Applications
The monotonic stack mainly solves the previous/next smaller/larger problem.
* Next greater: monotonic decreasing stack, pop the stack if the value (of top of the stack) is smaller than current => the next greater of top of the stack is the current index
* Previous greater: same as above in reversed order

## Relationship with other data structures
1. **Stack**: Monotonic stack is a stack with a property that the elements are monotonically increasing or decreasing. 
2. **Priority Queue**: Monotonic stack maintains the monotonicity by **dequeuing** elements when a new element e is enqueued, while a priority queue maintains the monotonicity by **heapifying** when a new element enqueued
3. **Monotonic Queue**: Both maintains the monotonicity but one based on Queue (FIFO), another based on Stack (FILO)

### 496	Next Greater Element I
URL to be added

### 316. Remove Duplicate Letters
to be added

### 456. 132 Pattern
to be added

### 84. Largest Rectangle in Histogram
URL to be added
