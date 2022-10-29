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

