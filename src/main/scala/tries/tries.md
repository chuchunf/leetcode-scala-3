# Tries
Tries (aka digital tree, prefix tree) is a tree data structures that are based on the prefix of a string.
They are used to represent the “Retrieval” of data and thus the name Trie.
* A Trie is a special data structure used to store strings that can be visualized like a graph.
* It consists of nodes and edges
* It maintains a list of children node indexed by the ASCII value directly, search, lookup, and delete 1 level/step at a time

Tries could replace Hashtable for String as it has no hash function hence no collisions.
Tries are commonly used in predictive text or autocomplete dictionaries with a large number of short strings.

### 208. Implement Tries
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tries/Trie.scala#L6-L33

### 139. Word Break
Trie is used to search, but Hashset is the best choice to check the existence of word
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tries/WordBreak.scala#L4-L11

### 140. Word Break 2
Use trie so we could use the same pointer for both Array and Word Dictionary
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tries/WordBreak2.scala#L6-L21

### 212. Word Search 2
* Trie is a special Tree structure, so it works well with Recursion
* Simple tip to prevent backward search => Assign a special char ( board(i)(j)='#' ) then set it back after recursion call
  https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tries/WordSearch2.scala#L6-L26

### 1065. Index Pairs of a String
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tries/IndexPairsofaString.scala#L7-L18