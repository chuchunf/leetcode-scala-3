# Counting (Sort)
**Counting** is a simple and effective technique when dealing with numeric arrays,
by counting the number of occurrences of each unique element in the array.

The count is stored in an auxiliary array, and the **counting sort** is done by mapping the count to an index of the auxiliary array

- It is not a comparison-based sorting.
- Its running time complexity is O(n) with space complexity O(k).
- It can be considered as a special kind of hashing (hashmap), key-value maps to index directly (without hashing function)

## Applications
- There are **smaller integers with multiple counts**.
- Linear complexity is the need.

## Related Algorithms
- **Bucket Sort** or bin sort, works by distributing the elements of an array into several buckets.
  Each bucket is then sorted individually. Counting sort stores a single number (the count of items) per bucket.

## Related Data structures
- Array => Counting sort
- Hashmap => Counting

### 169. Majority Element
[Boyer-Moore Majority Vote Algorithm](http://www.cs.utexas.edu/~moore/best-ideas/mjrty/)
* The algorithm depends on there is a majority
* Which can be easier validated with a 2nd pass of counting
  https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/counting/MajorityElement.scala#L4-L9

### 229. Majority Element 2
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/counting/MajorityElement2.scala#L4-L12

### 358. Rearrange String k Distance Apart
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/counting/RearrangeStringkDistanceApart.scala#L6-L21

### 383. Ransom Note
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/counting/RansomNote.scala#L6-L10
