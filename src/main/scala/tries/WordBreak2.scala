package tries

import scala.collection.mutable

object WordBreak2 {
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
}
