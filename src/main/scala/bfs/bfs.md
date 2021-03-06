# Breadth First Search
BFS is a traversing algorithm which starts from a selected node and traverse the graph layer-wise thus exploring the neighbour nodes (nodes which are directly connected to source node). 
Then move towards the next-level neighbour nodes. 

A queue is used to enable the layer-wise traverse iteratively. 
A recursive implementation could simply continue with the queue built at parent level

### 127. Word Ladder
```scala
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
```

### 130. Surrounded Regions
```scala
  def solve(board: Array[Array[Char]]): Unit =
    val q = mutable.Queue[(Int, Int)]()
    board.zipWithIndex.foreach { case (line, x) =>
      line.zipWithIndex.foreach { case (char, y) =>
        if char == 'O' && (x == 0 || y == 0 || x == board.length - 1 || y == board(0).length - 1) then q.addOne((x, y))
      }
    }
    while !q.isEmpty do {
      val (x, y) = q.remove(0)
      board(x)(y) = '.'
      if (x - 1) >= 0 && board(x - 1)(y) == 'O' then q.addOne((x - 1, y))
      if (x + 1) < board.length && board(x + 1)(y) == 'O' then q.addOne(x + 1, y)
      if (y - 1) >= 0 && board(x)(y - 1) == 'O' then q.addOne((x, y - 1))
      if (y + 1) < board(0).length && board(x)(y + 1) == 'O' then q.addOne(x, y + 1)
    }
    board.zipWithIndex.foreach { case (line, x) =>
      line.zipWithIndex.foreach { case (char, y) =>
        if char == 'O' then board(x)(y) = 'X'
        if char == '.' then board(x)(y) = 'O'
      }
    }
```

### 199. Binary Tree Right Side View
```scala
  def rightSideView(root: TreeNode[Int]): List[Int] =
    val result = mutable.ListBuffer[Int]()
    var queue = mutable.ListBuffer[TreeNode[Int]]().addOne(root)
    while !queue.isEmpty do {
      result.addOne(queue.last.value)
      val tmpqueue = mutable.ListBuffer[TreeNode[Int]]()
      while !queue.isEmpty do {
        val node = queue.remove(0)
        if node.left.isDefined then tmpqueue.addOne(node.left.get)
        if node.right.isDefined then tmpqueue.addOne(node.right.get)
      }
      queue = tmpqueue
    }
    result.toList
```