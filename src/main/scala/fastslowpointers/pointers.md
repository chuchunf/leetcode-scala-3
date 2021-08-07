# Fast Slow Pointers

Fast and Slow pointers is an algorithm that works by setting two pointers that move at different speeds, one faster than the other.
The technique works linked data structures such as array, linked list.

The key is to control the speed or distance (fast/slow)
- Move at different speed => detect cycle
- Move with given range => delete nth node in 1 pass
- Move 2 times speed => detect middle

This technique also has two pointers (same as two pointer technique), but 
- Slow/Fast pointers move dependently 
- Hence the condition is not to detect when to move which pointer, rather the end condition

### 141. Linked List Cycle
\```scala:LinkedListCycle
\```

### 876. Middle of the Linked List
\```scala:MiddleoftheLinkedList.scala
\```