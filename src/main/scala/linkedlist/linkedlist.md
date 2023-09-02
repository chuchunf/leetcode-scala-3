# Linked List

A linked list is a linear collection of data elements, each element has a pointer to the next element.
Linked list allows for efficient **insertion or removal of elements from any position** in the sequence during iteration.
Linked list does not allow random access, index based operation requires an iteration.

- Standard operation
  - a node has a next pointing to the next element, check null for the end of the linked list.
- Common operations
  - dummy.next = head => use a **dummy head** to save and keep the original head
  - ll.next.next => skip 1 item
  - Use two pointers to cover a range
  - Instead of updating value, just re-point the next pointer

### Data structures built from Linked List
Linked lists can be used to implement other common abstract data types
- Lists
- Stacks
- Queues
- Hashmaps

### Algorithms with Listed list
- Linked list is a **recursive data structure** and works well with recursion.
- Two pointers / fast slow pointers / sliding windows

## Basic operation
### 61. Rotate List
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/linkedlist/RotateList.scala#L6-L18

### 206. Reverse Linked List
Iterative approach, carefully maneuver of pre, curr and next
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/linkedlist/ReverseList.scala#L4-L13

### 143. Reorder List
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/linkedlist/RotateList.scala#L6-L18

### 86. Partition List
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/linkedlist/PartitionList.scala#L4-L19

## Additional operations
### 19. Remove Nth Node From End of List
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/linkedlist/RemoveNthFromEnd.scala#L4-L16

### 83. Remove Duplicates from Sorted List
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/linkedlist/RemoveDuplicatesfromSortedList.scala#L4-L9

### 82. Remove Duplicates from Sorted List II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/linkedlist/RemoveDuplicatesfromSortedListII.scala#L4-L13

### 138. Copy List with Random Pointer
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/linkedlist/CopyListwithRandomPointer.scala#L6-L20

## Use of linked list
### 2. Add Two Numbers
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/linkedlist/AddTwoNumbers.scala#L5-L11

### 445. Add Two Numbers 2
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/linkedlist/AddTwoNumbers2.scala#L4-L14

## Others
### 160. Intersection of Two Linked Lists
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/linkedlist/IntersectionofTwoLinkedLists.scala#L4-L11