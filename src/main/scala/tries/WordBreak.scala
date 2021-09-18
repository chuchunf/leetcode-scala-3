package tries

object WordBreak {
  def wordBreak(s: String, wordDict: List[String]): Boolean =
    val trie = Trie.empty[Int]
    wordDict.foreach(trie.insert(_, 0))
    val dp = Array.fill(s.length + 1)(false)
    dp(0) = true
    for (i <- 0 until s.length - 1; j <- i + 1 to s.length)
      if !dp(j) then dp(j) = dp(i) && trie.search(s.substring(i, j)).isDefined
    dp.last
}
