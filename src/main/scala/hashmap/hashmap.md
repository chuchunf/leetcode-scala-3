# HashMap

Hashmap is an associative array abstract data type, which maps keys to values. 
For scenarios that we don't need to loop through every item, rather just to check the existence, 
HashMap could effectively change the complexity **from loop O(n) to lookup O(1)**.

- Two sum: the expected value is known; 
- First non-repeating character: the character is known;
- Happy number: The list of unhappy number built along the way is known.

The key idea of HashMap is to use a hash function to map keys to buckets.

Hashmap is also an effective way to hold/group discrete keys or non-number keys for easy processing

- Isomorphic Strings: char from source string and char from target string as key
- Bulls and Cows: char from source string and char from target string as key
- Wall Brick: the width of the bricks are discrete as key

If the keys are continuous number values (e.g. char value could be converted integers), array will be a better data structure.

### 1. Two Sum
```scala
  def twoSum(nums: Array[Int], target: Int): Array[Int] =
    val cache = mutable.Map[Int, Int]()
    nums.zipWithIndex.find { case (value, index) => cache.get(target - value) match
      case Some(_) => true
      case _ => cache.put(value, index).isDefined
    } match
      case Some((num, index)) => Array(cache.get(target - num).get, index)
      case _ => throw new IllegalArgumentException("invalid parameter, no valid result!")
```

### 387. First Unique Character in a String
```scala
  def firstUniqChar(s: String): Int =
    val cache = mutable.Map[Char, Int]()
    s.toArray.foreach(c => cache.update(c, cache.get(c).getOrElse(0) + 1))
    s.toArray.find(cache.get(_).get == 1) match
      case Some(result) => s.indexOf(result)
      case _ => -1
```

### 202. Happy Number
```scala
  def isHappy(n: Int): Boolean = isHappyInernal(n, mutable.Set[Int]())

  private def isHappyInernal(n: Int, cache: mutable.Set[Int]): Boolean = n match
    case num if num == 1 => true
    case num if cache.contains(num) => false
    case num => isHappyInernal(num.toString.map(c => (c - '0') * (c - '0')).sum, cache += num)
```

### 380. Insert Delete GetRandom O(1)
```scala
class InsertDeleteGetRandomO1() {
  private val map = mutable.Map[Int, Int]()
  private val array = mutable.ArrayBuffer[Int]()
  private val random = new scala.util.Random

  def insert(value: Int): Boolean =
    if map.contains(value) then
      false
    else {
      map.put(value, array.length)
      array.addOne(value)
      true
    }

  def remove(value: Int): Boolean =
    if !map.contains(value) then
      false
    else {
      array(map.get(value).get) = array(array.length - 1)
      array.dropRight(1)
      true
    }

  def getRandom(): Int = array(random.nextInt(array.length))
}
```

### 205. Isomorphic Strings
```scala
  def isIsomorphic(s: String, t: String): Boolean =
    val (smap, tmap) = (mutable.Map[Char, Char](), mutable.Map[Char, Char]())
    s.toCharArray.zip(t.toCharArray).find { case (schar, tchar) => {
      (smap.get(schar), tmap.get(tchar)) match
      case (Some(_), None) | (None, Some(_)) => true
      case (Some(char1), Some(char2)) => char1 != tchar || char2 != schar
      case (None, None) => smap.put(schar, tchar)
        tmap.put(tchar, schar)
        false
    }}.isEmpty
```

### 299. Bulls and Cows
```scala
  def getHint(secret: String, guess: String): String =
    val (scache, gcache) = (mutable.HashMap[Char, Int](), mutable.HashMap[Char, Int]())
    val bull = secret.toCharArray.zip(guess.toCharArray).foldLeft(0) {
      case (bull, (s, g)) if s == g => bull + 1
      case (bull, (s, g)) =>
        scache.update(s, scache.get(s).getOrElse(1))
        gcache.update(g, gcache.get(g).getOrElse(1))
        bull
    }
    val cow = scache.foldLeft(0) { case (cow, (k, v)) => cow + v.min(gcache.get(k).getOrElse(0)) }
    s"${bull}A${cow}B"
```

### 554. Brick Wall
First consider the simplest case, 1 row of bricks, the answer is 0 for each edge.
Consider add another row, it depends on if the edges of 2nd row matching with 1st row.
We could loop through each row and count the edges (previous wall length + current brick length), 
and the edge with large count is where the draw could be Drawn.
Hashmap could be used to keep track of each edge with correcponding count.
```scala
  def leastBricks(wall: List[List[Int]]): Int =
    val cache = mutable.Map[Int, Int]()
    wall.foreach(_.dropRight(1).foldLeft(0) { case (sum, w) =>
      cache.updateWith(sum + w) { _ => Option(cache.get(sum + w).getOrElse(0) + 1) }.get
    })
    wall.length - cache.values.max
```