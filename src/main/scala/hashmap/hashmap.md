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
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/hashmap/FirstUniqChar.scala#L6-L11

### 202. Happy Number
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/hashmap/HappyNumber.scala#L6-L12

<br></br>
## Convenient data structure to store discrete keys / non-number keys for further processing
Array is a dense data structure while Hashmap is discrete/spared, Hashmap can be used to organize the data for easy access and further processing.
- Isomorphic Strings: char from source string and char from target string as key
- Bulls and Cows: char from source string and char from target string as key
- **Wall Brick**: the width of the bricks are discrete as key

### 205. Isomorphic Strings
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/hashmap/IsomorphicStrings.scala#L6-L15

### 299. Bulls and Cows
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/hashmap/BullsandCows.scala#L6-L16

### 554. Brick Wall
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
- **Contains Duplicate III** => control the bucket size

### 380. Insert Delete GetRandom O(1)
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/hashmap/InsertDeleteGetRandomO1.scala#L5-L27


