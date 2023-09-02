# Queue
A queue is a data structure maintaining a collection of entities in **First-In-First-Out** order.
* The end of the sequence at which elements are added is called the tail => **Enqueue**
* The end at which elements are removed is called the head => **Dequeue**

Theoretically, one characteristic of a queue is that it does not have a specific capacity,
A bounded queue is a queue limited to a fixed number of items.

## Implementation
1. Use a fixed-size **array** and two pointers to indicate the starting position and the ending position.
2. Use a **Linked List**,
    * a doubly linked list has O(1) insertion and deletion at both ends, so it is a natural choice for queues.
    * a singly linked list could provide the same with a pointer at tis end

## Application and tips
* Breath first search
* When the order of element enter/exit is significant 

## Tips
* Store index not actual value
* If one queue is not enough, use multiple queues
* Reverse the order of queue if there are reverse dependencies 

## Related data structure
* **Priority queue**: a queue with each element additionally has a priority associated with it
* **Circular buffer**: a single, fixed-size buffer as if it were connected end-to-end

### 225. Implement Stack using Queues
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/queue/MyStack.scala#L5-L25

### 232. Implement Queue Using Stacks
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/queue/MyQueue.scala#L5-L20

### 239. Sliding Window Maximum
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/queue/SlidingWindowMaximum.scala#L6-L23

### 649. Dota2 Senate
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/queue/Dota2Senate.scala#L6-L15

### 281. Zigzag Iterator
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/queue/ZigzagIterator.scala#L5-L17

### 950. Reveal Cards In Increasing Order
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/queue/RevealCardsInIncreasingOrder.scala#L6-L11