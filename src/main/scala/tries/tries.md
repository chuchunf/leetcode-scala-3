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
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
```
Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
```
Trie is used to search, but Hashset is the best choice to check the existence of word
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tries/WordBreak.scala#L4-L11

### 140. Word Break 2
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
```
Example 1:
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]

Example 2:
Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
```
Use trie so we could use the same pointer for both Array and Word Dictionary
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tries/WordBreak2.scala#L6-L21

### 212. Word Search 2
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
```
Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
```
* Trie is a special Tree structure, so it works well with Recursion
* Simple tip to prevent backward search => Assign a special char ( board(i)(j)='#' ) then set it back after recursion call
  https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tries/WordSearch2.scala#L6-L26

### 1065. Index Pairs of a String
Given a text string and words (a list of strings), return all index pairs [i, j] so that the substring text[i]...text[j] is in the list of words.
```
Example 1:
Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
Output: [[3,7],[9,13],[10,17]]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tries/IndexPairsofaString.scala#L7-L18