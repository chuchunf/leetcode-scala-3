# Array

### 26. Remove Duplicates from Sorted Array
```scala
  def removeDuplicates(nums: Array[Int]): Int =
    nums.foldLeft(1) { case (num, index) =>
      if num > nums(index - 1) then {
        nums(index) = num
        index + 1
      } else index
    }
```

### 54. Spiral Matrix
```scala
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] =
    val result = mutable.ListBuffer[Int]()
    val size = matrix.length * matrix(0).length
    var (left, right, top, bottom) = (0, matrix(0).length - 1, 0, matrix.length - 1)
    while (result.length < size)
      for (i <- left to right) if (result.length < size) result.append(matrix(top)(i)) // left to right, same top
      top = top + 1
      for (j <- top to bottom) if (result.length < size) result.append(matrix(j)(right)) // top to bottom, same right
      right = right - 1
      for (i <- right to left by -1) if (result.length < size) result.append(matrix(bottom)(i)) // right to left, same bottom
      bottom = bottom - 1
      for (j <- bottom to top by -1) if (result.length < size) result.append(matrix(j)(left)) // bottom to top, same left
      left = left + 1
    result.toList
```

### 78. Subsets
```scala
  def subsets(nums: Array[Int]): List[List[Int]] =
    val cache = mutable.ListBuffer[List[Int]]()
    cache.addOne(List[Int]())
    nums.foreach(num => {
      val temp = mutable.ListBuffer[List[Int]]()
      cache.foreach(list => temp.addOne(mutable.ListBuffer[Int]().addAll(list).addOne(num).toList))
      cache.addAll(temp)
    })
    cache.toList
```

### 945. Minimum Increment to Make Array Unique
```scala
  def minIncrementForUnique(nums: Array[Int]): Int = nums match
    case Array(_) => 0
    case _ => val sorted = nums.sorted
      var (result, currentexpect) = (0, sorted(0) + 1)
      sorted.drop(1).foreach(num => {
        if (num < currentexpect) then
          result = result + (currentexpect - num)
          currentexpect = currentexpect + 1
        else
          currentexpect = num + 1
        end if
      })
      result
```

### 121. Best Time to Buy and Sell Stock
```scala
  def maxProfit(prices: Array[Int]): Int = prices match
    case Array(_) => 0
    case Array(head, tail) => if head < tail then tail - head else 0
    case _ => var (maxprofit, minprice) = (0, prices(0))
      prices.drop(1).foreach(price => {
        maxprofit = maxprofit.max(price - minprice)
        minprice = minprice.min(price)
      })
      maxprofit
```
