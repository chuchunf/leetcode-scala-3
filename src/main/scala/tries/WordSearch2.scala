package tries

import scala.collection.mutable

object WordSearch2 {
  def findWords(board: Array[Array[Char]], words: Array[String]): List[String] =
    val result = mutable.ListBuffer[String]()
    val trie = Trie.empty[String]
    words.foreach(word => trie.insert(word, word))
    for (i <- board.indices; j <- 0 until board(0).length) findWordsInternal(board, i, j, trie, result)
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
}
