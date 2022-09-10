package tries

import scala.annotation.tailrec
import scala.collection.mutable

object IndexPairsofaString {
  def indexPairs(s: String, words: List[String]): List[List[Int]] =
    val (result, trie) = (mutable.ListBuffer[List[Int]](), Trie.empty[Int])
    words.foreach(word => trie.insert(word, word.length))
    for (i <- 0 until s.length) indexPairsInternal(s, i, 0, trie, result)
    result.toList

  @tailrec
  private def indexPairsInternal(s: String, start: Int, step: Int, trie: Trie[Int], result: mutable.ListBuffer[List[Int]]): Unit =
    trie.children(s.charAt(start + step) - 97) match
      case Some(node) => if node.value.isDefined then result.addOne(List(start, start + step))
        if start + step < s.length then indexPairsInternal(s, start, step + 1, node, result)
      case _ =>
}
