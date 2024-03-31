# Bucket Sort

Bucket sort (bin sort) **distributes the elements into buckets**, 
then **buckets is sorted individually**, either as an already sorted array or using same/different sorting algorithms. 

Bucket sort is useful when elements are **uniformly distributed over a range** => **Duplicates (based on frequency)** could be distributed into **Buckets** 

### Steps
The process of bucket sort can be understood as a **scatter-gather** approach
1. Set up an array of initially empty "buckets".
2. Go over the original array, putting each object in its bucket => scatter
3. Sort each non-empty bucket individually
4. Visit the buckets in order and put all elements back into the original array => gather
<br><br>

## Related Algorithms & Data structures 
* **Array**: the buckets could be initiated as a sorted array 
* **Counting sort** counts the number of objects with distinct key values (kind of hashing), 
then do some arithmetic to calculate the position of each object (array of counts/frequency).  
Counting sort handles same elements appears multiples times, 
while Bucket sort handles multiple elements have same hash value (e.g. floating number which could not be the index of array).   
Bucket sort can be seen as a generalization of counting sort; if each bucket has size 1 then bucket sort degenerates to counting sort
* **Quick sort**, Bucket sort with two buckets is a quicksort where the pivot value is the middle value of the value range
* **Hashmap**, Bucket Sort is kind of using the same underneath data structure as Hashmap, but for sorting.
<br><br>

## Usages
1. Bucket sort (based on frequency)
   * Top K frequent elements: the buckets are in sorted array hence no additional sorting required
   * Top K frequent words
   * Sort characters by frequency
2. Usage of the bucket
   * Contains duplicate III: distribute the numbers into **value distance number of bucket**  
   => found duplicate if the bucket contains an index or nearby bucket contains index with value less than value distance 
   * Maximum Gap: distribute the numbers into **n-1 bucket**, find the max difference for each bucket
<br><br>
   
## Frequency
### 347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
```
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bucketsort/TopKFrequentElements.scala#L6-L17

### 692. Top K Frequent Words
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
```
Example 1:
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]

Example 2:
Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bucketsort/TopKFrequentWords.scala#L6-L17

### 451. Sort Characters By Frequency
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.
```
Example 1:
Input: s = "tree"
Output: "eert"

Example 2:
Input: s = "cccaaa"
Output: "aaaccc"
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bucketsort/SortCharactersByFrequency.scala#L6-L13
<br><br>

## Usage of Bucket
### 164. Maximum Gap
Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

You must write an algorithm that runs in linear time and uses linear extra space.
```
Example 1:
Input: nums = [3,6,9,1]
Output: 3
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bucketsort/MaximumGap.scala#L4-L18

### 220. Contains Duplicate III
You are given an integer array nums and two integers indexDiff and valueDiff.

Find a pair of indices (i, j) such that:
```
i != j,
abs(i - j) <= indexDiff.
abs(nums[i] - nums[j]) <= valueDiff, and
```
Return true if such pair exists or false otherwise.
```
Example 1:
Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
Output: true

Example 2:
Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
Output: false
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bucketsort/ContainsDuplicate3.scala#L6-L19

