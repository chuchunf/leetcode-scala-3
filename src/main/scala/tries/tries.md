# Tries
Tries (aka digital tree, prefix tree) is a tree data-structure that are based on the prefix of a string. 
They are used to represent the “Retrieval” of data and thus the name Trie. 
* A Trie is a special data structure used to store strings that can be visualized like a graph.
* It consists of nodes and edges 
* It maintains a list of children node indexed by the ASCII value directly, search, lookup and delete 1 level/step a time

Tries could replace Hashtable for String as it has no hash function hence no collisions.
Tries commonly used in predictive text or autocomplete dictionaries with large number of short strings.

### 208. Implement Tries
```scala
class Trie[T](var value: Option[T], var children: List[Option[Trie[T]]]) {
  def search(key: String): Option[T] = search(this, key, 0)

  def insert(key: String, value: T): Unit = insert(this, key, value, 0)

  def delete(key: String): Unit = delete(this, key, 0)

  private def search(node: Trie[T], key: String, step: Int): Option[T] =
    if key.length == step then node.value
    else this.children(key.charAt(step) - 97) match
      case Some(next) => search(next, key, step + 1)
      case _ => None

  private def insert(node: Trie[T], key: String, value: T, step: Int): Unit =
    if key.length == step then node.value = Option(value)
    else {
      val index = key.charAt(step) - 97
      val child = node.children(index).getOrElse(Trie.empty[T])
      node.children = node.children.updated(index, Some(child))
      insert(child, key, value, step + 1)
    }

  private def delete(node: Trie[T], key: String, step: Int): Unit =
    if key.length == step then node.value = None
    else node.children(key.charAt(step) - 97).map(delete(_, key, step + 1))
}
```

### 139. Word Break
Trie is used to search, but Hashset is the best choice to check the existence of word
```scala
  def wordBreak(s: String, wordDict: List[String]): Boolean =
    val trie = Trie.empty[Int]
    wordDict.foreach(trie.insert(_, 0))
    val dp = Array.fill(s.length + 1)(false)
    dp(0) = true
    for (i <- 0 until s.length - 1; j <- i + 1 to s.length)
      if !dp(j) then dp(j) = dp(i) && trie.search(s.substring(i, j)).isDefined
    dp.last
```

### 140. Word Break 2
Use trie so we could use the same pointer for both Array and Word Dictionary
```scala
  def wordBreak(s: String, wordDict: List[String]): List[String] =
    val trie = Trie.empty[Int]
    wordDict.foreach(trie.insert(_, 0))
    val result = mutable.ListBuffer[String]()
    wordBreakInternal(s, 0, "", trie, result)
    result.toList

  private def wordBreakInternal(s: String, n: Int, buffer: String, trie: Trie[Int], result: mutable.ListBuffer[String]): Unit =
    if n == s.length then result.addOne(buffer)
    else {
      for (i <- n + 1 to s.length)
        if trie.search(s.substring(n, i)).isDefined then {
          val space = if n == 0 then "" else " "
          wordBreakInternal(s, i, buffer + space + s.substring(n, i), trie, result)
        }
    }
```

### 212. Word Search 2
* Trie is a special Tree structure, so it works well with Recursion
* Simple tip to prevent backward search => Assign a special char ( board(i)(j)='#' ) then set it back after recursion call 
```scala
  def findWords(board: Array[Array[Char]], words: Array[String]): List[String] =
    val result = mutable.ListBuffer[String]()
    val trie = Trie.empty[String]
    words.foreach(word => trie.insert(word, word))
    for (i <- 0 until board.length; j <- 0 until board(0).length) findWordsInternal(board, i, j, trie, result)
    result.toList

    private def findWordsInternal(board: Array[Array[Char]], i: Int, j: Int, words: Trie[String], result: mutable.ListBuffer[String]): Unit =
        val char = board(i)(j)
        if char != '#' then {
          board(i)(j) = '#'
          words.children(char - 97) match
              case Some(node) if node.value.isDefined => result.addOne(node.value.get)
              case Some(node) if node.value.isEmpty =>
                  if i < board.length - 1 then findWordsInternal(board, i + 1, j, node, result)
                  if i > 1 then findWordsInternal(board, i - 1, j, node, result)
                  if j < board(0).length - 1 then findWordsInternal(board, i, j + 1, node, result)
                  if j > 1 then findWordsInternal(board, i, j - 1, node, result)
              case _ =>
                board(i)(j) = char
        }
```

### 1065. Index Pairs of a String
```scala
  def indexPairs(s: String, words: List[String]): List[List[Int]] =
    val (result, trie) = (mutable.ListBuffer[List[Int]](), Trie.empty[Int])
    words.foreach(word => trie.insert(word, word.length))
    for (i <- 0 until s.length) indexPairsInternal(s, i, 0, trie, result)
    result.toList

  private def indexPairsInternal(s: String, start: Int, step: Int, trie: Trie[Int], result: mutable.ListBuffer[List[Int]]): Unit =
    trie.children(s.charAt(start + step) - 97) match
      case Some(node) => if node.value.isDefined then result.addOne(List(start, start + step))
        if start + step < s.length then indexPairsInternal(s, start, step + 1, node, result)
      case _ =>
```