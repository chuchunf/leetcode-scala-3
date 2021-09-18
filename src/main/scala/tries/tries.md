# Tries
Tries (aka digital tree, prefix tree) is a tree data-structure that are based on the prefix of a string. 
They are used to represent the “Retrieval” of data and thus the name Trie. 
A Trie is a special data structure used to store strings that can be visualized like a graph. 
It consists of nodes and edges

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