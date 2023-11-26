# HashMap

Hashmap is an associative array abstract data type, which maps keys to values.
For scenarios that we don't need to loop through every item to process, rather just to **check the existence**,
HashMap could effectively change the complexity **from loop O(n) to lookup O(1)**.

The key idea of HashMap is to use a hash function to map keys to buckets.
* **Hash function**, given a key return the index
* **Hash collision**, when the hash function returns the same index for two different key
* **Buckets**, keys with the same hash value go to the same bucket (linked list or red-black tree)
  A hash function is not perfect and it is a tradeoff between the number of buckets and the capacity of a bucket (space for time).

If the keys are continuous number values (e.g. char value could be converted integers), the array will be a better data structure.

<br></br>
## Related Algorithms
- **Count sort**: Counts the occurrence of each number / elements in a Hashmap
- **Bucket sort**: Divides the unsorted array elements into several groups called buckets
  elements fall into the same buckets stored in a linked list. The data structure is the same as Hashmap,
  but the usage is different that **bucket (array) is sorted by index**.

<br></br>
## Check **existence** of an element 
When the purpose is to check the existence, instead of looping through the entire collection O(N), Hashmap provides O(1) access
- Two sum: the expected value is known, the purpose is to find if the expected value exist.
- First non-repeating character: the character is known, the purpose is to find if the character already exist.
- Happy number: The list of unhappy numbers built up along the recursive call is known, the purpose is to find out if the unhappy number already exist

### 1. Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

```
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/hashmap/TwoSum.scala#L6-L13

### 387. First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

```
Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/hashmap/FirstUniqChar.scala#L6-L11

### 202. Happy Number
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

```
Example 1:
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:
Input: n = 2
Output: false
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/hashmap/HappyNumber.scala#L6-L12

<br></br>
## Convenient data structure to store discrete keys / non-number keys for further processing
Array is a dense data structure while Hashmap is discrete/spared, Hashmap can be used to organize the data for easy access and further processing.
- Isomorphic Strings: char from source string and char from target string as key
- Bulls and Cows: char from source string and char from target string as key
- **Wall Brick**: the width of the bricks are discrete as key

### 205. Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
```
Example 1:
Input: s = "egg", t = "add"
Output: true

Example 2:
Input: s = "foo", t = "bar"
Output: false

Example 3:
Input: s = "paper", t = "title"
Output: true
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/hashmap/IsomorphicStrings.scala#L6-L15

### 299. Bulls and Cows
You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
```
Example 1:
Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"

Example 2:
Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1123"        "1123"
 |      or      |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/hashmap/BullsandCows.scala#L6-L16

### 554. Brick Wall
There is a rectangular brick wall in front of you with n rows of bricks. The ith row has some number of bricks each of the same height (i.e., one unit) but they can be of different widths. The total width of each row is the same.

Draw a vertical line from the top to the bottom and cross the least bricks. If your line goes through the edge of a brick, then the brick is not considered as crossed. You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

Given the 2D array wall that contains the information about the wall, return the minimum number of crossed bricks after drawing such a vertical line.
```
Example 1:
Input: wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
Output: 2

Example 2:
Input: wall = [[1],[1],[1]]
Output: 3
```
First consider the simplest case, 1 row of bricks, the answer is 0 for each edge.
Consider add another row, it depends on if the edges of 2nd row matching with 1st row.
We could loop through each row and count the edges (previous wall length + current brick length),
and the edge with large count is where the draw could be Drawn.
Hashmap could be used to keep track of each edge with corresponding count.
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/hashmap/BrickWall.scala#L6-L13

<br></br>
## Implementation and other usages
- Design Hashmap
- Insert Delete GetRandom O(1)

### 380. Insert Delete GetRandom O(1)
Implement the RandomizedSet class:
* RandomizedSet() Initializes the RandomizedSet object.
* bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
* bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
* int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.

You must implement the functions of the class such that each function works in average O(1) time complexity.
```
Example 1:
Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/hashmap/InsertDeleteGetRandomO1.scala#L5-L27


