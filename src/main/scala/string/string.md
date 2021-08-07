# String

### 6. ZigZag Conversion
```scala
  def convert(s: String, numRows: Int): String = numRows match
    case 1 => s
    case _ => val cache = (0 to numRows - 1).map(_ => new mutable.ArrayBuffer[Char]()).toArray
    var (pos, num, down) = (0, 0, true)
    while pos < s.length do
      cache(num).append(s.charAt(pos))
    pos = pos + 1
    num = if down then num + 1 else num - 1
    if num == numRows then {
      down = false
      num = numRows - 2
    }
    if num == -1 then {
      down = true
      num = 1
    }
    cache.reduce(_ ++ _).mkString("")
```

### 14. Longest Common Prefix
```scala
  def longestCommonPrefix(strs: Array[String]): String = strs match
    case Array() => ""
    case _ => var prefix = strs(0)
      strs.drop(1).foreach(str => {
        while str.indexOf(prefix) == -1 do prefix = prefix.dropRight(1)
      })
      prefix
```

### 763. Partition Labels
```scala
  def partitionLabels(s: String): List[Int] =
    val (cache, result) = (mutable.Map[Char, Int](), mutable.ListBuffer[Int]())
    var (i, start, end) = (0, 0, 0)
    s.zipWithIndex.foreach { case (char, index) => cache.update(char, index) }
    while i < s.length do
      end = cache.get(s.charAt(i)).get
      while end > i do
        i = i + 1
        end = end.max(cache.get(s.charAt(i)).get)
      result.append(end + 1 - start)
      i = (i + 1)
      start = i
      end = i
    result.toList
```
