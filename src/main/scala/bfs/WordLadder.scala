package bfs

import scala.collection.mutable

object WordLadder {
  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int =
    _ladderLength(beginWord, endWord, mutable.HashSet().addAll(wordList), 0)

  private def _ladderLength(begin: String, end: String, words: mutable.HashSet[String], len: Int): Int =
    if begin.equals(end) then return len + 1
    words.filter(word => {1 == begin.toCharArray.zip(word.toCharArray).filter { (c1, c2) => {c1 != c2}}.length})
      .map(word => {
        words.remove(word)
        val result = _ladderLength(word, end, words, 1 + len)
        words.add(word)
        result
      })
      .filter(_!=0)
      .minOption
      .getOrElse(0)
}
