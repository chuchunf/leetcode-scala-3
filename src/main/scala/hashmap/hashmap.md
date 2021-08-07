# HashMap

Hashmap is an associative array abstract data type, which maps keys to values. 
For scenarios that we don't need to loop through every item, rather just to check the existence, 
HashMap could effectively change the complexity **from loop O(n) to lookup O(1)**.

- Two sum: the expected value is known; 
- Repeating character: the character is known;
- Happy number: The list of unhappy number built along the way.

### 1. Two Sum
```scala
  def twoSum(nums: Array[Int], target: Int): Array[Int] =
    val cache = mutable.Map[Int, Int]()
    nums.zipWithIndex
      .find { case (value, index) => cache.get(target - value) match {
        case Some(_) => true
        case _ => cache.put(value, index); false
      }} match
      case Some((num, index)) => Array(cache.get(target - num).get, index)
      case _ => throw new IllegalArgumentException("invalid parameter, no valid result!")
```

### 387. First Unique Character in a String
```scala
  def firstUniqChar(s: String): Int =
    val cache = mutable.Map[Char, Int]()
    s.toArray.foreach(c => cache.update(c, cache.get(c).getOrElse(0) + 1))
    s.toArray.find(cache.get(_).getOrElse(0) == 1) match
    case Some(result) => s.indexOf(result)
    case _ => throw new IllegalArgumentException("no character is unique in the given string")
```

### 202. Happy Number
```scala
  def isHappy(n: Int): Boolean = isHappyInernal(n, mutable.Set[Int]())

  private def isHappyInernal(n: Int, cache: mutable.Set[Int]): Boolean = n match
    case num if num == 1 => true
    case num if cache.contains(num) => false
    case num => cache.add(num)
      isHappyInernal(getSum(num), cache)

  private def getSum(n: Int): Int =
    var (sum, num) = (0, n)
    while (num != 0) {
      val remain = num % 10
      sum = sum + remain * remain
      num = num / 10
    }
    sum
```