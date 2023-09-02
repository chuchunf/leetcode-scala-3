# Fast Slow Pointers

Fast and Slow pointers is an algorithm that works by setting two pointers that move at different speeds, one faster than the other.
The technique works with linked data structures such as an array or linked list.

The key is to control the speed or starting position (fast/slow) from the same direction
- Move at different speed => detect cycle
- Move 2 times speed => detect middle
- Start from different start position => delete nth node in 1 pass

This technique also has two pointers (same as two pointers technique), but
- Slow/Fast pointers move dependently
- Hence the key is not to detect when to move which pointer, but rather the end condition

Multiple pass could be used to collect more information

### 141. Linked List Cycle
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/fastslowpointers/LinkedListCycle.scala#L6-L14

### 876. Middle of the Linked List
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/fastslowpointers/MiddleoftheLinkedList.scala#L6-L13

### 142. Linked List Cycle II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/fastslowpointers/LinkedListCycle2.scala#L6-L24