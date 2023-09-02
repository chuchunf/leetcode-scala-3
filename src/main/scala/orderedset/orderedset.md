# Ordered Set (Map)

A **set** can store **unique values, without any particular order**.

* Set is closely related to Map, the difference is **set is used to store only keys** while map is used to store key value pairs.
* Set is commonly **implemented the same way as Map**, in which the value of each key-value pair has a fixed value (like1)

An **ordered set** keeps the unique elements in sorted order. The time and space complexity depend on implementation

| Properties     | Hashmap             | TreeMap             | LinkedHashMap  |
|----------------|---------------------|---------------------|----------------|
| Iteration      | No guaranteed order | sorted order        | insertion order |
| Get/Put/Remove | O(1)                | O(log(n))           | O(1)           |
| Nulls          | keys and values     | only values         | keys and values |
| Implementation | buckets             | red-black tree      | double linked buckets |
| Applications   | general purpose     | where order matters | LRU cache, etc. where insertion/access order matters |


## Get a key based on predefined order
OrderSet maintains a particular order, and provide functions such as minBefore, maxAfter to get a key (value pair) of given order in log(N) time.

### 729. My Calendar I
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/orderedset/MyCalendar.scala#L6-L14

### 731. My Calendar II
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/orderedset/MyCalendar2.scala#L6-L22

### 1818. Minimum Absolute Sum Difference
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/orderedset/MinimumAbsoluteSumDifference.scala#L6-L14

## A compact ordered container
Instead of an array, OrderSet could be used to stored ordered data without spaces.

### 732. My Calendar III
Use Order Map to simulate the time line to save space, as the time spot will be sparse.
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/orderedset/MyCalendar3.scala#L6-L14

### 855. Exam Room
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/orderedset/ExamRoom.scala#L6-L32
