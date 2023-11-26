# Bucket Sort

Bucket sort (bin sort) **distributes the elements into buckets**, 
then **buckets is sorted individually**, either as an already sorted array or using same/different sorting algorithms. 

Bucket sort is useful when elements are **uniformly distributed over a range** => **Duplicates (based on frequency)** could be distributed into **Buckets** 

## Steps
The process of bucket sort can be understood as a **scatter-gather** approach
1. Set up an array of initially empty "buckets".
2. Go over the original array, putting each object in its bucket => scatter
3. Sort each non-empty bucket individually
4. Visit the buckets in order and put all elements back into the original array => gather

## Related Algorithms & Data structures 
* **Array**: the buckets could be initiated as a sorted array 
* **Counting sort** counts the number of objects with distinct key values (kind of hashing), 
then do some arithmetic to calculate the position of each object (array of counts/frequency).  
Counting sort handles same elements appears multiples times, 
while Bucket sort handles multiple elements have same hash value (e.g. floating number which could not be the index of array).   
Bucket sort can be seen as a generalization of counting sort; if each bucket has size 1 then bucket sort degenerates to counting sort
* **Quick sort**, Bucket sort with two buckets is a quicksort where the pivot value is the middle value of the value range
* **Hashmap**, Bucket Sort is kind of using the same underneath data structure as Hashmap, but for sorting.

## Applications
1. Bucket sort (based on frequency)
   * Top K frequent elements: the buckets are in sorted array hence no additional sorting required
   * Top K frequent words
   * Sort characters by frequency
2. Usage of the bucket
   * Contains duplicate III: distribute the numbers into **value distance number of bucket**  
   => found duplicate if the bucket contains an index or nearby bucket contains index with value less than value distance 
   * Maximum Gap: distribute the numbers into **n-1 bucket**, find the max difference for each bucket

### 347. Top K Frequent Elements
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bucketsort/TopKFrequentElements.scala#L6-L17

### 692. Top K Frequent Words
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bucketsort/TopKFrequentWords.scala#L6-L17

### 451. Sort Characters By Frequency
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bucketsort/SortCharactersByFrequency.scala#L6-L13

### 220. Contains Duplicate III
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bucketsort/ContainsDuplicate3.scala#L6-L19

### 164. Maximum Gap
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bucketsort/MaximumGap.scala#L4-L18
