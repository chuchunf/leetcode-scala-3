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

### 161. One Edit Distance
```scala
  def isOneEditDistance(s: String, t: String): Boolean =
    if s.length == t.length then s.toCharArray.zip(t.toCharArray).count { case (sc, tc) => { !sc.equals(tc) }} == 1
    else {
      val (ss, ls) = if s.length > t.length then (t, s) else (s, t)
      var (count, sp, lp) = (0, 0, 0)
      while lp < ls.length do
        if ss(sp) != ls(lp) then count = count + 1 else sp = sp + 1
        lp = lp + 1
      count == 1
    }
```

### 165. Compare Version Numbers
```scala
  def compareVersion(version1: String, version2: String): Int =
    val (vs1, vs2) = (version1.split("\\."), version2.split("\\."))
    val maxparts = vs1.length.max(vs2.length)
    for (i <- 0 until maxparts) {
      val v1v = if i >= vs1.length then 0 else getVersion(vs1(i))
      val v2v = if i >= vs2.length then 0 else getVersion(vs2(i))
      if v1v != v2v then return v1v.compare(v2v)
    }
    0

  private def getVersion(v: String): Int = v.indexWhere(c => c.isDigit && !c.isSpaceChar) match
    case len if len >= v.length => 0
    case len => v.substring(len).toInt
```