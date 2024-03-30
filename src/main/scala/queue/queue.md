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

## Usages 
* Breath first search
* Backtracking to find element in O(1) in FILO (monotonic Queue similar to monotonic Stack) 

## Tips
* Store index not actual value
* If one queue is not enough, use multiple queues
* Reverse the order of queue if there are reverse dependencies 

## Related data structure
* **Priority queue**: a queue with each element additionally has a priority associated with it
* **Circular buffer**: a single, fixed-size buffer as if it were connected end-to-end
<br><br>

## Implementation 
### 225. Implement Stack using Queues
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/queue/MyStack.scala#L5-L25

### 232. Implement Queue Using Stacks
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/queue/MyQueue.scala#L5-L20
<br><br>

## FILO order collection
### 649. Dota2 Senate => Medium => FILO order
In the world of Dota2, there are two parties: the Radiant and the Dire.

The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:

* Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
* Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.

Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.
```
Example 1:
Input: senate = "RD"
Output: "Radiant"

Example 2:
Input: senate = "RDD"
Output: "Dire"
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/queue/Dota2Senate.scala#L6-L15

### 281. Zigzag Iterator
Given two vectors of integers v1 and v2, implement an iterator to return their elements alternately.

Implement the ZigzagIterator class:

* ZigzagIterator(List<int> v1, List<int> v2) initializes the object with the two vectors v1 and v2.
* boolean hasNext() returns true if the iterator still has elements, and false otherwise.
* int next() returns the current element of the iterator and moves the iterator to the next element.
```
Example 1:
Input: v1 = [1,2], v2 = [3,4,5,6]
Output: [1,3,2,4,5,6]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/queue/ZigzagIterator.scala#L5-L17

### 950. Reveal Cards In Increasing Order
You are given an integer array deck. There is a deck of cards where every card has a unique integer. The integer on the ith card is deck[i].

You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.

You will do the following steps repeatedly until all cards are revealed:

* Take the top card of the deck, reveal it, and take it out of the deck.
* If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
* If there are still unrevealed cards, go back to step 1. Otherwise, stop.

Return an ordering of the deck that would reveal the cards in increasing order.
```
Example 1:
Input: deck = [17,13,11,2,3,5,7]
Output: [2,13,3,11,5,17,7]

Example 2:
Input: deck = [1,1000]
Output: [1,1000]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/queue/RevealCardsInIncreasingOrder.scala#L6-L11
<br><br>

## Monotonic Queue
### 239. Sliding Window Maximum => hard
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
```
Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1 3 -1]  -3  5  3  6  7       3
1 [3  -1  -3] 5  3  6  7       3
1  3 [-1  -3  5] 3  6  7       5
1  3  -1 [-3  5  3] 6  7       5
1  3  -1  -3 [5  3  6] 7       6
1  3  -1  -3  5 [3  6  7]      7
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/queue/SlidingWindowMaximum.scala#L6-L23
